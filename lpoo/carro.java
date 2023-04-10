public class Carro {
     String modelo;
     int nPortas;
     int nPassageiros;
     double velocidade;
     boolean estaLigado;

    public Carro(String mod, int nP, int nPas) {
        modelo = mod;
        nPortas = nP;
        nPassageiros = nPas;
        velocidade = 0.0;
        estaLigado = false;
    }

    public void ligaCarro() {
        if (!estaLigado) {
            estaLigado = true;
        }
    }

    public void acelerar(double novaV) {
        if (estaLigado) {
            velocidade += novaV;
        }
    }

    public void frear() {
        velocidade = 0.0;
    }

    public String devolveInformacoes() {
        return "Carro de modelo " + modelo + " com " + nPassageiros + " passageiros";
    }
}
