    public class Inimigo extends Personagem {
        private int xpDrop;

        public Inimigo(String nome, int nivel) {
            super(nome,80,9,12);
            this.nivel = nivel;
            this.inventario = new Inventario();
            ajustarStatsPorNivel();
            this.xpDrop = calcularXpDrop();
        }

        private int calcularXpDrop() {
            return (ataque + defesa + pontosVida / 6);
        }

        public int getXpDrop() {
            return xpDrop;
        }

        private void ajustarStatsPorNivel() {
            if (this.nivel == 1) return;
            int lvlups = nivel - 1;
            this.pontosVida += 5 * lvlups;
            this.ataque += 2 * lvlups;
            this.defesa += 2 * lvlups;
        }

        @Override
        public void aumentarNivel() {}
    }

