package jogopokemonado;

public class PokemonImpl implements Pokemon {
    private String nome, tipo;
    private int hp, ataque, defesa, especial;

    public PokemonImpl(String nome, String tipo, int hp, int ataque, int defesa, int especial) {
        this.nome = nome;
        this.tipo = tipo;
        this.hp = hp;
        this.ataque = ataque;
        this.defesa = defesa;
        this.especial = especial;
    }

    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public int getHP() { return hp; }
    public int getAtaque() { return ataque; }
    public int getDefesa() { return defesa; }
    public int getEspecial() { return especial; }

    public void reduzirHP(int dano) { hp -= dano; }
}
