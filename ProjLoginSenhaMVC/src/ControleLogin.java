
import javax.swing.JOptionPane;


public class ControleLogin {
    Usuario usuario = new Usuario();
    
    public void VerificaLogin(String log, int sen){
        // As informações que vieram por parãmetros
        //serão armazenadas nos atributos
        usuario.login=log;
        usuario.senha=sen;
        //Chama o método logar que retornará true ou false,
        //retornando true deve chamar a interface FormEmpresa,
        // caso contrário chamar a interface incial
        if (usuario.Logar()==true){
            new FormEmpresa().setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuário/Senha Incorretos");
            new FormLoginSenha().setVisible(true);
        }
    }
}
