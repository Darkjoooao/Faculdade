public class Veiculo{
    protected String modelo;
    protected int nRodas;
    protected double peso;
    protected double velocidade;

    public Veiculo(String mod, int qRodas, double nPeso){
        this.modelo = mod ;
        this.nRodas = qRodas;
        this.peso = nPeso;
    }
    public void acelerar(){

    }
    public String toString(){

    }
    
    { // setters and getters
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getnRodas() {
        return nRodas;
    }
    public void setnRodas(int nRodas) {
        this.nRodas = nRodas;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
    }
}

public class Carro extends Veiculo{
    private int nCilindros;

    public void Carro(String mod, int nPeso, int qCilindros){
        this.modelo = mod;
        this.peso = nPeso;
        this.nCilindros = qCilindros;
    }

    public void acelerar() {
        
    }
    public String toString() {
        
    }
    {// setters and getters
        public int getnCilindros() {
            return nCilindros;
        }
    
        public void setnCilindros(int nCilindros) {
            this.nCilindros = nCilindros;
        }
    }
}

public class Moto  extends Veiculo{
    private String cor;
    private double comprimento;
    
    public void Moto(String mod, int nPeso, double nComprimento, String nCor) {
        this.modelo = mod;
        this.peso = nPeso;
        this.cor = nCor;
        this.comprimento = nComprimento;
    }

    public void acelerar() {
        
    }
    public String toString() {
        
    }
    {// setters and getters
    
    public String getColor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }
    }
}