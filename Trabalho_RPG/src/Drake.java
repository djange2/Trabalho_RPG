public class Drake extends Personagem {

    public Drake(String nome) {
        super(nome,110  ,9,16);
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVida += 5;
        this.ataque += 1;
        this.defesa += 3;
    }
}

