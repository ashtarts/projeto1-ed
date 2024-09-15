package Restaurante;

public class ListaMesa {
    MesaNode primeiro;

    public ListaMesa() {
        primeiro = null;
    }

    public void adicionarMesa(Mesa mesa) {
        MesaNode novaMesa = new MesaNode(mesa);
        if (primeiro == null) {
            primeiro = novaMesa;
        } else {
            MesaNode atual = primeiro;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novaMesa;
        }
    }

    public Mesa buscarMesa(int numero) {
        MesaNode atual = primeiro;
        while (atual != null) {
            if (atual.mesa.numero == numero) {
                return atual.mesa;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public void fecharMesa(int numero) {
        Mesa mesa = buscarMesa(numero);
        if (mesa != null) {
            mesa.fecharConta();
        }
    }

    public void listarMesa() {
        MesaNode atual = primeiro;
        while (atual != null) {
            System.out.println(atual.mesa);
            atual = atual.proximo;
        }
    }
}