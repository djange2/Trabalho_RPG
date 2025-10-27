public class Kendrick extends Personagem {

    public Kendrick() {
        super("Kendrick",90,12,13);
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
        System.out.println(" Kendrick ativa o 'DAMN. Flow'! O inimigo fica abalado psicologicamente!");
        inimigo.ataque -= 3;
        if (inimigo.ataque < 0) inimigo.ataque = 0;
        System.out.println(inimigo.getNome() + " perdeu parte do poder de ataque!");
    }

}
