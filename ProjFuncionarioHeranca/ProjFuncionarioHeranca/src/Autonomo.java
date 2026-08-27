
public class Autonomo extends Funcionario {
    public int vendas;
    public double PercVendas;
    
    //methods
    
    public double CalcularSalario(){
        return this.vendas * (this.PercVendas / 100);
    }
}