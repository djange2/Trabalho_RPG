public class Drake extends Personagem {

    public Drake() {
        super("Drake",110  ,9,14);
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVida += 5;
        this.ataque += 2;
        this.defesa += 2;
    }
    @Override
    public void usarPoderEspecial(Inimigo inimigo) {
        System.out.println(" Drake ativa 'God’s Plan'! Seu ataque aumenta temporariamente!");
        int ataqueOriginal = this.ataque;
        this.ataque += 6;

        int valorDado = rolarDado();
        int dano = this.ataque + valorDado - inimigo.defesa;
        if (dano > 0) {
            inimigo.pontosVida -= dano;
            System.out.println("Drake solta um verso lendário e causa " + dano + " de dano!");
        } else {
            System.out.println("Drake tentou rimar, mas o inimigo rebateu!");
        }

        this.ataque = ataqueOriginal; // volta ao normal depois
    }

}

