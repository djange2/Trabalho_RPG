import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Inventario {
    private List<Item> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item novo) {
        for (Item item : itens) {
            if (item.equals(novo)) {
                item.setQuantidade(item.getQuantidade() + novo.getQuantidade());
                return;
            }
        }
        itens.add(novo);
    }

    public void removerItem(String nomeItem) {
        for (Item item : itens) {
            if (item.getNome().equals(nomeItem)) {
                item.setQuantidade(item.getQuantidade() - 1);
                if (item.getQuantidade() == 0) {itens.remove(item);}
                return;
            }
        }
    }

    public void  listarItems() {
        Collections.sort(itens);
        System.out.print("Lista de itens : ");
        for (Item item : itens) {System.out.println(item.getNome());}
    }



}
