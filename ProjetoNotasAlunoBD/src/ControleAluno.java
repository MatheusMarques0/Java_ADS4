
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;


public class ControleAluno {
    
    Aluno aluno = new Aluno();
    
    Connection conexao;
    PreparedStatement instrucaosql;
    Statement comando;
    ResultSet lista;
    
    public void Conectar(){
        try{
            // definição de variáveis com as informações para conexão
            String usuario="root";
            String senha="";
            String nomebanco="notasalunobd";
            String servidor="localhost:3306";
            String driver="com.mysql.cj.jdbc.Driver";
            // carregando o driver
            Class.forName(driver);
            String url="jdbc:mysql://"+servidor+"/"+nomebanco+"?useTimezone=true&serverTimezone=UTC";
            conexao = DriverManager.getConnection(url,usuario,senha);
            comando=conexao.createStatement();
            
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Problemas no Driver JDBC");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Problemas no acesso ao BD");
        }
    }
    
    public void Cadastrar(int rgm, String nm, double n1, double n2){
        // os dados da interface devem ir para a classe Aluno
        aluno.setRgm(rgm);
        aluno.setNome(nm);
        aluno.setNota1(n1);
        aluno.setNota2(n2);
        try{
            instrucaosql=conexao.prepareStatement("Insert into alunos (rgm,nome,nota1,nota2) values (?,?,?,?)");
            instrucaosql.setInt(1,aluno.getRgm());
            instrucaosql.setString(2, aluno.getNome());
            instrucaosql.setDouble(3, aluno.getNota1());
            instrucaosql.setDouble(4, aluno.getNota2());
            // enviando instrução ao mysql e veficando se houve alteração de registros na tabela
            int verifica=instrucaosql.executeUpdate();
            if (verifica==1){
                // houve alteração na tabela com 1 registro alterado
                JOptionPane.showMessageDialog(null,"Dados cadastrados no banco com sucesso !!!!");
            }
            else{
                // se não retornou 1 é porque nenhum registro foi alterado
                JOptionPane.showMessageDialog(null,"Dados não Cadastrados");
            }
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Problemas no acesso ao BD");
        }
        
    }
    public void Listar(){
        try{
            instrucaosql=conexao.prepareStatement("select * from alunos");
            // lista recebe um conunto de registros
            lista=instrucaosql.executeQuery();
            // A lista é percorrida pela condição "enquanto houver o próximo"
            while(lista.next()){
                // cada elemento do registro é separado pelo nome do campo
                System.out.println("RGM: "+lista.getString("rgm"));
                System.out.println("NOME: "+lista.getString("nome"));
                System.out.println("NOTA 1: "+lista.getString("nota1"));
                System.out.println("NOTA 2: "+lista.getString("nota2"));
                System.out.println();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Problemas no acesso ao BD");
        }
    }
    public String Consultar(int rgm){
        String registro="";
        try{
            instrucaosql=conexao.prepareStatement("select * from alunos where rgm="+rgm);
            lista=instrucaosql.executeQuery();
            if (lista.next()){
                // variável recebe cada dado separado por ; ex: 1234;Antonio;5;4
                registro=lista.getString("nome")+";"+
                         lista.getString("nota1")+";"+
                         lista.getString("nota2");
                
            }
            else{
                JOptionPane.showMessageDialog(null,"Aluno não encontrado !!!");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Problemas no acesso ao BD");
        }
        return registro;
    }
    public void Excluir(int rgm){
        try{
            instrucaosql=conexao.prepareStatement("delete from alunos where rgm="+rgm);
            int verifica=instrucaosql.executeUpdate();
            if (verifica==1){
                JOptionPane.showMessageDialog(null,"Aluno excluído com sucesso !!!");
            }
            else{
                JOptionPane.showMessageDialog(null,"Aluno não encontrado !!!");
            }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null,"Problemas no acesso ao BD");
        }
    }
    public void Alterar(int rgm,String nm, double n1,double n2){
        try{
            instrucaosql=conexao.prepareStatement
                   ("update alunos set nome='"+nm+"',nota1='"+n1+"',nota2='"+n2+"' where rgm="+rgm);
            int verifica=instrucaosql.executeUpdate();
            if (verifica==1){
                JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso !!!");
            }
            else{
                JOptionPane.showMessageDialog(null,"Aluno não encontrado !!!");
            }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null,"Problemas no acesso ao BD");
        }
    }
}
 

