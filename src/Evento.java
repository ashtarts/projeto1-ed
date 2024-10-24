public class Evento {
    private String nome;
    private String data;
    private String local;
    private int capacidade;
    private int totalIngressosVendidos;
    private double totalArrecadado;

    public Evento(String nome, String data, String local, int capacidade) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidade = capacidade;
        this.totalIngressosVendidos = 0;
        this.totalArrecadado = 0.0;
    }

    // Métodos para atualizar ingressos e arrecadação
    public void venderIngresso(double valorIngresso) {
        this.totalIngressosVendidos++;
        this.totalArrecadado += valorIngresso;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public int getCapacidade() { return capacidade; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }

    public int getTotalIngressosVendidos() { return totalIngressosVendidos; }

    public double getTotalArrecadado() { return totalArrecadado; }

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", local='" + local + '\'' +
                ", capacidade=" + capacidade +
                ", totalIngressosVendidos=" + totalIngressosVendidos +
                ", totalArrecadado=" + totalArrecadado +
                '}';
    }
}
