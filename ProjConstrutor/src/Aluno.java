
/**
 *
 * Este projeot utiliza 2 métodos construtores 
 */
public class Aluno {
    public String nome;
    public int idade;
    
    //metodo que define os valores aos atributos
    public Aluno(){
        this("Ana",18);
    }
    //método que recebe os valores e aloca os atributos
    public Aluno (String nm, int id){
        this.nome=nm;
        this.idade=id;
    }
}
