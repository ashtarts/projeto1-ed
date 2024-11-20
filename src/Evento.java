public class Evento {
    private String nome;
    private String data;
    private String local;
    private int capacidade;
    private double preco;
    private int ingressosVendidos = 0;  // Contar os ingressos vendidos
    private double totalArrecadado = 0;  // Contar a arrecadação

    public Evento(String nome, String data, String local, int capacidade, double preco) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidade = capacidade;
        this.preco = preco;
    }


    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    //Método para obter o preço do ingresso, considerando a meia-entrada
    public double getPrecoIngresso(boolean meiaEntrada) {
        return meiaEntrada ? preco / 2 : preco;
    }

    // Método para vender ingresso
    public void venderIngresso(boolean meiaEntrada) {
        if (ingressosVendidos < capacidade) {
            double precoFinal = getPrecoIngresso(meiaEntrada);
            ingressosVendidos++;
            totalArrecadado += precoFinal;
            System.out.println("Ingresso vendido por " + precoFinal + " reais.");
        } else {
            System.out.println("Capacidade do evento esgotada.");
        }
    }

    public int getTotalIngressosVendidos() {
        return ingressosVendidos;
    }

    public double getTotalArrecadado() {
        return totalArrecadado;
    }

    // Outros getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public int getCapacidade() { return capacidade; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", local='" + local + '\'' +
                ", capacidade=" + capacidade +
                ", preco=" + preco +
                '}';
    }
}
