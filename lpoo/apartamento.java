public class Apartamento{
    private int nMoradores; 
    private int nQuartos; 
    private double espaco;
    private double valorAluguel; 
    
    public Apartamento(int nQuar, double esp, double valorAlg){ 
        this.nQuartos = nQuar;
        this.espaco = esp;
        this.valorAluguel = valorAlg;
    }
    
    public Apartamento(int nMor, int nQuar, double esp, double valorAlg){
        this.nQuartos = nQuar;
        this.espaco = esp;
        this.valorAluguel = valorAlg;
        this.nMoradores = nMor;
    }
    
    public double dividirAluguel(){
        return this.valorAluguel/this.nMoradores;
    }
    
    public double valorporm2(){
        return this.valorAluguel/this.espaco;
    }
    
    public boolean aumentarMoradores(){
        if(nMoradores < nQuartos){
            this.nMoradores++;
            return true;
        } else return false;
    }
    
    public boolean diminuirMoradores(){
        if(nMoradores > 0){
            this.nMoradores--;
            return true;
        } else return false;
    }

    public boolean setNumQuartos(int quartos){
      if(quartos >= this.nMoradores){
        this.nQuartos = quartos;
        return true
      } else return false;
    }


    public boolean setValorAluguel(int aluguel){
      if(aluguel >= 0){
        this.valorAluguel = quartos;
        return true
      } else return false;
    }
  
    public int getnMoradores() {
      return this.nMoradores;
    }

    public int getnQuartos() {
      return this.nQuartos;
    }

    public double getEspaco() {
      return this.espaco;
    }

    public double getValorAluguel() {
      return this.valorAluguel;
    }
}