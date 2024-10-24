import java.util.Scanner;

public class RestaurantManager {

    public static void restaurantLoginMenu(Scanner scanner, ListaMesa listaMesas, ListaPedidos listaPedidos, Cardapio cardapio, ListaD listaDoutores, GerenciadorEventos gerenciadorEventos) {
        String loginOption;
        do {
            System.out.println("Sistema de Login (Restaurante):");
            System.out.println("1. Fazer login");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            loginOption = scanner.nextLine();

            if (loginOption.equals("1")) {
                System.out.print("Digite o nome de usuário: ");
                String username = scanner.nextLine();

                if (username.equalsIgnoreCase("admin")) {
                    adminRestaurantMenu(scanner, listaMesas, listaPedidos, cardapio, listaDoutores, gerenciadorEventos);
                } else {
                    employeeRestaurantMenu(scanner, listaMesas, listaPedidos, cardapio, listaDoutores, gerenciadorEventos);
                }
            } else if (loginOption.equals("2")) {
                System.out.println("Saindo do sistema do restaurante...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (!loginOption.equals("2"));
    }

    public static void adminRestaurantMenu(Scanner scanner, ListaMesa listaMesas, ListaPedidos listaPedidos, Cardapio cardapio, ListaD listaDoutores, GerenciadorEventos gerenciadorEventos) {
        boolean adminMenu = true;
        while (adminMenu) {
            System.out.println("\n--------------------");
            System.out.println("Menu do Administrador:");
            System.out.println("--------------------");
            System.out.println("1. Adicionar Mesa");
            System.out.println("2. Fechar Mesa");
            System.out.println("3. Listar Mesas");
            System.out.println("4. Adicionar Pedido");
            System.out.println("5. Listar Pedidos");
            System.out.println("6. Sair para o Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcaoAdmin = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoAdmin) {
                case 1:
                    System.out.print("Número da Mesa: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do Cliente: ");
                    String cliente = scanner.nextLine();
                    Mesa novaMesa = new Mesa(numero, cliente, true);
                    listaMesas.adicionarMesa(novaMesa);
                    System.out.println("Mesa adicionada com sucesso.");
                    break;
                case 2:
                    System.out.print("Número da Mesa para fechar: ");
                    int numeroFechar = scanner.nextInt();
                    scanner.nextLine();
                    listaMesas.fecharMesa(numeroFechar);
                    break;
                case 3:
                    System.out.println("\nListagem de Mesas:");
                    System.out.println(listaMesas.listarMesa());
                    break;
                case 4:
                    System.out.print("Número da Mesa: ");
                    int numeroMesa = scanner.nextInt();
                    scanner.nextLine();

                    if (listaMesas.mesaAtiva(numeroMesa)) {
                        cardapio.exibirCardapio();

                        System.out.print("Escolha o número do item do cardápio: ");
                        int opcaoCardapio = scanner.nextInt();
                        scanner.nextLine();

                        ItemMenu itemEscolhido = cardapio.selecionarItem(opcaoCardapio);
                        if (itemEscolhido != null) {
                            System.out.print("Quantidade: ");
                            int quantidade = scanner.nextInt();
                            scanner.nextLine();

                            double total = itemEscolhido.getPreco() * quantidade;

                            // Pergunta se o cliente é médico e aplica desconto de 20%
                            System.out.print("Digite a matrícula do médico (ou pressione Enter para pular): ");
                            String matricula = scanner.nextLine();
                            if (!matricula.isEmpty() && validarMatricula(matricula, listaDoutores)) {
                                total *= 0.8; // Aplica 20% de desconto
                                System.out.println("Desconto de 20% aplicado. Total com desconto: " + total);
                            }

                            // Pergunta se o cliente é um participante do evento e aplica 10% de desconto
                            System.out.print("Digite o número de inscrição do participante (ou pressione Enter para pular): ");
                            String numeroInscricao = scanner.nextLine();
                            if (!numeroInscricao.isEmpty() && validarParticipante(numeroInscricao, gerenciadorEventos)) {
                                total *= 0.9; // Aplica 10% de desconto
                                System.out.println("Desconto de 10% para participante aplicado. Total com desconto: " + total);
                            }

                            listaPedidos.adicionarPedido(itemEscolhido.getNome(), quantidade, total, numeroMesa, listaMesas);
                            System.out.println("Pedido adicionado com sucesso.");
                        } else {
                            System.out.println("Item do cardápio não encontrado.");
                        }
                    } else {
                        System.out.println("Mesa não registrada ou já fechada. Não é possível adicionar o pedido.");
                    }
                    break;
                case 5:
                    System.out.println("\nListagem de Pedidos:");
                    System.out.println(listaPedidos.listarPedidos());
                    break;
                case 6:
                    adminMenu = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void employeeRestaurantMenu(Scanner scanner, ListaMesa listaMesas, ListaPedidos listaPedidos, Cardapio cardapio, ListaD listaDoutores, GerenciadorEventos gerenciadorEventos) {
        boolean employeeMenu = true;
        while (employeeMenu) {
            System.out.println("\n--------------------");
            System.out.println("Menu do Funcionário:");
            System.out.println("--------------------");
            System.out.println("1. Adicionar Pedido");
            System.out.println("2. Listar Pedidos");
            System.out.println("3. Listar Mesas");
            System.out.println("4. Sair para o Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcaoFuncionario = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoFuncionario) {
                case 1:
                    System.out.print("Número da Mesa: ");
                    int numeroMesa = scanner.nextInt();
                    scanner.nextLine();

                    if (listaMesas.mesaAtiva(numeroMesa)) {
                        cardapio.exibirCardapio();

                        System.out.print("Escolha o número do item do cardápio: ");
                        int opcaoCardapio = scanner.nextInt();
                        scanner.nextLine();

                        ItemMenu itemEscolhido = cardapio.selecionarItem(opcaoCardapio);
                        if (itemEscolhido != null) {
                            System.out.print("Quantidade: ");
                            int quantidade = scanner.nextInt();
                            scanner.nextLine();

                            double total = itemEscolhido.getPreco() * quantidade;

                            listaPedidos.adicionarPedido(itemEscolhido.getNome(), quantidade, total, numeroMesa, listaMesas);
                            System.out.println("Pedido adicionado com sucesso.");
                        } else {
                            System.out.println("Item do cardápio não encontrado.");
                        }
                    } else {
                        System.out.println("Mesa não registrada ou já fechada. Não é possível adicionar o pedido.");
                    }
                    break;
                case 2:
                    System.out.println("\nListagem de Pedidos:");
                    System.out.println(listaPedidos.listarPedidos());
                    break;
                case 3:
                    System.out.println("\nListagem de Mesas:");
                    System.out.println(listaMesas.listarMesa());
                    break;
                case 4:
                    employeeMenu = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static boolean validarMatricula(String matricula, ListaD listaDoutores) {
        Doutor atual = listaDoutores.head;
        while (atual != null) {
            if (atual.matricula.equals(matricula)) {
                return true;
            }
            atual = atual.end;
        }
        return false;
    }

    public static boolean validarParticipante(String numeroInscricao, GerenciadorEventos gerenciadorEventos) {
        return gerenciadorEventos.buscarParticipante(numeroInscricao) != null;
    }
}
