public class Participante {
    private String nome;
    private String numeroInscricao; // Número de inscrição do participante
    private Evento evento;
    private int idade;
    private double precoIngresso;

    public Participante(String nome, String numeroInscricao, Evento evento, int idade) {
        this.nome = nome;
        this.numeroInscricao = numeroInscricao;
        this.evento = evento;
        this.idade = idade;
        this.precoIngresso = calcularPrecoIngresso(idade);
    }

    private double calcularPrecoIngresso(int idade) {
        if (idade > 18) {
            return 30.0;
        } else if (idade > 10) {
            return 15.0;
        } else {
            return 0.0;
        }
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getNumeroInscricao() { return numeroInscricao; }
    public void setNumeroInscricao(String numeroInscricao) { this.numeroInscricao = numeroInscricao; }

    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; this.precoIngresso = calcularPrecoIngresso(idade); }

    public double getPrecoIngresso() { return precoIngresso; }

    @Override
    public String toString() {
        return "Participante{" +
                "nome='" + nome + '\'' +
                ", numero de inscrição='" + numeroInscricao + '\'' +
                ", evento=" + evento +
                ", idade=" + idade +
                ", precoIngresso=" + precoIngresso +
                '}';
    }
}
