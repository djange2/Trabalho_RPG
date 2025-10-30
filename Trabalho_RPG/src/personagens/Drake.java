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
        System.out.println(" Drake ativa 'God’s Plan'! Ele preparou um ataque duplo!");
        rimar(inimigo);
        inimigo.defesa +=3;
        rimar(inimigo);
        inimigo.defesa -=3;
        poderUsado = true;
    }

}

