
import javax.swing.JOptionPane;

public class Conta_Corrente {
    
    public String nome_cliente;
    public int num_conta;
    public String banco;
    public double saldo;
    
    public void Depositar(double vl){
        this.saldo+=vl;
        JOptionPane.showMessageDialog(null,"Deposito realizado com sucesso !!!");
    }
    public void Sacar(double vl){
        if (this.saldo>=vl){
            this.saldo-=vl;
            JOptionPane.showMessageDialog(null,"Saque realizado com sucesso !!!");
        }
        else{
            JOptionPane.showMessageDialog(null,"Saldo Insuficiente !!!");
        }
    }
    public double ConsultarSaldo(){
        return this.saldo;
    }
}
