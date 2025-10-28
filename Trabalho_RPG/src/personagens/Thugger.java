package personagens;

public class Thugger extends Personagem {

    public Thugger() {
        super("Young Thug", 80, 13, 11);
        poderUsado = false;
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
        if (poderUsado) {
            System.out.println("Você já usou seu poder especial!");
            return;
        }
        System.out.println(" Thugger entra no 'Slime Mode'! Ele se regenera com o poder do trap!");
        int cura = (int) (pontosVidaMax*0.3);
        this.pontosVida += cura;
        if (this.pontosVida > this.pontosVidaMax)
            this.pontosVida = this.pontosVidaMax;

        System.out.println("Thugger recuperou " + cura + " de vida!");
        poderUsado = true;

    }

}

