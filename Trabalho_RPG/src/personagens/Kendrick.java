package personagens;

import personagens.personagem.Personagem;

public class Kendrick extends Personagem {

    public Kendrick() {
        super("Kendrick",90,11,12);
        poderUsado = false;
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVidaMax += 3;
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
        System.out.println("Kendrick ativa 'Euphoria'! Seu ataque aumentou nesse turno!");
        int ataqueOriginal = this.ataque;
        this.ataque += (int) (this.ataque * 0.7);
        rimar(inimigo);
        this.ataque = ataqueOriginal;
        poderUsado = true;
    }

}
