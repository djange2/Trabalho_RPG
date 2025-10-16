import java.util.Objects;

public abstract class Personagem {
    protected String nome;
    protected int pontosVida;
    protected int ataque;
    protected int defesa;
    protected int nivel;
    protected Inventario inventario;

    public abstract void atacar(Personagem inimigo);
    public abstract void defender(Personagem inimigo);

    @Override
    public String toString() {return nome + "(Nível: " + nivel + ")";}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Personagem p = (Personagem) obj;
        if (!Objects.equals(this.nome, p.nome) || this.pontosVida != p.pontosVida || this.ataque != p.ataque || this.defesa != p.defesa
        || this.nivel != p.nivel || this.inventario.equals(p.inventario)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        ret = ret * 2 + this.nome.hashCode();
        ret = ret  * 2 + ((Integer)this.pontosVida).hashCode();
        ret = ret  * 2 + ((Integer)this.ataque).hashCode();
        ret = ret  * 2 + ((Integer)this.defesa).hashCode();
        ret = ret  * 2 + ((Integer)this.nivel).hashCode();
        ret = ret * 2 + this.inventario.hashCode();
        return ret;
    }

}
