public class Agendamento {
    String nomePaciente;
    String dataConsulta;
    String detalhes;

    public Agendamento(String nomePaciente, String dataConsulta, String detalhes) {
        this.nomePaciente = nomePaciente;
        this.dataConsulta = dataConsulta;
        this.detalhes = detalhes;
    }

    @Override
    public String toString() {
        return "Paciente: " + nomePaciente + ", Data: " + dataConsulta + ", Detalhes: " + detalhes;
    }
}
