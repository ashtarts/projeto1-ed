import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class Main {
    public static void main(String[] args) {
        GerenciadorEventos gerenciadorEventos = new GerenciadorEventos();
        ArvoreParticipantes arvoreParticipantes = new ArvoreParticipantes(); // Árvore para armazenar participantes
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n----- Menu -----");
            System.out.println("1. Adicionar Evento");
            System.out.println("2. Listar Evento e Adicionar ao Histórico");
            System.out.println("3. Mostrar Histórico de Eventos");
            System.out.println("4. Inscrever Participante com Prioridade");
            System.out.println("5. Listar Participantes (por inscrição)");
            System.out.println("6. Listar Participantes por Prioridade");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    scanner.nextLine();

                    System.out.print("\nDigite o nome do evento: ");
                    String nomeEvento = scanner.nextLine();
                    System.out.print("Digite a data do evento (dd/mm/aaaa): ");
                    String dataEvento = scanner.nextLine();
                    System.out.print("Digite o local do evento: ");
                    String localEvento = scanner.nextLine();
                    System.out.print("Digite a capacidade do evento: ");
                    int capacidadeEvento = scanner.nextInt();
                    System.out.print("Digite o preço do ingresso: ");
                    double precoEvento = scanner.nextDouble();
                    Evento evento = new Evento(nomeEvento, dataEvento, localEvento, capacidadeEvento, precoEvento);
                    gerenciadorEventos.adicionarEvento(evento);
                    break;

                case 2:
                    scanner.nextLine();
                    System.out.print("\nDigite o nome do evento para listar: ");
                    String nomeListarEvento = scanner.nextLine();
                    Evento achou = gerenciadorEventos.listarEvento(nomeListarEvento);
                    if (achou != null) {
                        System.out.println(achou);
                        gerenciadorEventos.addAoHistorico(achou);
                        System.out.print("Evento adicionado com sucesso ao histórico");
                    }
                    break;

                case 3:
                    gerenciadorEventos.mostrarHistorico();
                    break;

                case 4:
                    scanner.nextLine();
                    System.out.print("\nDigite o nome do participante: ");
                    String nomeParticipante = scanner.nextLine();
                    System.out.print("Digite o número de inscrição do participante: ");
                    int numeroInscricao = scanner.nextInt();
                    System.out.print("Digite a prioridade do participante (quanto maior, mais prioritário): ");
                    int prioridade = scanner.nextInt();
                    Participante participante = new Participante(nomeParticipante, numeroInscricao, prioridade);
                    arvoreParticipantes.inserir(participante); // Adiciona o participante na árvore
                    break;

                case 5:
                    System.out.println("\n--- Listando Participantes por Inscrição ---");
                    arvoreParticipantes.listarParticipantesInOrder(); // Listar participantes por número de inscrição
                    break;

                case 6:
                    System.out.println("\n--- Listando Participantes por Prioridade ---");
                    arvoreParticipantes.listarParticipantesPorPrioridade(); // Listar participantes por prioridade
                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        } while (opcao != 8);

        scanner.close();
    }
}
