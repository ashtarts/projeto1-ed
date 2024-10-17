public class ListaPedidos {
    private PedidoNode inicio;
    private PedidoNode fim;

    public ListaPedidos() {
        inicio = null;
        fim = null;
    }

    public void adicionarPedido(String descricao, int quantidade, double total, int numeroMesa, ListaMesa listaMesas) {
        Pedido novoPedido = new Pedido(descricao, quantidade, total, numeroMesa);
        PedidoNode novoPedidoNo = new PedidoNode(novoPedido);

        // Adiciona o pedido à lista
        if (inicio == null) {
            inicio = novoPedidoNo;
            fim = novoPedidoNo;
            fim.proximo = inicio;
        } else {
            fim.proximo = novoPedidoNo;
            fim = novoPedidoNo;
            fim.proximo = inicio;
        }

        // Atualiza o total da conta da mesa correspondente
        Mesa mesa = listaMesas.obterMesa(numeroMesa); // Obtém a mesa pelo número
        if (mesa != null) {
            mesa.adicionarPedido(total); // Atualiza o total da conta
        }
    }

    public String listarPedidos() {
        if (inicio == null) {
            return "Nenhum pedido no momento.";
        }
        StringBuilder sb = new StringBuilder();
        PedidoNode atual = inicio;
        do {
            sb.append(atual.pedido).append("\n"); // Adiciona cada pedido à StringBuilder
            atual = atual.proximo;
        } while (atual != inicio);
        return sb.toString(); // Retorna a string com todos os pedidos
    }
}