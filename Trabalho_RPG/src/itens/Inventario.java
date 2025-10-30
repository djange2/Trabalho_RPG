package itens;

import java.util.*;

public class Inventario implements Cloneable{
    private final List<Item> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item novo) {
        for (Item item : itens) {
            if (item.equals(novo)) {
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
                if (atual.getQuantidade() <= 0) itens.remove(i);
                break;
            }
        }
    }

    public ArrayList<Item> getItens() {
        return new ArrayList<>(itens);
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("O inventário está vazio.");
            return;
        }
        List<Item> ordenados = new ArrayList<>(itens);
        ordenados.sort(Comparator.comparing(Item::getNome));
        for (Item item : ordenados) {
            System.out.println(item.getNome() + " (x" + item.getQuantidade() + ")");
        }
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
        if (obj == this) return true;
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
