
public class Horista extends Funcionario {
    public double numhoras;
    public double valorhora;
    
    //methods
    
    public double CalcularSalario(){
        return this.numhoras * this.valorhora;
    }
}
