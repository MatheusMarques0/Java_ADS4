
public class Principal {

    
    public static void main(String[] args) {
        // Criando a instância da classe
        Aluno aluno = new Aluno();
        // atribuindo valores aos atributos públicos
        aluno.nota1=7;
        aluno.nota2=8;
        // valor da média calculado pelo retorno do método
        double med=aluno.CalcularMedia();
        // envio da média ao método Exibir
        aluno.ExibirMedia(med);
        
    }
    
}
