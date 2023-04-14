public class Produto{
    private String nome;
    private double valor;
    private double peso;
    private int quantidade;
    
    public Produto(String nNome, double nValor, double nPeso){
        this.nome = nNome;
        this.valor = nValor;
        this.peso = nPeso;
    }
    
    public Produto(String nNome, double nValor, double nPeso, int quant){
        this.nome = nNome;
        this.valor = nValor;
        this.peso = nPeso;
        this.quantidade = quant;
    }
    
    public double devolveValorAgregado(){
        return this.quantidade*this.valor;    
    }
    
    public double devolvePesoAgregado(){
        return this.quantidade*this.peso;
    }
    
    public double converteEmDolares(double cotacaoUSD){
        return this.valor/cotacaoUSD;
    }
  public String getNome() {
        return this.nome;
    }
    
    public double getValor() {
        return this.valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public double getPeso() {
        return this.peso;
    }
  
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}