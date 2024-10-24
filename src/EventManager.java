import java.util.Scanner;

public class EventManager {
    public static void eventLoginMenu(Scanner scanner, GerenciadorEventos gerenciadorEventos) {
        int loginOption;
        do {
            System.out.println("Sistema de Login (Eventos):");
            System.out.println("1. Fazer login");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            loginOption = scanner.nextInt();
            scanner.nextLine();

            if (loginOption == 1) {
                System.out.print("Digite o nome de usuário: ");
                String username = scanner.nextLine();

                if (username.equalsIgnoreCase("admin")) {
                    adminEventMenu(scanner, gerenciadorEventos);
                } else {
                    employeeEventMenu(scanner, gerenciadorEventos);
                }
            } else if (loginOption == 2) {
                System.out.println("Saindo do sistema de eventos...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (loginOption != 2);
    }

    public static void adminEventMenu(Scanner scanner, GerenciadorEventos gerenciador) {
        boolean adminMenu = true;
        while (adminMenu) {
            System.out.println("\n--------------------");
            System.out.println("Menu do Administrador:");
            System.out.println("--------------------");
            System.out.println("1. Criar Evento");
            System.out.println("2. Listar Eventos");
            System.out.println("3. Atualizar Evento");
            System.out.println("4. Remover Evento");
            System.out.println("5. Listar Participantes");
            System.out.println("6. Adicionar Participante");
            System.out.println("7. Remover Participante");
            System.out.println("8. Sair para o Menu Principal");
            System.out.println("9. Ver Arrecadação do Evento");
            System.out.print("Escolha uma opção: ");
            int opcaoAdmin = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoAdmin) {
                case 1:
                    System.out.print("\nNome do Evento: ");
                    String nome = scanner.nextLine();
                    System.out.print("Data do Evento: ");
                    String data = scanner.nextLine();
                    System.out.print("Local do Evento: ");
                    String local = scanner.nextLine();
                    System.out.print("Capacidade do Evento: ");
                    int capacidade = scanner.nextInt();
                    scanner.nextLine();
                    Evento evento = new Evento(nome, data, local, capacidade);
                    gerenciador.adicionarEvento(evento);
                    System.out.println("Evento criado com sucesso.");
                    break;
                case 2:
                    System.out.println("\nListagem de Eventos:");
                    gerenciador.listarEventos();
                    break;
                case 3:
                    System.out.print("\nNome do Evento para Atualizar: ");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.print("Nova Data: ");
                    String novaData = scanner.nextLine();
                    System.out.print("Novo Local: ");
                    String novoLocal = scanner.nextLine();
                    System.out.print("Nova Capacidade: ");
                    int novaCapacidade = scanner.nextInt();
                    scanner.nextLine();
                    gerenciador.atualizarEvento(nomeAtualizar, novaData, novoLocal, novaCapacidade);
                    System.out.println("Evento atualizado com sucesso.");
                    break;
                case 4:
                    System.out.print("\nNome do Evento para Remover: ");
                    String nomeRemover = scanner.nextLine();
                    gerenciador.removerEvento(nomeRemover);
                    System.out.println("Evento removido com sucesso.");
                    break;
                case 5:
                    System.out.println("\nListagem de Participantes:");
                    gerenciador.listarParticipantes();
                    break;
                case 6:
                    System.out.print("\nNome do Participante: ");
                    String nomeParticipante = scanner.nextLine();
                    System.out.print("Número de Inscrição: ");
                    String numeroInscricao = scanner.nextLine(); // Solicita o número de inscrição
                    System.out.print("Idade do Participante: ");
                    int idadeParticipante = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.print("Nome do Evento para Inscrição: ");
                    String nomeEvento = scanner.nextLine();
                    Evento eventoParticipante = gerenciador.buscarEvento(nomeEvento);
                    if (eventoParticipante != null) {
                        Participante participante = new Participante(nomeParticipante, numeroInscricao, eventoParticipante, idadeParticipante);
                        gerenciador.adicionarParticipante(participante);
                        eventoParticipante.venderIngresso(participante.getPrecoIngresso());
                        System.out.println("Participante adicionado com sucesso. Preço do ingresso: " + participante.getPrecoIngresso() + " reais.");
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;
                case 7:
                    System.out.print("\nNúmero de Inscrição do Participante para Remover: ");
                    String numeroRemover = scanner.nextLine();
                    gerenciador.removerParticipante(numeroRemover);
                    System.out.println("Participante removido com sucesso.");
                    break;
                case 8:
                    adminMenu = false;
                    break;
                case 9:
                    System.out.print("\nNome do Evento para ver arrecadação: ");
                    String nomeEventoArrecadacao = scanner.nextLine();
                    Evento eventoArrecadacao = gerenciador.buscarEvento(nomeEventoArrecadacao);
                    if (eventoArrecadacao != null) {
                        System.out.println("Total de ingressos vendidos: " + eventoArrecadacao.getTotalIngressosVendidos());
                        System.out.println("Total arrecadado: " + eventoArrecadacao.getTotalArrecadado() + " reais.");
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


    public static void employeeEventMenu(Scanner scanner, GerenciadorEventos gerenciador) {
        boolean employeeMenu = true;
        while (employeeMenu) {
            System.out.println("\n--------------------");
            System.out.println("Menu do Funcionário:");
            System.out.println("--------------------");
            System.out.println("1. Listar Eventos");
            System.out.println("2. Listar Participantes");
            System.out.println("3. Sair para o Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcaoFuncionario = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoFuncionario) {
                case 1:
                    System.out.println("\nListagem de Eventos:");
                    gerenciador.listarEventos();
                    break;
                case 2:
                    System.out.println("\nListagem de Participantes:");
                    gerenciador.listarParticipantes();
                    break;
                case 3:
                    employeeMenu = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}