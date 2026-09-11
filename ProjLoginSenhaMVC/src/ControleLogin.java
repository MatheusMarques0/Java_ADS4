
import javax.swing.JOptionPane;


public class ControleLogin {
    Usuario usuario = new Usuario();

    static int tentativas = 0;

    public boolean VerificaTentativas() {
        return tentativas < 3;
    }

    public void VerificaLogin(String log, int sen) {

        usuario.login = log;
        usuario.senha = sen;

        if (usuario.Logar() == true) {
            new FormEmpresa().setVisible(true);
        }
        else {
            tentativas++;

            JOptionPane.showMessageDialog(null,
                    "Usuário/Senha Incorretos\nTentativa: " + tentativas + " de 3");

            if (VerificaTentativas()) {
                new FormLoginSenha().setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "Número máximo de tentativas atingido.");
                System.exit(0);
            }
        }
    }
}