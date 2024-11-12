import java.util.Scanner;

public class ClinicManager {
    private final PilhaAgendamentos pilhaAgendamentos;
    private final FilaAtendimento filaAtendimento;

    public ClinicManager() {
        this.pilhaAgendamentos = new PilhaAgendamentos();
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
            System.out.println("5. Adicionar doutor");
            System.out.println("6. Exibir lista de doutores");
            System.out.println("7. Editar informações de doutor");
            System.out.println("8. Deletar doutor");
            System.out.println("9. Adicionar consulta com triagem");
            System.out.println("10. Exibir lista de consultas");
            System.out.println("11. Editar informações de consulta");
            System.out.println("12. Deletar consulta");
            System.out.println("13. Atender próximo paciente");
            System.out.println("14. Logout");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nome do paciente: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Idade do paciente: ");
                    int patientAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Histórico Médico: ");
                    String medicalHistory = scanner.nextLine();
                    System.out.print("Data da Última Consulta: ");
                    String lastConsultationDate = scanner.nextLine();
                    pacientes.naosei(patientName, patientAge, medicalHistory, lastConsultationDate);
                    System.out.println("Paciente adicionado com sucesso!");
                    break;
                case 2:
                    pacientes.mostrarCima();
                    break;
                case 3:
                    System.out.print("Digite o nome do paciente para editar: ");
                    String patientToEdit = scanner.nextLine();
                    pacientes.confuso(patientToEdit);
                    break;
                case 4:
                    System.out.print("Digite o nome do paciente para deletar: ");
                    String patientToDelete = scanner.nextLine();
                    pacientes.seila(patientToDelete);
                    break;
                case 5:
                    System.out.print("Nome do doutor: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Especialidade do doutor: ");
                    String specialty = scanner.nextLine();
                    System.out.print("Disponibilidade do doutor: ");
                    String availability = scanner.nextLine();
                    System.out.print("Matrícula do doutor: ");
                    String matricula = scanner.nextLine();
                    doutores.naosei(doctorName, specialty, availability, matricula);
                    System.out.println("Doutor adicionado com sucesso!");
                    break;
                case 6:
                    doutores.mostrarCima();
                    break;
                case 7:
                    System.out.print("Digite o nome do doutor para editar: ");
                    String doctorToEdit = scanner.nextLine();
                    doutores.confuso(doctorToEdit);
                    break;
                case 8:
                    System.out.print("Digite o nome do doutor para deletar: ");
                    String doctorToDelete = scanner.nextLine();
                    doutores.seila(doctorToDelete);
                    break;
                case 9:
                    adicionarConsulta(scanner, consultas);
                    break;
                case 10:
                    consultas.mostrarCima();
                    break;
                case 11:
                    System.out.print("Digite o nome do paciente da consulta para editar: ");
                    String consultaToEdit = scanner.nextLine();
                    consultas.confuso(consultaToEdit);
                    break;
                case 12:
                    System.out.print("Digite o nome do paciente da consulta para deletar: ");
                    String consultaToDelete = scanner.nextLine();
                    consultas.seila(consultaToDelete);
                    break;
                case 13:
                    atenderPaciente();
                    break;
                case 14:
                    System.out.println("Deslogando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 14);
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
            System.out.println("8. Logout");
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
                    System.out.print("Nome do paciente: ");
                    String consultaEditar = scanner.nextLine();
                    consultas.confuso(consultaEditar);
                    break;
                case 6:
                    System.out.print("Nome do paciente: ");
                    String consultaDeletar = scanner.nextLine();
                    consultas.seila(consultaDeletar);
                    break;
                case 7:
                    atenderPaciente();
                    break;
                case 8:
                    System.out.println("Deslogando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 8);
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
        System.out.println("Paciente adicionado à lista de atendimento com gravidade: " + gravidade);
    }


    public void atenderPaciente() {
        Agendamento proximo = filaAtendimento.atenderProximo();
        if (proximo != null) {
            System.out.println("Atendendo: " + proximo);
        } else {
            System.out.println("Nenhum paciente na fila de atendimento.");
        }
    }
}
