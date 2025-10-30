package personagens;

public class Drake extends Personagem {

    public Drake() {
        super("Drake",110,9,14);
        poderUsado = false;
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVidaMax += 5;
        this.ataque += 2;
        this.defesa += 2;
    }

    @Override
    public void usarPoderEspecial(Inimigo inimigo) {
        if (poderUsado) {
            System.out.println("Você já usou seu poder especial!");
            return;
        }
        System.out.println("Drake ativa 'God’s Plan'! Ele regenerou sua vida!");
        int cura = (int) (pontosVidaMax*0.25);
        this.pontosVida += cura;
        if (this.pontosVida > this.pontosVidaMax)
            this.pontosVida = this.pontosVidaMax;

        System.out.println("Drizzy recuperou " + cura + " de vida!");
        poderUsado = true;

    }
}

