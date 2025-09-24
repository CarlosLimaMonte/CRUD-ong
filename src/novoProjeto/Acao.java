package novoProjeto;
import java.util.ArrayList;

public class Acao {
    private String nome;
    private String data;
    private String local;
    private ArrayList<Cadastrado> voluntarios;

    public Acao(String nome, String data, String local){
        if (nome == null){
            throw new IllegalArgumentException("Nome não pode ser vazio!");
        }else if (data == null){
            throw new IllegalArgumentException("Data não pode ser vazio!");
        }else if (local == null){
            throw new IllegalArgumentException("cpf não pode ser vazio!");
        }

        this.nome = nome;
        this.data = data;
        this.local = local;
        this.voluntarios = new ArrayList<>();


    }
    //Get e Setter nome
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    //Get e setter
    public String getData(){
        return this.data;
    }

    public void setData(String data){
        this.data = data;
    }

    //Get e setter
    public String getLocal(){
        return this.local;
    }

    public void setLocal(String local){
        this.local = local;
    }

    public ArrayList<Cadastrado> getVoluntarios(){
        return this.voluntarios;
    }

    public void adicionarVoluntario(Cadastrado c){
        this.voluntarios.add(c);
    }
}
