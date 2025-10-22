public class Inimigo extends Personagem {

    public Inimigo(String nome, int nivel) {
        super(nome,80,8,10);
        this.nivel = nivel;
        this.inventario = new Inventario();
        ajustarStatsPorNivel();
    }

    private void ajustarStatsPorNivel() {
        if (this.nivel == 1) return;
        int lvlups = nivel - 1;
        this.pontosVida += 5 * lvlups;
        this.ataque += 2 * lvlups;
        this.defesa += lvlups;
    }

    @Override
    public void aumentarNivel() {}
}

