import java.util.Scanner;

public class ListaD {
    Doutor head; // Início da lista encadeada
    Doutor end; // Fim da lista encadeada
    private ArvoreBinariaDoutores arvore; // Árvore binária de doutores

    // Construtor que inicializa a lista e a árvore
    public ListaD() {
        this.head = null;
        this.end = null;
        this.arvore = new ArvoreBinariaDoutores(); // Inicialização da árvore
    }

    // Adiciona um doutor ao final da lista e na árvore
    public void naosei(String nome, String especialidade, String disponibilidade, String matricula) {
        Doutor novoDoutor = new Doutor(nome, especialidade, disponibilidade, matricula);

        // Adiciona à lista encadeada
        if (head == null) { // Lista vazia
            head = end = novoDoutor;
        } else {
            end.proximo = novoDoutor;
            end = novoDoutor;
        }

        // Adiciona à árvore binária
        arvore.inserir(novoDoutor);

        System.out.println("Doutor adicionado com sucesso!");
    }

    // Deleta um doutor pelo nome (apenas na lista)
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

    // Busca um doutor pelo nome (na lista)
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

    // Atualiza as informações de um doutor (na lista)
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

            // Atualiza na árvore (remover e reinserir)
            arvore.remover(doutor);
            arvore.inserir(doutor);

        } else {
            System.out.println("Doutor não encontrado.");
        }
    }

    // Exibe a lista de doutores do início ao fim (na lista encadeada)
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

    // Busca doutores por especialidade (na árvore)
    public void buscarPorEspecialidade(String especialidade) {
        if (arvore == null) { // Verifica se a árvore está inicializada
            System.out.println("Erro: A árvore de doutores não foi inicializada.");
            return;
        }
        System.out.println("Buscando doutores com especialidade: " + especialidade);
        arvore.buscarPorEspecialidade(especialidade); // Busca na árvore
    }

    // Exibe todos os doutores em ordem alfabética de especialidade (usando a árvore)
    public void mostrarOrdenadoPorEspecialidade() {
        if (arvore == null) { // Verifica se a árvore está inicializada
            System.out.println("Erro: A árvore de doutores não foi inicializada.");
            return;
        }
        System.out.println("Lista de doutores ordenada por especialidade:");
        arvore.exibirEmOrdem(); // Exibe os doutores em ordem
    }
}
