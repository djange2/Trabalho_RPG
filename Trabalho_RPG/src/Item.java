import java.util.Objects;

public class Item implements Comparable<Item> {
    private  String nome;
    private String descricao;
    private String efeito;
    private int quantidade;

    public Item(String nome, String descricao, String efeito,  int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.efeito = efeito;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Item{" + "nome=" + nome + '}';
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}
    public int getQuantidade() {return quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        if (!Objects.equals(this.nome, ((Item) obj).nome) || !Objects.equals(this.descricao, ((Item) obj).descricao) || !Objects.equals(this.efeito, ((Item) obj).efeito)) return false;
        quantidade++;
        return true;
    }

    @Override
    public int compareTo(Item i){
        if (this.nome.compareTo(i.getNome()) > 0) return -1;
        if (this.nome.compareTo(i.getNome()) < 0) return 1;
        return 0;
    }

}
