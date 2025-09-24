package novoProjeto;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int simNao = 1;
        //novoProjeto.Cadastrado c1 = new novoProjeto.Cadastrado("Carlos", "22/02/20002", "11111", "Teste");
        ArrayList<Cadastrado> listaCadastrados = new ArrayList<>();
        ArrayList<Acao> listaAcoes = new ArrayList<>();
        String cpf = null;
        int op2 = 0;
        boolean finalizar = true;

        System.out.println("Bem vindo ao nosso programa, o que você deseja fazer?");
        do {
            System.out.println("Digite 1 para cadastra um novo voluntário\nDigite 2 para consultar os cadastrados \nDigite 3 para excluir um cadastrado \nDigite 4 para alterar algum dado \nDigite 5 cadastrar uma nova ação \nDigite 6 para ver as ações \nDigite 7 para adicionar voluntários na ação \nDigite 8 para ver os voluntários de uma ação \nDigite 8 para sair do programa");
            int op = input.nextInt();
            input.nextLine();
            //Cadastra o voluntário
            switch (op) {

                //Cadastra novo voluntário

                case 1:{
                    System.out.println("Bem vindo ao cadastro de voluntários!");
                    cpf = pedeCpf(input);
                    Cadastrado encontrado = retornaCadastrado(cpf, listaCadastrados);
                    if (encontrado != null) {
                        System.out.println("CPF já cadastrado!");
                        break;
                    } else {
                        cadastraNovo(input, cpf, listaCadastrados);
                    }
                    break;
                }
                //Consulta um cadastro
                case 2: {
                    cpf = pedeCpf(input);
                    Cadastrado encontrado = retornaCadastrado(cpf, listaCadastrados);
                    if (encontrado == null) {
                        System.out.println("Nenhum cadastro localizado com o CPF: " + cpf);
                    } else {
                        consultaLista(encontrado);
                    }
                    break;
                }
                    //Exclui dados

                case 3: {
                    cpf = pedeCpf(input);
                    Cadastrado encontrado = retornaCadastrado(cpf, listaCadastrados);
                    if (encontrado == null) {
                        System.out.println("Nenhum cadastro com o CPF: " + cpf + " foi localizado!");
                    } else {
                        removeLista(cpf, listaCadastrados);
                    }
                    break;
                }

                //Atualiza Dados

                case 4: {
                    while (op2 != 4) {
                        System.out.println("Qual item você deseja alterar?\n1 - Nome\n2 - Data de Nascimento\n3 - Telefone\n4 - Cancelar");
                        op2 = input.nextInt();
                        input.nextLine();

                        //Altera o nome

                        if (op2 == 1) {
                            pedeCpf(input);
                            Cadastrado encontrado = retornaCadastrado(cpf, listaCadastrados);
                            if (encontrado == null) {
                                System.out.println("CPF não localizado!");
                            } else {
                                System.out.print("Cadastro localizado, insira o novo nome para fazer a alteração: ");
                                String nomeNovo = input.nextLine();
                                encontrado.setNome(nomeNovo);
                                System.out.print("Nome alterado com sucesso!");
                            }
                        }

                        //Altera a Data de Nascimento

                        else if (op2 == 2) {
                            cpf = pedeCpf(input);
                            Cadastrado encontrado = retornaCadastrado(cpf, listaCadastrados);
                            if (encontrado == null) {
                                System.out.println("CPF não localizado!");
                            } else {
                                System.out.print("Cadastro localizado, insira a nova data de nascimento para fazer a alteração: ");
                                String dataNova = input.nextLine();
                                encontrado.setDataDeNascimento(dataNova);
                                System.out.print("Data de Nascimento alterado com sucesso!");
                            }
                        }

                        //Altera o telefone

                        else if (op2 == 3) {
                            cpf = pedeCpf(input);
                            Cadastrado encontrado = retornaCadastrado(cpf, listaCadastrados);
                            if (encontrado == null) {
                                System.out.println("CPF não localizado!");
                            } else {
                                System.out.print("Cadastro localizado, insira o novo telefone para fazer a alteração: ");
                                String telefoneNovo = input.nextLine();
                                encontrado.setTelefone(telefoneNovo);
                                System.out.print("Telefone alterado com sucesso!");
                            }
                        } else {
                            System.out.println("Opção invalida!");
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.print("Digite a data da ação | Exemplo: 22/04/2025");
                    String dataAcao = input.nextLine();
                    if (dataAcao(dataAcao, listaAcoes)) {
                        System.out.println("Já existem ações para o dia " + dataAcao + "Deseja continuar?\n1 - Para sim | 2 - Para não:");
                        simNao = input.nextInt();
                        input.nextLine();
                    }
                    do {
                        if (simNao == 1) {
                            adicionaAcao(input, dataAcao, listaAcoes);
                            break;
                        } else if (simNao == 2) {
                            System.out.println("Cadastro de nova ação cancelado!");
                            break;
                        } else {
                            System.out.print("Opção invalida! Insira novamente: ");
                            simNao = input.nextInt();
                        }
                    } while (simNao != 1 && simNao != 2);
                    break;
                }
                case 6: {
                    apresentaAcao(listaAcoes);
                    break;
                }
                case 7: {
                    cpf = pedeCpf(input);
                    System.out.print("Insira o nome da ação: ");
                    String nomeAcao = input.nextLine();
                    Cadastrado encontrado = retornaCadastrado(cpf, listaCadastrados);
                    Acao encontrado1 = retornaAcao(nomeAcao, listaAcoes);
                    if(encontrado == null) {
                        System.out.println("Nenhum cadastrado foi localizado!");
                    }
                    if(encontrado1 == null) {
                        System.out.println("Nenhuma ação localizada! ");
                    }

                    if(encontrado1 != null && encontrado != null){
                        adicionaCadastrado(encontrado, encontrado1);
                    }
                    break;
                }
                case 8: {
                    System.out.print("Digite o nome da ação: ");
                    String nomeAcao = input.nextLine();
                    Acao encontrado1 = retornaAcao(nomeAcao, listaAcoes);
                    if(encontrado1 == null) {
                        System.out.println("Nenhum acao foi localizada!");
                    }else{
                        apresentaVoluntarios(encontrado1);
                    }
                    break;
                }
                case 9: {
                    finalizar = false;
                    break;
                }
            }
        }while (finalizar);
    }

    public static boolean verificaCpf(String cpf){
        int idx = 0;
        int nDigitos = 0;
        int soma1 = 0;
        int soma2 = 0;
        char[] construtor = new char[11];
        char digito = ' ';
        if (cpf.length() == 14) {
            for (int i = 0; i < cpf.length(); i++) {
                digito = cpf.charAt(i);
                if (Character.isDigit(digito)){
                    construtor[idx] = digito;
                    nDigitos += 1;
                    idx++;
                }
            }
        }else {
            return false;
        }
        if (nDigitos < 11){
            return false;
        }else {
            //Verifica o primeiro digito
            for (int i = 0; i <= 8; i++){
                soma1 = ((construtor[i] - '0') * (10-i)) + soma1;
            }
            int digito1 = soma1 % 11;
            if (digito1 < 2){
                digito1 = 0;
            }else{
                digito1 = 11 - digito1;
            }
            //Verifica o segundo digito
            for (int i = 0; i <= 9; i++){
                soma2 = ((construtor[i] - '0') * (11 - i)) + soma2;
            }
            int digito2 = soma2 % 11;
            if (digito2 < 2){
                digito2 = 0;
            }else{
                digito2 = 11 - digito2;
            }
            //System.out.println("Digito 1: " + digito1 + "\nDigito 2: " +  digito2);
            if(digito1 == (construtor[9] - '0') && digito2 == (construtor[10] - '0')){
                return true;
            }else{
                return false;
            }
        }
    }

    public static Cadastrado retornaCadastrado(String cpf, ArrayList<Cadastrado> listaCadastrados){
        for(Cadastrado c: listaCadastrados){
            if (c.getCpf().equals(cpf)){
                return c;
            }
        }
        return null;
    }
    public static void cadastraNovo(Scanner input, String cpf, ArrayList<Cadastrado> lista){
        System.out.println("Digite seu nome: ");
        String nome = input.nextLine();
        System.out.println("Digite sua data de nascimento | Exemplo: 01/01/2000: ");
        String dataDeNascimento = input.nextLine();
        System.out.println("Digite seu telefone: ");
        String telefone = input.nextLine();

        //Adiciona o cadastro novo na lista de cadastrados

        Cadastrado novo = new Cadastrado(nome, dataDeNascimento, cpf, telefone);
        lista.add(novo);
        System.out.println("Cadastrado com sucesso!");
    }
    public static void consultaLista(Cadastrado c){
                System.out.println("Nome: " + c.getNome() + "\nCPF: " + c.getCpf() + "\nTelefone: " + c.getTelefone() + "\nData de Nascimento: " + c.getDataDeNascimento());
    }
    public static void removeLista(String cpf, ArrayList<Cadastrado> lista){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getCpf().equals(cpf)){
                lista.remove(i);
                System.out.println("Cadastro sobre o CPF: " + cpf + " Excluido com sucesso!");
                break;
            }
        }

    }
    public static String pedeCpf(Scanner input){
        System.out.print("Digite seu CPF | Exemplo: 111.111.111-22");
        String cpf = input.nextLine();
        while(!verificaCpf(cpf)){
            System.out.print("CPF Invalido insira novamente: ");
            cpf = input.nextLine();
        }
        return cpf;
    }

    public static boolean dataAcao(String data, ArrayList<Acao> lista){
        boolean verificador = false;
        for(Acao a: lista){
            if(a.getData().equals(data)){
                System.out.println("Na mesma data temos as ações: " + a.getNome());
                verificador = true;
            }
        }

        if(!verificador){
            System.out.println("Não há nenhum evento nessa data!");
            return false;
        }else{
            return true;
        }
    }

    public static void adicionaAcao(Scanner input, String data, ArrayList<Acao> lista){
        System.out.print("Insira o nome do evento: ");
        String nome = input.nextLine();
        System.out.print("Insira o local do evento: ");
        String local = input.nextLine();

        Acao novo = new Acao(nome, local, data);
        lista.add(novo);
        System.out.println("Ação cadastrada com sucesso!");
    }

    public static void apresentaAcao(ArrayList<Acao> lista){
        int tamanhoLista = lista.size();
        if (tamanhoLista > 0) {
            for (Acao a : lista) {
                System.out.println(a.getNome() + "está marcada para acontecer no dia: " + a.getData() + "no local: " + a.getLocal());
            }
        }else{
            System.out.println("Nenhuma ação programada!");
        }
    }
    public static Acao retornaAcao(String nome, ArrayList<Acao> lista){
        for(Acao a: lista){
            if(a.getNome().equals(nome)){
                return a;
            }
        }
        return null;
    }
    public static void adicionaCadastrado(Cadastrado c, Acao a){
        a.adicionarVoluntario(c);
        System.out.println("Voluntário cadastrado com sucesso!");
    }

    public static void apresentaVoluntarios(Acao a){
        if(a.getVoluntarios().isEmpty()){
            System.out.println("Nenhum voluntário cadastrado");
        }else {
            ArrayList<Cadastrado> lista = a.getVoluntarios();
            System.out.println("Os voluntários da ação " + a.getNome() + " são:");
            for(Cadastrado c: lista){
                System.out.println(c.getNome());
            }
        }
    }
}

