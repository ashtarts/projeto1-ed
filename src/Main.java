import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorEventos gerenciadorEventos = new GerenciadorEventos();
        ListaP pacientes = new ListaP();
        ListaD doutores = new ListaD();
        ListaC consultas = new ListaC();
        ListaMesa listaMesas = new ListaMesa();
        ListaPedidos listaPedidos = new ListaPedidos();
        Scanner scanner = new Scanner(System.in);
        Cardapio cardapio = new Cardapio();
        boolean executar = true;

        while (executar) {
            System.out.println("Sistema:");
            System.out.println("1. Gerenciar Clínica");
            System.out.println("2. Gerenciar Eventos");
            System.out.println("3. Gerenciar Restaurante");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int menuOption = scanner.nextInt();
            scanner.nextLine();

            switch (menuOption) {
                case 1:
                    ClinicManager.clinicLoginMenu(scanner, pacientes, doutores, consultas);
                    break;
                case 2:
                    EventManager.eventLoginMenu(scanner, gerenciadorEventos);
                    break;
                case 3:
                    RestaurantManager.restaurantLoginMenu(scanner, listaMesas, listaPedidos, cardapio, doutores, gerenciadorEventos);
                    break;
                case 4:
                    executar = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
