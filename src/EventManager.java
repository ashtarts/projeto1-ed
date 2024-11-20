import java.util.Scanner;
import java.util.Stack;

public class EventManager {
    private final Stack<String> historicoAcoes;
    private final GerenciadorEventos gerenciadorEventos;

    public EventManager() {
        this.historicoAcoes = new Stack<>();
        this.gerenciadorEventos = new GerenciadorEventos();
    }

    public static void eventLoginMenu(Scanner scanner, GerenciadorEventos gerenciadorEventos) {
        EventManager manager = new EventManager(); // Criamos uma instância de EventManager
        int loginOption;
        do {
            System.out.println("\nSistema de Login (Eventos):");
            System.out.println("1. Fazer login");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            loginOption = scanner.nextInt();
            scanner.nextLine();

            if (loginOption == 1) {
                System.out.print("Digite o nome de usuário: ");
                String username = scanner.nextLine();

                if (username.equalsIgnoreCase("admin")) {
                    manager.adminEventMenu(scanner); // Chama o menu de administrador
                } else {
                    manager.participantEventMenu(scanner); // Chama o menu de participante
                }
            } else if (loginOption == 2) {
                System.out.println("Saindo do sistema de eventos...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (loginOption != 2);
    }


    public void adminEventMenu(Scanner scanner) {
        int option;
        do {
            System.out.println("\nMenu do Administrador:");
            System.out.println("1. Criar Evento");
            System.out.println("2. Listar Eventos");
            System.out.println("3. Atualizar Evento");
            System.out.println("4. Remover Evento");
            System.out.println("5. Listar Participantes");
            System.out.println("6. Adicionar Participante");
            System.out.println("7. Remover Participante");
            System.out.println("8. Exibir histórico de ações");
            System.out.println("9. Desfazer última ação");
            System.out.println("10. Logout");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    criarEvento(scanner);
                    break;
                case 2:
                    gerenciadorEventos.listarEventos();
                    break;
                case 3:
                    atualizarEvento(scanner);
                    break;
                case 4:
                    removerEvento(scanner);
                    break;
                case 5:
                    gerenciadorEventos.listarParticipantes();
                    break;
                case 6:
                    adicionarParticipante(scanner);
                    break;
                case 7:
                    removerParticipante(scanner);
                    break;
                case 8:
                    exibirHistorico();
                    break;
                case 9:
                    desfazerUltimaAcao();
                    break;
                case 10:
                    System.out.println("Deslogando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 10);
    }

    public void participantEventMenu(Scanner scanner) {
        System.out.print("\nDigite o nome do evento para participar: ");
        String nomeEvento = scanner.nextLine();
        Evento evento = gerenciadorEventos.buscarEvento(nomeEvento);

        if (evento != null) {
            System.out.print("Nome do Participante: ");
            String nomeParticipante = scanner.nextLine();
            System.out.print("Número de Inscrição: ");
            String numeroInscricao = scanner.nextLine();

            Participante participante = new Participante(nomeParticipante, numeroInscricao, evento);
            gerenciadorEventos.adicionarParticipante(participante);
            historicoAcoes.push("Participante adicionado: " + nomeParticipante);
            System.out.println("Participante adicionado com sucesso!");
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    public void criarEvento(Scanner scanner) {
        System.out.print("\nNome do Evento: ");
        String nome = scanner.nextLine();
        System.out.print("Data do Evento: ");
        String data = scanner.nextLine();
        System.out.print("Local do Evento: ");
        String local = scanner.nextLine();
        System.out.print("Capacidade do Evento: ");
        int capacidade = scanner.nextInt();
        System.out.print("Preço do Ingresso: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        Evento evento = new Evento(nome, data, local, capacidade, preco);
        gerenciadorEventos.adicionarEvento(evento);
        historicoAcoes.push("Evento criado: " + nome);
        System.out.println("Evento criado com sucesso!");
    }

    public void atualizarEvento(Scanner scanner) {
        System.out.print("\nNome do Evento para Atualizar: ");
        String nome = scanner.nextLine();
        System.out.print("Nova Data: ");
        String novaData = scanner.nextLine();
        System.out.print("Novo Local: ");
        String novoLocal = scanner.nextLine();
        System.out.print("Nova Capacidade: ");
        int novaCapacidade = scanner.nextInt();
        System.out.print("Novo Preço: ");
        double novoPreco = scanner.nextDouble();
        scanner.nextLine();

        gerenciadorEventos.atualizarEvento(nome, novaData, novoLocal, novaCapacidade, novoPreco);
        historicoAcoes.push("Evento atualizado: " + nome);
    }

    public void removerEvento(Scanner scanner) {
        System.out.print("\nNome do Evento para Remover: ");
        String nome = scanner.nextLine();
        gerenciadorEventos.removerEvento(nome);
        historicoAcoes.push("Evento removido: " + nome);
    }

    public void adicionarParticipante(Scanner scanner) {
        System.out.print("\nNome do Participante: ");
        String nome = scanner.nextLine();
        System.out.print("Número de Inscrição: ");
        String numeroInscricao = scanner.nextLine();
        System.out.print("Nome do Evento: ");
        String nomeEvento = scanner.nextLine();

        Evento evento = gerenciadorEventos.buscarEvento(nomeEvento);
        if (evento != null) {
            Participante participante = new Participante(nome, numeroInscricao, evento);
            gerenciadorEventos.adicionarParticipante(participante);
            historicoAcoes.push("Participante adicionado: " + nome);
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    public void removerParticipante(Scanner scanner) {
        System.out.print("\nNúmero de Inscrição do Participante: ");
        String numeroInscricao = scanner.nextLine();
        gerenciadorEventos.removerParticipante(numeroInscricao);
        historicoAcoes.push("Participante removido: " + numeroInscricao);
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

    public void desfazerUltimaAcao() {
        if (historicoAcoes.isEmpty()) {
            System.out.println("Nenhuma ação para desfazer.");
        } else {
            String ultimaAcao = historicoAcoes.pop();
            System.out.println("Desfazendo ação: " + ultimaAcao);
        }
    }
}
