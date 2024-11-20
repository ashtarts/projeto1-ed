public class Doutor {
    String nome;
    String especialidade;
    String disponibilidade;
    String matricula;
    Doutor proximo;

    Doutor esquerda;
    Doutor direita;

    public Doutor(String nome, String especialidade, String disponibilidade, String matricula) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.disponibilidade = disponibilidade;
        this.matricula = matricula;

        this.proximo = null;
        this.esquerda = null;
        this.direita = null;
    }

    @Override
    public String toString() {
        return "Doutor: " + nome + ", Especialidade: " + especialidade + ", Disponibilidade: " + disponibilidade;
    }
}
