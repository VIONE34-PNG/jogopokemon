public interface EstrategiaMovimento {
    int calcularDano(Pokemon atacante, Pokemon defensor);
}

public class EstrategiaAtaque implements EstrategiaMovimento {
    @Override
    public int calcularDano(Pokemon atacante, Pokemon defensor) { return atacante.getAtaque();}
}

public class EstrategiaDefesa implements EstrategiaMovimento {
    @Override
    public int calcularDano(Pokemon atacante, Pokemon defensor) { return 0; }
}

public class EstrategiaEspecial implements EstrategiaMovimento {
    @Override
    public int calcularDano(Pokemon atacante, Pokemon defensor) { return atacante.getEspecial();}
}
