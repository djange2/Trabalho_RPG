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



}
