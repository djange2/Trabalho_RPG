public class Thugger extends Personagem {

    public Thugger() {
        super("Young Thug", 70, 13, 11);
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVida += 3;
        this.ataque += 2;
        this.defesa += 1;
    }

    @Override
    public void usarPoderEspecial(Inimigo inimigo) {
        System.out.println(" Thugger entra no 'Slime Mode'! Ele se regenera com o poder do trap!");
        int cura = 20;
        this.pontosVida += cura;
        if (this.pontosVida > this.pontosVidaMax)
            this.pontosVida = this.pontosVidaMax;

        System.out.println("Thugger recuperou " + cura + " de vida!");
    }

}

