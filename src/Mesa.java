public class Mesa {
    int numero;
    String cliente;
    boolean ativa;
    Mesa proximo;

    public Mesa(int numero, String cliente, boolean ativa) {
        this.numero = numero;
        this.cliente = cliente;
        this.ativa = ativa;
        this.proximo = null; // ou o valor adequado para o próximo nó
    }

    public void fecharConta() {
        this.ativa = false;
        System.out.println("Conta da mesa " + numero + " foi fechada.");
    }

    public void adicionarPedido(double valor) {
        // lógica para adicionar o valor do pedido à conta
    }

    @Override
    public String toString() {
        return "Mesa " + numero + " - Cliente: " + cliente + " - Ativa: " + ativa;
    }
}
