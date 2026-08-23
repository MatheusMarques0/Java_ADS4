
import javax.swing.JOptionPane;


public class Principal {

   
    public static void main(String[] args) {
        Funcionario func = new Funcionario();
        // entradas através da classe JOptionPane
        func.nome=JOptionPane.showInputDialog("Digite seu nome: ");
        // convertendo para tipo inteiro
        func.reg=Integer.parseInt(JOptionPane.showInputDialog("Digite o registro: "));
        // convertendo para tipo real
        func.salbruto=Double.parseDouble(JOptionPane.showInputDialog("Salario Bruto: "));
        func.valordesc=Double.parseDouble(JOptionPane.showInputDialog("Desconto: "));
        double salario=func.CalcSalario();
        func.ExibirDados(salario);
    }
    
}
