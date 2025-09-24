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

}
