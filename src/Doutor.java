public class Doutor {
    String nome;
    String especialidade;
    String disponibilidade;
    String matricula;
    Doutor next; // Campo para o próximo nó na lista encadeada

    public Doutor(String nome, String especialidade, String disponibilidade, String matricula) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.disponibilidade = disponibilidade;
        this.matricula = matricula;
        this.next = null; // Inicializa o próximo nó como nulo
    }

    @Override
    public String toString() {
        return "Doutor: " + nome + ", Especialidade: " + especialidade + ", Disponibilidade: " + disponibilidade;
    }
}


