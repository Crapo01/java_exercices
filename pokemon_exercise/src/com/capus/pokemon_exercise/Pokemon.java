package com.capus.pokemon_exercise;

public class Pokemon {
	protected String name;
	protected int attack;
	protected int defence;
	protected int health;
	protected String type;	
	protected String weakness;

	public int getAttack() {
		return attack;
	}
	
	// Constructor
	public Pokemon(String name, int attack, int defence, int health, String type, String weakness) {		
		this.name = name;
		this.attack = attack;
		this.defence = defence;
		this.health = health;
		this.type = type;
		this.weakness = weakness;
	}

	public void calculateDamage(int i, String n) {
		int atk = (int) (i * Math.random() + 1);
		int def = (int) (defence * Math.random() + 1);
		int damageResult = atk - def;
		if (damageResult > 0) {
			health -= damageResult;
			System.out.println("OUCH!!! " + n + " attacked with " + atk + " and "+name+" only has " + def + " in defence");
		} else {
			System.out.println("Cmon!!! "+ n +"... " + atk + " in attack, is far from enough!!!");
		}
		System.out.println(name+": Health left: " +health);
	}

	public void attack(Pokemon targeted) {
		float WeaknessLevel=1.0f;
			if (targeted.weakness == type) {
				System.out.println(targeted.name+": is weak due to his type!!!!");
				WeaknessLevel=1.25f;
			}
			int attackLevel = (int) (attack*WeaknessLevel);
		targeted.calculateDamage(attackLevel,name);
		
	}

	

}
