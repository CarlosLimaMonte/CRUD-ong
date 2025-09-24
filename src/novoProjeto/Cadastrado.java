package novoProjeto;

public class Cadastrado {
    private String nome;
    private String dataDeNascimento;
    private String cpf;
    private String telefone;

    public Cadastrado(String nome, String dataDeNascimento, String cpf, String telefone){
        if (nome == null){
            throw new IllegalArgumentException("Nome não pode ser vazio!");
        }else if (dataDeNascimento == null){
            throw new IllegalArgumentException("Data de Nascimento não pode ser vazio!");
        }else if (cpf == null){
            throw new IllegalArgumentException("cpf não pode ser vazio!");
        }else if (telefone == null){
            throw new IllegalArgumentException("Telefone não pode ser vazio!");
        }
        String nomeTrim = nome.trim();
        String dataTrim = dataDeNascimento.trim();
        String cpfTrim = cpf.trim();
        String telefoneTrim = telefone.trim();

        this.nome = nomeTrim;
        this.dataDeNascimento = dataTrim;
        this.cpf = cpfTrim;
        this.telefone = telefoneTrim;
    }

    //Get e Set Nome

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        if (nome == null){
            throw new IllegalArgumentException("Nome não pode ser vazio!");
        }
        this.nome = nome.trim();
    }

    //Get e Set Data de Nascimento

    public String getDataDeNascimento(){
        return this.dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento){
        if (dataDeNascimento == null){
            throw new IllegalArgumentException("Data de nascimento não pode ser vazio!");
        }
        this.dataDeNascimento = dataDeNascimento.trim();
    }

    //Get e set cpf

    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String cpf){
        if (cpf == null){
            throw new IllegalArgumentException("O CPF não pode ser vazio!");
        }
        this.cpf = cpf.trim();
    }

    //Get e Set telefone

    public String getTelefone(){
        return this.telefone;
    }

    public void setTelefone(String telefone){
        if (telefone == null){
            throw new IllegalArgumentException("O telefone não pode ser vazio!");
        }
        this.telefone = telefone.trim();
    }
}