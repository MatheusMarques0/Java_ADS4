
import javax.swing.JOptionPane;

/**
 *
 * @author alunocmc
 */
public class Produto {
    public String descricao;
    public int estoque;
    public double vl_compra;
    public double vl_venda;
    public double totvendas;
    
    //Construtores
    
    public Produto(){
        this(100,10);
    }
    
    public Produto(int est, double vl_cp){
        this.estoque=est;
        this.vl_compra=vl_cp;
        this.vl_venda=1.5*vl_cp;
    }
    
    //Metodos:
    public void EfeturarVenda(int qt){
        if (this.estoque>=qt){
            this.estoque-=qt;
            JOptionPane.showMessageDialog(null, "Venda Registrada!!!!");
        }
        else {
            JOptionPane.showMessageDialog(null, "Quantidade em estoque insuficiente!!!!");
        }}
    
    public void CalcularVendas(double vl){
        this.totvendas+=vl;
    }
    
    public Double TotalVendas(){
        return this.vl_venda * this.totvendas;
    }
    }
