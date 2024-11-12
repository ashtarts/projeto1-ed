import java.util.LinkedList;
import java.util.Queue;

public class FilaAtendimento {
    private Queue<Agendamento> filaLeve;
    private Queue<Agendamento> filaGrave;
    private Queue<Agendamento> filaMuitoGrave;

    public FilaAtendimento() {
        this.filaLeve = new LinkedList<>();
        this.filaGrave = new LinkedList<>();
        this.filaMuitoGrave = new LinkedList<>();
    }

    public void adicionarNaFila(Agendamento agendamento, String gravidade) {
        switch (gravidade.toLowerCase()) {
            case "muito grave":
                filaMuitoGrave.add(agendamento);
                break;
            case "grave":
                filaGrave.add(agendamento);
                break;
            default:
                filaLeve.add(agendamento);
                break;
        }
        System.out.println("Agendamento adicionado na fila com gravidade: " + gravidade);
    }

    public Agendamento atenderProximo() {
        if (!filaMuitoGrave.isEmpty()) {
            return filaMuitoGrave.poll();
        } else if (!filaGrave.isEmpty()) {
            return filaGrave.poll();
        } else if (!filaLeve.isEmpty()) {
            return filaLeve.poll();
        }
        System.out.println("Nenhum paciente na fila de atendimento.");
        return null;
    }
}
