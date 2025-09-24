package novoProjeto;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //novoProjeto.Cadastrado c1 = new novoProjeto.Cadastrado("Carlos", "22/02/20002", "11111", "Teste");
        ArrayList<Cadastrado> listaCadastrados = new ArrayList<Cadastrado>();
        String cpf = null;
        boolean localizado = false;
        int op = 0;
        int op2 = 0;
        boolean finalizar = true;

        System.out.println("Bem vindo ao cadastro de voluntários, o que você deseja fazer?");
        do {
            System.out.println("Digite 1 para cadastra um novo voluntário\nDigite 2 para consultar os cadastrados \nDigite 3 para excluir um cadastrado \nDigite 4 para alterar algum dado \nDigite 5 para ver as ações \nDigite 6 para cadastrar em uma nova ação \nDigite 7 para sair do programa");
            op = input.nextInt();
            input.nextLine();
            //Cadastra o voluntário
            switch (op){

                //Cadastra novo voluntário

                case 1:
                    System.out.println("Bem vindo ao cadastro de voluntários!");
                    cpf = pedeCpf(input);

                    if (localizaLista(cpf, listaCadastrados)){
                        System.out.println("CPF já cadastrado!");
                        break;
                    }else {
                        cadastraNovo(input, cpf, listaCadastrados);
                    }

                //Consulta um cadastro
                case 2:
                    cpf = pedeCpf(input);

                    if(!localizaLista(cpf, listaCadastrados)){
                        System.out.println("Nenhum cadastro localizado com o CPF: " + cpf);
                    }else {
                       consultaLista(cpf, listaCadastrados);
                    }

                    //Exclui dados

                    case 3:
                    System.out.print("Digite o CPF a ser excluido | Exemplo: 111.111.111-84: ");
                    cpf = input.nextLine();
                    while(!verificaCpf(cpf)){
                        System.out.print("Cpf invalido insira novamente: ");
                        cpf = input.nextLine();
                    }

                    if(!localizaLista(cpf, listaCadastrados)){
                        System.out.println("Nenhum cadastro com o CPF: " + cpf + " foi localizado!");
                    }else {
                        removeLista(cpf, listaCadastrados);
                    }

                //Atualiza Dados

                case 4:
                    while (op2 != 4) {
                        System.out.println("Qual item você deseja alterar?\n1 - Nome\n2 - Data de Nascimento\n3 - Telefone\n4 - Cancelar");
                        op2 = input.nextInt();
                        input.nextLine();
                        //Altera o nome
                        if (op2 == 1) {
                            System.out.print("Digite o CPF que você quer fazer a alteração do nome | Exemplo: 111.111.111-84: ");
                            cpf = input.nextLine();
                            while (!verificaCpf(cpf)) {
                                System.out.println("CPF invalido insira novamente: ");
                                cpf = input.nextLine();
                            }

                            if (!localizaLista(cpf, listaCadastrados)) {
                                System.out.println("CPF não localizado!");
                            } else {
                                for (Cadastrado c : listaCadastrados) {
                                    if (c.getCpf().equals(cpf)) {
                                        System.out.print("Cadastro localizado, insira o novo nome para fazer a alteração: ");
                                        String nomeNovo = input.nextLine();
                                        c.setNome(nomeNovo);
                                        System.out.print("Nome alterado com sucesso!");
                                        break;
                                    }
                                }
                            }
                        }
                        //Altera a Data de Nascimento
                        else if (op2 == 2) {
                            System.out.print("Digite o CPF que você quer fazer a alteração da Data de Nascimento | Exemplo: 111.111.111-84: ");
                            cpf = input.nextLine();
                            while (!verificaCpf(cpf)) {
                                System.out.println("CPF invalido insira novamente: ");
                                cpf = input.nextLine();
                            }

                            if (!localizaLista(cpf, listaCadastrados)) {
                                System.out.println("CPF não localizado!");
                            } else {
                                for (Cadastrado c : listaCadastrados) {
                                    if (c.getCpf().equals(cpf)) {
                                        System.out.print("Cadastro localizado, insira a nova data de nascimento para fazer a alteração: ");
                                        String dataNova = input.nextLine();
                                        c.setDataDeNascimento(dataNova);
                                        System.out.print("Data de Nascimento alterado com sucesso!");
                                        break;
                                    }
                                }
                            }
                        }
                        //Altera o telefone
                        else if (op2 == 3) {
                            System.out.print("Digite o CPF que você quer fazer a alteração do telefone | Exemplo: 111.111.111-84: ");
                            cpf = input.nextLine();
                            while (!verificaCpf(cpf)) {
                                System.out.println("CPF invalido insira novamente: ");
                                cpf = input.nextLine();
                            }

                            if (!localizaLista(cpf, listaCadastrados)) {
                                System.out.println("CPF não localizado!");
                            } else {
                                for (Cadastrado c : listaCadastrados) {
                                    if (c.getCpf().equals(cpf)) {
                                        System.out.print("Cadastro localizado, insira o novo telefone para fazer a alteração: ");
                                        String telefoneNovo = input.nextLine();
                                        c.setTelefone(telefoneNovo);
                                        System.out.print("Telefone alterado com sucesso!");
                                        localizado = true;
                                        break;
                                    }
                                }
                            }
                    }
                }
                case 8:
                    finalizar = false;
            }
        }while (finalizar);
    }

    public static Boolean verificaCpf(String cpf){
        int idx = 0;
        int nDigitos = 0;
        int soma1 = 0;
        int soma2 = 0;
        char[] construtor = new char[11];
        char digito = ' ';
        int digito1 = 0;
        int digito2 = 0;
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
            digito1 = soma1 % 11;
            if (digito1 < 2){
                digito1 = 0;
            }else{
                digito1 = 11 - digito1;
            }
            //Verifica o segundo digito
            for (int i = 0; i <= 9; i++){
                soma2 = ((construtor[i] - '0') * (11 - i)) + soma2;
            }
            digito2 = soma2 % 11;
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
    public static Boolean localizaLista(String cpf, ArrayList<Cadastrado> listaCadastrados){
        for(Cadastrado c: listaCadastrados){
            if (c.getCpf().equals(cpf)){
                return true;
            }
        }
        return false;
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
        System.out.println("novoProjeto.Cadastrado com sucesso!");
    }
    public static void consultaLista(String cpf, ArrayList<Cadastrado> lista){
        for(Cadastrado c: lista){
            if(c.getCpf().equals(cpf)){
                System.out.println("Nome: " + c.getNome() + "\nCPF: " + c.getCpf() + "\nTelefone: " + c.getTelefone() + "\nData de Nascimento: " + c.getDataDeNascimento());
                break;
            }
        }
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
        System.out.print("Digite seu CPF");
        String cpf = input.nextLine();
        while(!verificaCpf(cpf)){
            System.out.print("CPF Invalido insira novamente: ");
            cpf = input.nextLine();
        }
        return cpf;
    }
}

