
public class Principal {

    
    public static void main(String[] args) {
       // criando a instância da classe Funcionario
       Funcionario func = new Funcionario();
       // definindo valores aos atributos
       func.nome="Alfredo";
       func.reg=1234;
       func.salbruto=5000;
       func.valordesc=500;
       // recebendo o retorno do cálculo do método
       double salario=func.CalcSalario();
       // enviar o salario ao método exibir
       func.ExibirDados(salario);
       
    }
    
}
