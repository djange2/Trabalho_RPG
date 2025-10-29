package personagens;

public class Kendrick extends Personagem {

    public Kendrick() {
        super("Kendrick",90,11,12);
        poderUsado = false;
    }

    @Override
    public void aumentarNivel() {
        this.nivel++;
        this.pontosVida += 4;
        this.ataque += 2;
        this.defesa += 2;
    }

    @Override
    public void usarPoderEspecial(Inimigo inimigo) {
        if (poderUsado) {
            System.out.println("Você já usou seu poder especial!");
            return;
        }
        System.out.println("Kendrick ativa 'Euphoria'! Seu ataque aumentou nesse turno!");
        int ataqueOriginal = this.ataque;
        this.ataque += 5;
        rimar(inimigo);
        this.ataque = ataqueOriginal;
        poderUsado = true;
    }

}
