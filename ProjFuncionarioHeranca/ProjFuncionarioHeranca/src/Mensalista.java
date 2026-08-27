
public class Mensalista extends Funcionario {
    public double SalBruto;
    public double Desconto;
    
    //methods
    public double CalcularSalarioMensal(){
        return SalBruto * ((100- Desconto) / 100);
    }
}
