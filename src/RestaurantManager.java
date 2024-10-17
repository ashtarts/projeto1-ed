import java.util.Scanner;

public class RestaurantManager {
    public static void restaurantLoginMenu(Scanner scanner, ListaMesa listaMesas, ListaPedidos listaPedidos) {
        int loginOption;
        do {
            System.out.println("Sistema de Login (Restaurante):");
            System.out.println("1. Fazer login");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            loginOption = scanner.nextInt();
            scanner.nextLine();

            if (loginOption == 1) {
                System.out.print("Digite o nome de usuário: ");
                String username = scanner.nextLine();

                if (username.equalsIgnoreCase("admin")) {
                    adminRestaurantMenu(scanner, listaMesas, listaPedidos);
                } else {
                    employeeRestaurantMenu(scanner, listaMesas, listaPedidos);
                }
            } else if (loginOption == 2) {
                System.out.println("Saindo do sistema do restaurante...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (loginOption != 2);
    }

    public static void adminRestaurantMenu(Scanner scanner, ListaMesa listaMesas, ListaPedidos listaPedidos) {
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

                    // Verifica se a mesa existe e está ativa
                    if (listaMesas.mesaAtiva(numeroMesa)) {
                        System.out.print("Descrição do Pedido: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Quantidade: ");
                        int quantidade = scanner.nextInt();
                        System.out.print("Total: ");
                        double total = scanner.nextDouble();
                        scanner.nextLine();
                        // Adiciona o pedido associando ao número da mesa
                        listaPedidos.adicionarPedido(descricao, quantidade, total, numeroMesa, listaMesas);
                        System.out.println("Pedido adicionado com sucesso.");
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

    public static void employeeRestaurantMenu(Scanner scanner, ListaMesa listaMesas, ListaPedidos listaPedidos) {
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

                    // Verifica se a mesa existe e está ativa
                    if (listaMesas.mesaAtiva(numeroMesa)) {
                        System.out.print("Descrição do Pedido: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Quantidade: ");
                        int quantidade = scanner.nextInt();
                        System.out.print("Total: ");
                        double total = scanner.nextDouble();
                        scanner.nextLine();
                        // Adiciona o pedido associando ao número da mesa
                        listaPedidos.adicionarPedido(descricao, quantidade, total, numeroMesa, listaMesas);
                        System.out.println("Pedido adicionado com sucesso.");
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
}