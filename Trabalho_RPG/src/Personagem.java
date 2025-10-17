public abstract class Personagem {
    protected String nome;
    protected int pontosVida;
    protected int ataque;
    protected int defesa;
    protected int nivel;
    protected Inventario inventario;

    public void batalhar(Inimigo inimigo) {
        while (segueBatalha(inimigo)) {
            int valorDado = rolarDado();
            if ((valorDado+this.ataque) > inimigo.defesa) {
                inimigo.pontosVida -= this.ataque + valorDado;
            }
            int valorDadoInimigo = rolarDado();
            if ((valorDadoInimigo+inimigo.ataque) > this.defesa) {
                this.pontosVida -= inimigo.ataque + valorDadoInimigo;
            }
            //TODO: IMPLEMENTAR SUBIR NÍVEL
        }
    }

public int rolarDado() {
    return ((int) (Math.random() * (10)))+1;
}

public boolean segueBatalha(Inimigo inimigo) {
    return (inimigo.pontosVida < 1 || this.pontosVida < 1);
}


@Override
public String toString() {return nome + "(Nível: " + nivel + ")";}

@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Personagem p = (Personagem) obj;
    if (!this.nome.equals(((Personagem) obj).nome) || this.pontosVida != p.pontosVida || this.ataque != p.ataque || this.defesa != p.defesa
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
