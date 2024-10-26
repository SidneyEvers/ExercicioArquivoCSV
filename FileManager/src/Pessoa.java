public class Pessoa {

    
    private int id;
    private String nome;
    private int idade;
    private String cpf;
    private Login account;

    public Pessoa(int id, String nome, int idade, String cpf, Login account) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.account = account;
    }

    public Pessoa(int id){
        this.id = id;
    }
    public Pessoa() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Login getAccount() {
        return account;
    }
    public void setAccount(Login account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + "]\n"+ account.toString();
    }

    
    
}
