import java.util.HashMap;
import java.util.Map;

public class Cardapio {
    private Map<Integer, ItemMenu> itens;

    public Cardapio() {
        itens = new HashMap<>();
        itens.put(1, new ItemMenu("Hambúrguer", 20.0));
        itens.put(2, new ItemMenu("Batata Frita", 12.0));
        itens.put(3, new ItemMenu("Refrigerante", 5.0));
        itens.put(4, new ItemMenu("Cachorro-Quente", 15.0));
        itens.put(5, new ItemMenu("Milkshake", 18.0));
        itens.put(6, new ItemMenu("Pastel", 10.0));
        itens.put(7, new ItemMenu("Suco Natural", 8.0));
        itens.put(8, new ItemMenu("Salada de Frutas", 12.0));
        itens.put(9, new ItemMenu("Pizza Pequena", 25.0));
        itens.put(10, new ItemMenu("Sanduíche Natural", 14.0));
        itens.put(11, new ItemMenu("Café Expresso", 6.0));
        itens.put(12, new ItemMenu("Capuccino", 9.0));
        itens.put(13, new ItemMenu("Açaí", 16.0));
        itens.put(14, new ItemMenu("Pão de Queijo", 4.0));
        itens.put(15, new ItemMenu("Chá Gelado", 7.0));
        itens.put(16, new ItemMenu("Salgado Assado", 8.0));
        itens.put(17, new ItemMenu("Torrada", 5.0));
        itens.put(18, new ItemMenu("Croissant", 9.0));
        itens.put(19, new ItemMenu("Sorvete", 10.0));
        itens.put(20, new ItemMenu("Brownie", 12.0));
    }

    public void exibirCardapio() {
        System.out.println("\n---- Cardápio ----");
        for (Map.Entry<Integer, ItemMenu> entry : itens.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getNome() + " - R$ " + entry.getValue().getPreco());
        }
    }

    public ItemMenu selecionarItem(int opcao) {
        return itens.get(opcao);
    }
}

class ItemMenu {
    private String nome;
    private double preco;

    public ItemMenu(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
