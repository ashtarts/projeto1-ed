    public class ListaMesa {
        private Mesa head;

        public ListaMesa() {
            this.head = null;
        }

        public void adicionarMesa(Mesa novaMesa) {
            if (head == null) {
                head = novaMesa;
            } else {
                Mesa temp = head;
                while (temp.proximo != null) {
                    temp = temp.proximo;
                }
                temp.proximo = novaMesa;
            }
        }

        public void fecharMesa(int numero) {
            Mesa temp = head;
            while (temp != null) {
                if (temp.numero == numero) {
                    temp.fecharConta();
                    System.out.println("Mesa " + numero + " fechada com sucesso.");
                    return;
                }
                temp = temp.proximo;
            }
            System.out.println("Mesa " + numero + " não encontrada.");
        }

        public Mesa getMesa(int numero) {
            Mesa temp = head;
            while (temp != null) {
                if (temp.numero == numero) {
                    return temp;
                }
                temp = temp.proximo;
            }
            return null;
        }

        public String listarMesa() {
            StringBuilder sb = new StringBuilder();
            Mesa temp = head;
            while (temp != null) {
                sb.append(temp.toString()).append("\n");
                temp = temp.proximo;
            }
            return sb.toString();
        }

        public boolean mesaAtiva(int numero) {
            Mesa mesa = getMesa(numero);
            return mesa != null && mesa.ativa;
        }
    }
