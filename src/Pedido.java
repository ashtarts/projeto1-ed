public class Pedido {
    String descricao;
    int quantidade;
    double total;
    int numeroMesa;

    public Pedido(String descricao, int quantidade, double total, int numeroMesa) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.total = total;
        this.numeroMesa = numeroMesa;
    }

    @Override
    public String toString() {
        return "Pedido [Descrição: " + descricao + ", Quantidade: " + quantidade + ", Total: " + total + ", Mesa: "
                + numeroMesa + "]";
    }
}