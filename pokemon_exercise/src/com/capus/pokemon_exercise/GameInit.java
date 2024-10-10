package com.capus.pokemon_exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameInit {
	protected Pokemon player1;
	protected Pokemon player2;	
	protected int turn;
	protected int maxTurnsPerBattle = 100;
	Pokemon p1= new EarthPokemon("Onix", 45, 160, 35, "earth", "fire");
	Pokemon p2= new FirePokemon("Pyroli", 130, 60, 65, "fire", "earth");
	Pokemon p3= new WaterPokemon("Akwakwak",82 ,78, 80, "water", "fire"); 	 	
	Pokemon p4= new EarthPokemon("Grolem", 110, 130, 80, "earth", "water");
	Pokemon p5= new WaterPokemon("Lamantine",70 ,80, 90, "water", "earth");
	List<Pokemon> pokemons = Arrays.asList(p1,p2,p3,p4,p5);
	
	
	public void showAvailablePokemons() {
		System.out.println("////////////////////////////// List of available pokemons:");
		for (Pokemon pokemon : pokemons) {
			System.out.println(pokemon.name+" as "+pokemon.type+" type...");
		}
	}
	
	public void setPlayers() {
		System.out.println("////////////////////////////// Selecting players...");
		Random rand = new Random();
	    player1 = pokemons.get(rand.nextInt(pokemons.size()));
	    System.out.println("Player1 is "+player1.name);
	    do {
			player2 = pokemons.get(rand.nextInt(pokemons.size()));
		} while (player1.name == player2.name);
	    
	    System.out.println("Player2 is "+player2.name);
	}
	
	
	
	//TODO optimization????
	public void battleLoop() {
		do {
			turn ++;
			System.out.println(">>>");
			if ((turn % 2) == 0)
			{
				System.out.println("Turn#:"+turn+" Player1 is attacking");				
				player2.attack(player1);
			}
			else
			{
				System.out.println("Turn#:"+turn+" Player2 is attacking");
				player1.attack(player2);
			}
			System.out.println("End of turn");
			if (player1.health <= 0) {
				System.out.println( player2.name + " defeated "+ player1.name);
			}
			if (player2.health <= 0) {
				System.out.println( player1.name + " defeated "+ player2.name);
			}
		} while (turn<maxTurnsPerBattle && player1.health>0 && player2.health>0);
		System.out.println("////////////////////////////// End of battle");
		
	}

}
