
/**
 *
 * este projeto utiliza um consultor e os valores ssão repassados pela
 * instância da classe
 * 
 */
public class Principal {

    public static void main(String[] args) {
        //na cria~]ao da instância da classe definimos os valores dos
        //atributos
        Aluno aluno =new Aluno("Ana", 18);
        //exibindo os valores armazenados nos atributos
        System.out.println("Nome: "+aluno.nome);
        System.out.println("Idade: "+aluno.idade);
    }
    
}
