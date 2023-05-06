// Programa paralelo
// João Pedro Mont' Serrat Nantes 201719040257
// Rodrigo Hideho Kamada Tanaka 202019040350
// Converte grafo direcionado do formato de matriz de adjacÃªncias para lista de arestas
// Compilar com: gcc converte_paralel.cpp -fopenmp -o converte_paralel -Wall
// Executar por linha de comando: ./converte_paralel arquivo_entrada arquivo_saida


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <omp.h>

// ----------------------------------------------------------------------------
// VariÃ¡veis globais
int nVertices;	// NÃºmero de vÃ©rtices do grafo
int	 nArestas;	// NÃºmero de arestas do grafo
int **matAdj;	// Matriz de adjacÃªncias do grafo
int **arestas;	// Lista de arestas do grafo

// ----------------------------------------------------------------------------
void inicializa(char* nome_arq_entrada)
{
	FILE *arq_entrada;	// Arquivo texto de entrada

	arq_entrada = fopen(nome_arq_entrada, "rt");

	if (arq_entrada == NULL)
	{
		printf("\nArquivo texto de entrada nÃ£o encontrado\n");
		exit(1);
	}

	// LÃª nÃºmero de vÃ©rtices do arquivo de entrada
	fscanf(arq_entrada, "%d", &nVertices);

	// Aloca matriz de adjacÃªncias (*** checar se conseguiu alocar)
	matAdj = (int **)malloc(nVertices * sizeof (int*));
	for (int i = 0; i < nVertices; i++)
		matAdj[i]= (int *)malloc(nVertices * sizeof (int));

	// LÃª matriz de adjacÃªncias do arquivo de entrada
	for (int i = 0; i < nVertices; i++)
		for (int j = 0; j < nVertices; j++)
			fscanf(arq_entrada, "%d", &(matAdj[i][j]));

	fclose(arq_entrada);
}

// ----------------------------------------------------------------------------
void aloca_arestas()
{
	// Aloca lista de arestas (*** checar se conseguiu alocar)
	arestas = (int **)malloc(nArestas * sizeof (int*));
	for (int i = 0; i < nArestas; i++)
		arestas[i] = (int *)malloc(2 * sizeof (int));
}

// ----------------------------------------------------------------------------

void conta_arestas() {
    #pragma omp parallel for reduction(+: nArestas)
    for (int i = 0; i < nVertices; i++) {
        for (int j = 0; j < nVertices; j++) {
            if (matAdj[i][j] != 0) {
                nArestas++;
            }
        }
    }
}



void converte() {
    int k = 0; // Inicialmente, lista de arestas estÃ¡ vazia

    #pragma omp parallel for collapse(2)
    for (int i = 0; i < nVertices; i++) {
        for (int j = 0; j < nVertices; j++) {
            if (matAdj[i][j] != 0) {
                int index = 0;

                #pragma omp atomic capture
                {
                    index = k;
                    k++;
                }

                arestas[index][0] = i;
                arestas[index][1] = j;
            }
        }
    }
}



/*void conta_arestas()
{
	nArestas = 0;

	for (int i = 0; i < nVertices; i++)
		for (int j = 0; j < nVertices; j++)
			if (matAdj[i][j] != 0)
				nArestas++;
}

// ----------------------------------------------------------------------------

void converte()
{
	int k = 0;	// Inicialmente, lista de arestas estÃ¡ vazia

	for (int i = 0; (i < nVertices) && (k < nArestas); i++)
		for (int j = 0; (j < nVertices) && (k < nArestas); j++)
			if (matAdj[i][j] != 0)
			{
				arestas[k][0] = i;
				arestas[k][1] = j;
				k++;
			}
}*/

// ----------------------------------------------------------------------------
void finaliza(char* nome_arq_saida)
{
	FILE *arq_saida;	// Arquivo texto de saÃ­da

	arq_saida = fopen(nome_arq_saida, "wt");

	// Escreve nÃºmero de arestas no arquivo de saÃ­da
	fprintf(arq_saida, "%d\n", nArestas);

	// Escreve lista de arestas no arquivo de saÃ­da
	for (int i = 0; i < nArestas; i++)
		fprintf(arq_saida, "%d %d\n", arestas[i][0], arestas[i][1]);

	fclose(arq_saida);

	// Libera lista de arestas
	for (int i = 0; i < nArestas; i++)
		free(arestas[i]);
	free(arestas);

	// Libera matriz de adjacÃªncias
	for (int i = 0; i < nVertices; i++)
		free(matAdj[i]);
	free(matAdj);
}

// ----------------------------------------------------------------------------
int main(int argc, char** argv)
{
	char nome_arq_entrada[100],
		  nome_arq_saida[100] ;

	if(argc != 3)
	{
		printf("O programa foi executado com parÃ¢metros incorretos.\n");
		printf("Uso: ./converte_seq arquivo_entrada arquivo_saÃ­da\n");
		exit(1);
	}

	// ObtÃ©m nome dos arquivos de entrada e saÃ­da
	strcpy(nome_arq_entrada, argv[1]) ;
	strcpy(nome_arq_saida, argv[2]) ;

	// LÃª arquivo de entrada e inicializa estruturas de dados
	inicializa(nome_arq_entrada);

	double tini = omp_get_wtime(); // MediÃ§Ã£o de tempo exclui entrada, saÃ­da, alocaÃ§Ã£o e liberaÃ§Ã£o

	// Determina nÃºmero de arestas do grafo, a partir da matriz de adjacÃªncias
	conta_arestas();

	double tfin = omp_get_wtime();
	double tempo1 = tfin - tini;

	// Aloca lista de arestas
	aloca_arestas();

	tini = omp_get_wtime(); // MediÃ§Ã£o de tempo exclui entrada, saÃ­da, alocaÃ§Ã£o e liberaÃ§Ã£o

	// ObtÃ©m lista de arestas do grafo, a partir da matriz de adjacÃªncias
	converte();

	tfin = omp_get_wtime();
	double tempo2 = tfin - tini;
	double tempo = tempo1 +tempo2;
	printf("Tempo: %f + %f = %f s\n", tempo1, tempo2, tempo);

	// Escreve arquivo de saÃ­da e finaliza estruturas de dados
	finaliza(nome_arq_saida);

	return 0 ;
}