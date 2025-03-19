/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogopokemonado;

public class PokemonFactory {

    public Pokemon createPokemon(String type) {
        switch (type.toLowerCase()) {
            case "fire":
                return new FirePokemon();
            case "water":
                return new WaterPokemon();
            case "grass":
                return new GrassPokemon();
            default:
                throw new IllegalArgumentException("Tipo de Pokémon desconhecido: " + type);
        }
    }
}
