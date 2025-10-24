public class Thugger extends Personagem {

    public Thugger() {
        super("Thugger", 70, 13, 11);
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVida += 3;
        this.ataque += 2;
        this.defesa += 1;
    }
}

