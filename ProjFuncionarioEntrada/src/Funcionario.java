
import javax.swing.JOptionPane;


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
        JOptionPane.showMessageDialog(null,"Nome: "+this.nome+
        "\nRegistro: "+this.reg+
        "\nSalario Bruto: "+this.salbruto+
        "\nDescontos: "+this.valordesc+
        "\nSalario Liquido: "+salario);
    }
}
