import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class ControleAparelho {
    Aparelho aparelho = new Aparelho();
    
    Connection conexao;
    PreparedStatement instrucaosql;
    Statement comando;
    ResultSet lista;


    public void Conectar(){
        try{
            // definição de variáveis com as informações para conexão
            String usuario="root";
            String senha="";
            String nomebanco="AparelhosDB";
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
    
     public void Cadastrar(String Aparelho, String NS, int numero, String antecedentes, String estado, String validade){
        aparelho.setAparelho(Aparelho);
        aparelho.setNS(NS);
        aparelho.setNumero(numero);
        aparelho.setAntecedente(antecedentes);
        aparelho.setEstado(estado);
        aparelho.setValidade(validade);
        try{
            instrucaosql=conexao.prepareStatement("Insert into Dispositivo (aparelho,NS,numero,antecedente, estado, Validade) values (?,?,?,?,?,?)");
            instrucaosql.setString(1,aparelho.getAparelho());
            instrucaosql.setString(2, aparelho.getNS());
            instrucaosql.setInt(3, aparelho.getNumero());
            instrucaosql.setString(4, aparelho.getAntecedente());
            instrucaosql.setString(5, aparelho.getEstado());
            instrucaosql.setString(6, aparelho.getValidade());
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
    
    public void Listar(String consulta) {
    try {
        instrucaosql = conexao.prepareStatement(consulta);
        lista = instrucaosql.executeQuery();

        while (lista.next()) {
            System.out.println("Aparelho: " + lista.getString("aparelho"));
            System.out.println("NS: " + lista.getString("NS"));
            System.out.println("Numeração: " + lista.getString("numero"));
            System.out.println("Antecedente: " + lista.getString("antecedente"));
            System.out.println("Estado do Aparelho: " + lista.getString("estado"));
            System.out.println("Garantia do aparelho: " + lista.getString("Validade"));
            System.out.println();
        }
    }
    catch(Exception e) {
        JOptionPane.showMessageDialog(null, "Problemas no acesso ao BD: " + e.getMessage());
    }
}
     
     public String Consultar(String NS){
        String registro="";
        try{
            instrucaosql=conexao.prepareStatement(
                    "select * from Dispositivo where NS = ?"
            );
            instrucaosql.setString(1, NS);
            lista=instrucaosql.executeQuery();
            if (lista.next()){
                registro=lista.getString("aparelho")+";"+
                         lista.getString("numero")+";"+
                         lista.getString("antecedente")+";"+
                        lista.getString("estado")+";"+
                        lista.getString("Validade");                
            }
            else{
                JOptionPane.showMessageDialog(null,"Aparelho não encontrado !!!");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Problemas no acesso ao BD");
        }
        return registro;
    }
     public void Excluir(String NS){
        try{
            instrucaosql=conexao.prepareStatement(
            "delete from Dispositivo where NS = ?"
            );
            
            instrucaosql.setString(1, NS);
            int verifica=instrucaosql.executeUpdate();
            if (verifica==1){
                JOptionPane.showMessageDialog(null,"Aparelho excluído com sucesso !!!");
            }
            else{
                JOptionPane.showMessageDialog(null,"Aparelho não encontrado !!!");
            }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null,"Problemas no acesso ao BD");
        }
    }
      public void Alterar(String aparelho,String NS, int numero, String antecedente, String estado, String Validade){
        try{
            instrucaosql=conexao.prepareStatement(
            "update Dispositivo set aparelho = ?, numero = ?, " +
            "antecedente = ?, estado = ?, Validade = ? where NS = ?"
            );
                   
            instrucaosql.setString(1, aparelho);
            instrucaosql.setInt(2, numero);
            instrucaosql.setString(3, antecedente);
            instrucaosql.setString(4, estado);
            instrucaosql.setString(5, Validade);
            instrucaosql.setString(6, NS);

            
            int verifica=instrucaosql.executeUpdate();
            if (verifica==1){
                JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso !!!");
            }
            else{
                JOptionPane.showMessageDialog(null,"Aparelho não encontrado !!!");
            }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null,"Problemas no acesso ao BD");
        }
    }
      
     public void ListarTodos() {
    Listar("SELECT * FROM Dispositivo");}
     
     public void ListarFuncionando() {
    Listar("SELECT * FROM Dispositivo WHERE estado = 'Funcionando'");
     }
     
     public void ListarTabletsFuncionando() {
    Listar("SELECT * FROM Dispositivo WHERE aparelho = 'Tablet' AND estado = 'Funcionando'");
     }
     
     public void ListarNotebooksFuncionando() {
    Listar("SELECT * FROM Dispositivo WHERE aparelho = 'Notebook' AND estado = 'Funcionando'");
}
     
    public void ListarManutencao() {
    Listar("SELECT * FROM Dispositivo WHERE estado = 'Manutenção'");
}
    public void ListarQuebrados() {
    Listar("SELECT * FROM Dispositivo WHERE estado = 'Quebrado'");
}
    
  public void TotalFuncionando() {
    try {
        instrucaosql = conexao.prepareStatement(
            "SELECT COUNT(*) AS total FROM Dispositivo WHERE estado = 'Funcionando'"
        );

        lista = instrucaosql.executeQuery();

        if (lista.next()) {
            JOptionPane.showMessageDialog(null,
                "Total de aparelhos funcionando: " + lista.getInt("total"));
        }
    }
    catch(Exception e) {
        JOptionPane.showMessageDialog(null,
            "Problemas no acesso ao BD: " + e.getMessage());
    }
  }
    
}