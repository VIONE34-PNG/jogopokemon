public enum Movimento {
    ATAQUE(new EstrategiaAtaque()),
    DEFESA(new EstrategiaDefesa()),
    ESPECIAL(new EstrategiaEspecial());

    private EstrategiaMovimento estrategia;

    Movimento(EstrategiaMovimento estrategia) {
        this.estrategia = estrategia;
    }

    public int calcularDano(Pokemon atacante, Pokemon defensor) { return estrategia.calcularDano(atacante, defensor);}
}
