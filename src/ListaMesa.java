public class ListaMesa {
    private MesaNode head; // Cabeça da lista

    public ListaMesa() {
        this.head = null; // Inicializa a lista vazia
    }

    // Adiciona uma nova mesa à lista
    public void adicionarMesa(Mesa novaMesa) {
        MesaNode novoNo = new MesaNode(novaMesa); // Cria um novo nó para a mesa
        if (head == null) {
            head = novoNo; // Se a lista está vazia, a nova mesa se torna a cabeça
        } else {
            MesaNode temp = head;
            while (temp.proximo != null) { // Navega até o último nó
                temp = temp.proximo;
            }
            temp.proximo = novoNo; // Adiciona a nova mesa ao final da lista
        }
    }

    // Fecha uma mesa pelo número
    public void fecharMesa(int numero) {
        MesaNode temp = head;
        while (temp != null) {
            if (temp.mesa.numero == numero) { // Verifica o número da mesa
                temp.mesa.fecharConta(); // Fecha a conta da mesa
                System.out.println("Mesa " + numero + " fechada com sucesso.");
                return;
            }
            temp = temp.proximo;
        }
        System.out.println("Mesa " + numero + " não encontrada.");
    }

    // Lista todas as mesas em formato de string
    public String listarMesa() {
        StringBuilder sb = new StringBuilder();
        MesaNode temp = head; // Começa da cabeça
        while (temp != null) {
            sb.append(temp.mesa.toString()).append("\n"); // Chama o método toString() de Mesa
            temp = temp.proximo; // Move para o próximo nó
        }
        return sb.toString();
    }

    // Obtém a mesa pelo número
    public Mesa obterMesa(int numero) {
        MesaNode temp = head;
        while (temp != null) {
            if (temp.mesa.numero == numero) {
                return temp.mesa; // Retorna a mesa correspondente
            }
            temp = temp.proximo;
        }
        return null; // Retorna null se a mesa não for encontrada
    }

    // Método para verificar se a mesa está ativa
    public boolean mesaAtiva(int numero) {
        Mesa mesa = obterMesa(numero);
        return mesa != null && mesa.ativa; // Retorna true se a mesa existe e está ativa
    }
}