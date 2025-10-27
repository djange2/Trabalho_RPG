import java.util.*;

public class Inventario implements Cloneable{
    private final List<Item> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item novo) {
        for (Item item : itens) {
            if (item.getNome().equals(novo.getNome())) {
                item.setQuantidade(item.getQuantidade() + novo.getQuantidade());
                return;
            }
        }
        itens.add(novo.clone());
    }

    public void removerItem(Item item) {
        for (int i = 0; i < itens.size(); i++) {
            Item atual = itens.get(i);
            if (atual.getNome().equals(item.getNome())) {
                atual.setQuantidade(atual.getQuantidade() - item.getQuantidade());
                if (atual.getQuantidade() == 0) itens.remove(i);
                break;
            }
        }
    }

    public ArrayList<Item> getItens() {
        return (ArrayList<Item>) itens;
    }

    public Inventario (Inventario mod) throws Exception{
        if (mod == null) throw new Exception("Erro ao tentar criar um Inventario");
        this.itens = new ArrayList<>();
        for (Item item : mod.itens) {this.itens.add(item.clone());}
    }

    @Override
    public Inventario clone(){
        Inventario retorno = null;
        try {
            retorno = new Inventario(this);
        }catch (Exception erro) {}
        return retorno;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return false;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Inventario i = (Inventario) obj;
        if (this.itens.size() != i.itens.size()) return false;
        for (Item item : this.itens) {
            if (!i.itens.contains(item)) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        ret = ret * 2 + ((ArrayList<?>)itens).hashCode();
        return ret;
    }

    @Override
    public String toString() {
        return "Inventario{" + "itens=" + itens + '}';
    }

    public boolean isEmpty() {
        return itens.isEmpty();
    }
}
