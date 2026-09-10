
public class Usuario {
    public String login;
    public int senha;
    
    public boolean Logar(){
        if ((this.login.equals("Antonio"))  && (this.senha==12345)){
            return true;
        }
        else{
            return false;
        }
    }
}
