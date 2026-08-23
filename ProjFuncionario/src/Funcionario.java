
public class Funcionario {
    public String nome;
    public int reg;
    public double salbruto;
    public double valordesc;
    
    public double CalcSalario(){
        double salario=this.salbruto-this.valordesc;
        return salario;
    }
    public void ExibirDados(double salario){
        System.out.println("Nome: "+this.nome);
        System.out.println("Registro: "+this.reg);
        System.out.println("Salario Bruto: "+this.salbruto);
        System.out.println("Descontos: "+this.valordesc);
        System.out.println("Salario Liquido: "+salario);
    }
}
