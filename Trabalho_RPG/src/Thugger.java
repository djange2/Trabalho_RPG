public class Thugger extends Personagem {

    public Thugger(String nome) {
        super(nome, 80, 13, 11);
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVida += 3;
        this.ataque += 3;
        this.defesa += 1;
    }
}

