import java.util.LinkedList;
import java.util.Queue;

public class FilaParticipantes {
    private Queue<Participante> fila;

    public FilaParticipantes() { fila = new LinkedList<>(); }

    // Adicionar participante à fila
    public void adicionarNaFila(Participante participante) {
        fila.offer(participante);
    }

    // Remover participante da fila
    public Participante removerDaFila() {
        return fila.poll();
    }

    // Verificar se a fila está vazia
    public boolean isFilaVazia() { return fila.isEmpty(); }

    // Listar participantes na fila
    public void listarFila() {
        System.out.println("\nParticipantes em Espera:");
        for (Participante participante : fila) {
            System.out.println(participante);
        }
    }
}
