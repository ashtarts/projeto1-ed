public class Mesa {
    int numero;
    String cliente;
    boolean ativa;
    double totalConta; // Novo campo para armazenar o total da conta

    public Mesa(int numero, String cliente, boolean ativa) {
        this.numero = numero;
        this.cliente = cliente;
        this.ativa = ativa;
        this.totalConta = 0; // Inicializa o total da conta como zero
    }

    public void fecharConta() {
        // Lógica para fechar a conta
        this.ativa = false;
    }

    public void adicionarPedido(double total) {
        this.totalConta += total; // Adiciona o valor do pedido ao total da conta
    }

    public double getTotalConta() {
        return totalConta; // Método para obter o total da conta
    }

    @Override
    public String toString() {
        return "Mesa " + numero + " - Cliente: " + cliente + " - Ativa: " + ativa + " - Total da Conta: R$ "
                + totalConta;
    }
}