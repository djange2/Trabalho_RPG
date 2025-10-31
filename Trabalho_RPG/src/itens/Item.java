package itens;

public class Item implements Comparable<Item>, Cloneable {
    private  String nome;
    private String descricao;
    private String efeito;
    private int valorEfeito;
    private int quantidade;
    private int raridade;

    public Item(String nome, String descricao, String efeito,  int quantidade, int valorEfeito, int raridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.efeito = efeito;
        this.quantidade = quantidade;
        this.valorEfeito = valorEfeito;
        this.raridade = raridade; //1 - comum, 2 - raro, 3 - épico
    }

    @Override
    public String toString() {
        return "Item{" + "nome=" + nome + '}';
    }

    public String getNome() {return nome;}

    public int getQuantidade() {return quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}
    public String getEfeito() {return efeito;}
    public int getValorEfeito() {return valorEfeito;}
    public int getRaridade() {return raridade;}
    public String getDescricao() {return descricao;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        if (!this.nome.equals(((Item) obj).nome) || !this.descricao.equals(((Item) obj).descricao) ||
                !this.efeito.equals(((Item) obj).efeito) || this.valorEfeito != ((Item) obj).valorEfeito ||
                this.raridade != ((Item) obj).raridade) return false;
        quantidade++;
        return true;
    }

    @Override
    public int compareTo(Item i){
        return this.nome.compareTo(i.getNome());
    }

    @Override
    public int hashCode() {
        int ret = 1;
        ret = ret * 2 + this.nome.hashCode();
        ret = ret * 2 + this.descricao.hashCode();
        ret = ret * 2 + this.efeito.hashCode();
        ret = ret * 2 + ((Integer)this.valorEfeito).hashCode();
        ret = ret * 2 + ((Integer)this.raridade).hashCode();
        ret = ret * 2 + ((Integer)this.raridade).hashCode();
        return ret;
    }

    public Item(Item novo) throws Exception{
        if (novo ==  null) throw new Exception("Modelo ausente");
        this.nome = novo.nome;
        this.descricao = novo.descricao;
        this.efeito = novo.efeito;
        this.quantidade = novo.quantidade;
        this.valorEfeito = novo.valorEfeito;
        this.raridade = novo.raridade; //1 - comum, 2 - raro, 3 - épico
    }

    @Override
    public Item clone(){
        Item ret = null;
        try {
            ret = new Item(this);
        } catch (Exception erro) {}
        return ret;
    }

}
