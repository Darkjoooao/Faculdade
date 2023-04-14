public class Carro {
     private String modelo;
     private int nPortas;
     private int nPassageiros;
     private double velocidade;
     private boolean estaLigado;
    
    public Carro(String mod, int nP, int nPas) {
        this.modelo = mod;
        this.nPortas = nP;
        this.nPassageiros = nPas;
        this.velocidade = 0.0;
        this.estaLigado = false;
    }

    public void ligaCarro() {
        if (!this.estaLigado) {
            this.estaLigado = true;
        }
    }

    public void acelerar(double novaV) {
        if (this.estaLigado) {
            this.velocidade += novaV;
        }
    }

    public void frear() {
        this.velocidade = 0.0;
    }

    public String devolveInformacoes() {
        return "Carro de modelo " + this.modelo + " com " + this.nPassageiros + " passageiros";
    }

    public String getModelo() {
        return this.modelo;
    }
  
    public int getnPortas() {
        return this.nPortas;
    }

    public boolean getEstaLigado() {
        return this.estaLigado;
    }
  
    public double getVelocidade() {
        return velocidade;
    }
  
    public int getnPassageiros() {
        return this.nPassageiros;
    }  
    
    public void setnPassageiros(int nPassageiros) {
        this.nPassageiros = nPassageiros;
    }
  
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
  
    public void setEstaLigado(boolean estaLigado) {
        this.estaLigado = estaLigado;
    }
}
