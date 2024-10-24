class Doutor {
    String nome;
    String especialidade;
    String disponibilidade;
    String matricula;
    Doutor head;
    Doutor end;

    Doutor(String nome, String especialidade, String disponibilidade, String matricula) { // Updated constructor
        this.nome = nome;
        this.especialidade = especialidade;
        this.disponibilidade = disponibilidade;
        this.matricula = matricula;
        this.head = null;
        this.end = null;
    }
}
