package personagens;

import personagens.personagem.Personagem;

public class Drake extends Personagem {

    public Drake() {
        super("Drake",110,10,14);
        poderUsado = false;
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVidaMax += 4;
        this.ataque += 2;
        this.defesa += 1;
        if (this.nivel == 3 || this.nivel == 5 || this.nivel == 8) {
            System.out.println("====================================");
            System.out.println("Você pode viajar para uma nova área!");
            System.out.println("====================================");
        }
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

