package areas;

public class Area {
    private String nome;
    private int minLvl;

    public Area(String nome, int minLvl) {
        this.nome = nome;
        this.minLvl = minLvl;
    }

    public int getMinLvl() {
        return minLvl;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + " (" + minLvl + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Area a = (Area) obj;
        if (!this.nome.equals(a.nome) && !(this.minLvl == a.minLvl)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int ret = 1;
        ret = ret * 2 + nome.hashCode();
        ret = ret * 2 + ((Integer) minLvl).hashCode();
        return ret;
    }

}

