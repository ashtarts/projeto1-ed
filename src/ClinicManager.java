import java.util.Scanner;
import java.util.Stack;

public class ClinicManager {
    private final Stack<String> historicoAcoes;
    private final FilaAtendimento filaAtendimento;

    public ClinicManager() {
        this.historicoAcoes = new Stack<>();
        this.filaAtendimento = new FilaAtendimento();
    }

    public static void clinicLoginMenu(Scanner scanner, ListaP pacientes, ListaD doutores, ListaC consultas) {
        ClinicManager manager = new ClinicManager();
        int loginOption;
        do {
            System.out.println("Sistema de Login (Clínica):");
            System.out.println("1. Fazer login");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            loginOption = scanner.nextInt();
            scanner.nextLine();

            if (loginOption == 1) {
                System.out.print("Digite o nome de usuário: ");
                String username = scanner.nextLine();

                if (username.equalsIgnoreCase("admin")) {
                    manager.adminClinicMenu(scanner, pacientes, doutores, consultas);
                } else {
                    manager.employeeClinicMenu(scanner, pacientes, doutores, consultas);
                }
            } else if (loginOption == 2) {
                System.out.println("Saindo do sistema da clínica...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (loginOption != 2);
    }

    public void adminClinicMenu(Scanner scanner, ListaP pacientes, ListaD doutores, ListaC consultas) {
        int option;
        do {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Adicionar paciente");
            System.out.println("2. Exibir lista de pacientes");
            System.out.println("3. Editar informações de paciente");
            System.out.println("4. Deletar paciente");
            System.out.println("/--------------------------------------/");
            System.out.println("5. Adicionar doutor");
            System.out.println("6. Exibir lista de doutores");
            System.out.println("7. Editar informações de doutor");
            System.out.println("8. Deletar doutor");
            System.out.println("9. Buscar doutor por especialidade");
            System.out.println("/--------------------------------------/");
            System.out.println("10. Adicionar consulta com triagem");
            System.out.println("11. Exibir lista de consultas");
            System.out.println("12. Editar informações de consulta");
            System.out.println("13. Deletar consulta");
            System.out.println("/--------------------------------------/");
            System.out.println("14. Atender próximo paciente");
            System.out.println("/--------------------------------------/");
            System.out.println("15. Exibir histórico de ações");
            System.out.println("16. Desfazer última ação");
            System.out.println("/--------------------------------------/");
            System.out.println("17. Logout");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    adicionarPaciente(scanner, pacientes);
                    break;
                case 2:
                    pacientes.mostrarCima();
                    break;
                case 3:
                    editarPaciente(scanner, pacientes);
                    break;
                case 4:
                    deletarPaciente(scanner, pacientes);
                    break;
                case 5:
                    adicionarDoutor(scanner, doutores);
                    break;
                case 6:
                    doutores.mostrarCima();
                    break;
                case 7:
                    editarDoutor(scanner, doutores);
                    break;
                case 8:
                    deletarDoutor(scanner, doutores);
                    break;
                case 9:
                    buscarDoutorPorEspecialidade(scanner, doutores);
                    break;
                case 10:
                    adicionarConsulta(scanner, consultas);
                    break;
                case 11:
                    consultas.mostrarCima();
                    break;
                case 12:
                    editarConsulta(scanner, consultas);
                    break;
                case 13:
                    deletarConsulta(scanner, consultas);
                    break;
                case 14:
                    atenderPaciente();
                    break;
                case 15:
                    exibirHistorico();
                    break;
                case 16:
                    desfazerUltimaAcao(pacientes, doutores, consultas);
                    break;
                case 17:
                    System.out.println("Deslogando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 16);
    }


    public void employeeClinicMenu(Scanner scanner, ListaP pacientes, ListaD doutores, ListaC consultas) {
        int option;
        do {
            System.out.println("\nMenu Funcionário:");
            System.out.println("1. Exibir lista de pacientes");
            System.out.println("2. Exibir lista de doutores");
            System.out.println("3. Adicionar consulta com triagem");
            System.out.println("4. Exibir lista de consultas");
            System.out.println("5. Editar consulta");
            System.out.println("6. Deletar consulta");
            System.out.println("7. Atender próximo paciente");
            System.out.println("8. Exibir histórico de ações");
            System.out.println("9. Logout");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    pacientes.mostrarCima();
                    break;
                case 2:
                    doutores.mostrarCima();
                    break;
                case 3:
                    adicionarConsulta(scanner, consultas);
                    break;
                case 4:
                    consultas.mostrarCima();
                    break;
                case 5:
                    editarConsulta(scanner, consultas);
                    break;
                case 6:
                    deletarConsulta(scanner, consultas);
                    break;
                case 7:
                    atenderPaciente();
                    break;
                case 8:
                    exibirHistorico();
                    break;
                case 9:
                    System.out.println("Deslogando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 9);
    }

    public void desfazerUltimaAcao(ListaP pacientes, ListaD doutores, ListaC consultas) {
        if (historicoAcoes.isEmpty()) {
            System.out.println("Nenhuma ação para desfazer.");
            return;
        }

        String ultimaAcao = historicoAcoes.pop();
        System.out.println("Desfazendo ação: " + ultimaAcao);

        if (ultimaAcao.startsWith("Paciente adicionado: ")) {
            String nomePaciente = ultimaAcao.replace("Paciente adicionado: ", "");
            pacientes.seila(nomePaciente);
            System.out.println("Paciente removido.");
        } else if (ultimaAcao.startsWith("Doutor adicionado: ")) {
            String nomeDoutor = ultimaAcao.replace("Doutor adicionado: ", "");
            doutores.seila(nomeDoutor);
            System.out.println("Doutor removido.");
        } else if (ultimaAcao.startsWith("Consulta adicionada: ")) {
            String nomePaciente = ultimaAcao.replace("Consulta adicionada: ", "").split(" com gravidade ")[0];
            consultas.seila(nomePaciente);
            System.out.println("Consulta removida.");
        } else {
            System.out.println("Ação desconhecida ou não pode ser desfeita.");
        }
    }
    public void adicionarPaciente(Scanner scanner, ListaP pacientes) {
        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do paciente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Histórico médico: ");
        String historico = scanner.nextLine();
        System.out.print("Data da última consulta: ");
        String ultimaConsulta = scanner.nextLine();
        pacientes.naosei(nome, idade, historico, ultimaConsulta);
        historicoAcoes.push("Paciente adicionado: " + nome);
        System.out.println("Paciente adicionado com sucesso!");
    }

    public void editarPaciente(Scanner scanner, ListaP pacientes) {
        System.out.print("Digite o nome do paciente para editar: ");
        String nomePaciente = scanner.nextLine();
        pacientes.confuso(nomePaciente);
        historicoAcoes.push("Paciente editado: " + nomePaciente);
    }

    public void deletarPaciente(Scanner scanner, ListaP pacientes) {
        System.out.print("Digite o nome do paciente para deletar: ");
        String nomePaciente = scanner.nextLine();
        pacientes.seila(nomePaciente);
        historicoAcoes.push("Paciente deletado: " + nomePaciente);
    }

    public void adicionarDoutor(Scanner scanner, ListaD doutores) {
        System.out.print("Nome do doutor: ");
        String nomeDoutor = scanner.nextLine();
        System.out.print("Especialidade do doutor: ");
        String especialidade = scanner.nextLine();
        System.out.print("Disponibilidade do doutor: ");
        String disponibilidade = scanner.nextLine();
        System.out.print("Matrícula do doutor: ");
        String matricula = scanner.nextLine();
        doutores.naosei(nomeDoutor, especialidade, disponibilidade, matricula);
        historicoAcoes.push("Doutor adicionado: " + nomeDoutor);
        System.out.println("Doutor adicionado com sucesso!");
    }

    public void editarDoutor(Scanner scanner, ListaD doutores) {
        System.out.print("Digite o nome do doutor para editar: ");
        String nomeDoutor = scanner.nextLine();
        doutores.confuso(nomeDoutor);
        historicoAcoes.push("Doutor editado: " + nomeDoutor);
    }

    public void deletarDoutor(Scanner scanner, ListaD doutores) {
        System.out.print("Digite o nome do doutor para deletar: ");
        String nomeDoutor = scanner.nextLine();
        doutores.seila(nomeDoutor);
        historicoAcoes.push("Doutor deletado: " + nomeDoutor);
    }

    public void adicionarConsulta(Scanner scanner, ListaC consultas) {
        System.out.print("Nome do paciente: ");
        String nomePaciente = scanner.nextLine();
        System.out.print("Nome do doutor: ");
        String nomeDoutor = scanner.nextLine();
        System.out.print("Data da consulta: ");
        String dataConsulta = scanner.nextLine();
        System.out.print("Observações: ");
        String observacoes = scanner.nextLine();
        consultas.naosei(nomePaciente, nomeDoutor, dataConsulta, observacoes);

        System.out.print("Gravidade da emergência (leve, grave, muito grave): ");
        String gravidade = scanner.nextLine().toLowerCase();
        Agendamento agendamento = new Agendamento(nomePaciente, dataConsulta, observacoes);
        filaAtendimento.adicionarNaFila(agendamento, gravidade);

        historicoAcoes.push("Consulta adicionada: " + nomePaciente + " com gravidade " + gravidade);
        System.out.println("Consulta adicionada com sucesso!");
    }

    public void editarConsulta(Scanner scanner, ListaC consultas) {
        System.out.print("Digite o nome do paciente da consulta para editar: ");
        String nomePaciente = scanner.nextLine();
        consultas.confuso(nomePaciente);
        historicoAcoes.push("Consulta editada: " + nomePaciente);
    }

    public void deletarConsulta(Scanner scanner, ListaC consultas) {
        System.out.print("Digite o nome do paciente da consulta para deletar: ");
        String nomePaciente = scanner.nextLine();
        consultas.seila(nomePaciente);
        historicoAcoes.push("Consulta deletada: " + nomePaciente);
    }

    public void atenderPaciente() {
        Agendamento proximo = filaAtendimento.atenderProximo();
        if (proximo != null) {
            System.out.println("Atendendo: " + proximo);
            historicoAcoes.push("Paciente atendido: " + proximo.nomePaciente);
        } else {
            System.out.println("Nenhum paciente na fila de atendimento.");
        }
    }

    public void exibirHistorico() {
        if (historicoAcoes.isEmpty()) {
            System.out.println("Nenhuma ação registrada no histórico.");
        } else {
            System.out.println("Histórico de ações:");
            for (String acao : historicoAcoes) {
                System.out.println(acao);
            }
        }
    }

    public void buscarDoutorPorEspecialidade(Scanner scanner, ListaD doutores) {
        System.out.print("Digite a especialidade a ser buscada: ");
        String especialidade = scanner.nextLine();
        System.out.println("Doutores com especialidade: " + especialidade);
        doutores.buscarPorEspecialidade(especialidade);
    }

}
