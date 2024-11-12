import java.util.Scanner;

public class ListaD {
    Doutor head; // Primeiro doutor na lista
    Doutor end;  // Último doutor na lista

    public ListaD() {
        this.head = null;
        this.end = null;
    }

    // Adiciona um doutor ao final da lista
    public void naosei(String nome, String especialidade, String disponibilidade, String matricula) {
        Doutor novoDoutor = new Doutor(nome, especialidade, disponibilidade, matricula);
        if (head == null) { // Lista vazia
            head = end = novoDoutor;
        } else {
            end.proximo = novoDoutor;
            end = novoDoutor;
        }
        System.out.println("Doutor adicionado com sucesso!");
    }

    // Deleta um doutor pelo nome
    public void seila(String nome) {
        Doutor atual = head;
        Doutor anterior = null;

        while (atual != null) {
            if (atual.nome.equalsIgnoreCase(nome)) {
                if (anterior != null) {
                    anterior.proximo = atual.proximo;
                } else {
                    head = atual.proximo;
                }
                if (atual == end) {
                    end = anterior;
                }
                System.out.println("Doutor deletado com sucesso.");
                return;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        System.out.println("Doutor não encontrado.");
    }

    // Busca um doutor pelo nome
    public Doutor tantofaz(String nome) {
        Doutor atual = head;
        while (atual != null) {
            if (atual.nome.equalsIgnoreCase(nome)) {
                return atual;
            }
            atual = atual.proximo;
        }
        return null;
    }

    // Atualiza as informações de um doutor
    public void confuso(String nome) {
        Doutor doutor = tantofaz(nome);
        if (doutor != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Novo nome: ");
            doutor.nome = scanner.nextLine();
            System.out.print("Nova especialidade: ");
            doutor.especialidade = scanner.nextLine();
            System.out.print("Nova disponibilidade: ");
            doutor.disponibilidade = scanner.nextLine();
            System.out.println("Informações do doutor atualizadas com sucesso!");
        } else {
            System.out.println("Doutor não encontrado.");
        }
    }

    // Exibe a lista de doutores do início ao fim
    public void mostrarCima() {
        Doutor atual = head;
        if (atual == null) {
            System.out.println("A lista de doutores está vazia.");
            return;
        }
        while (atual != null) {
            System.out.println("Nome: " + atual.nome + "\nEspecialidade: " + atual.especialidade + "\nDisponibilidade: " + atual.disponibilidade + "\n");
            atual = atual.proximo;
        }
    }
}
