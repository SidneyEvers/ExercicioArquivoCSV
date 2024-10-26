public class Login {

    private String userName;
    private String passWord;
    private int nivelAcesso;

    public Login() {
    }

    public Login( String userName, String passWord, int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean EfetuaLogin(String user, String pass) {
        
        if (userName.equals(user) && passWord.equals(pass)) {
            return true;
        }
        else
        {
            return false;
        }

    }

    @Override
    public String toString() {
        return "Login [userName=" + userName + ", passWord=" + passWord + ", nivelAcesso=" + nivelAcesso + "]";
    }

}