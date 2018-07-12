package zeeslag;
/**
Je speelt het spel met 1 speler(Starter tot gemiddeld).
1 1-dimensionaal veld - Een schip op een rij.
2 statisch raak of mis na een schot in de Scanner
3 twee dimensionaal veld waardoor er een vierkant ontstaat
4 start met gebruik van een daadwerkelijk bootobject
5 regel of iets raak of mis is via dat bootobject
6 na een schot geeft de boot aan of hij zinkt
*/

import java.util.Scanner;

class ZeeslagSpel{
	public static void main(String[] args) {
		Speelveld speelveld = new Speelveld();
		Speler jan = new Speler();
		Boot boot = new Boot();
		
//		for (int i = 0; i < Speelveld.veld.length; i++) {
//			System.out.print(Speelveld.veld[i]);
//		}
//		System.out.println();
		Patrouilleschip Patrouilleschip1 = new Patrouilleschip();
		Patrouilleschip1.positieHorizontaal(3,3);
		Onderzeeer onderzeeer = new Onderzeeer();
		onderzeeer.positieHorizontaal(5, 5);
//		for (int i = 0; i < Speelveld.veld.length; i++) {
//			System.out.print(Speelveld.veld[i]);
//		}	
//		System.out.println();
		int antwoord = 0;
		int antwoord2 = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(Speelveld.veld[i][j]);
			}
			System.out.println();
		}
		
//		System.out.println(boot.gezonken());
		
		
		boolean doorgaan = true;
		while (doorgaan) {
			System.out.println("Bombardeer uw plek");
			System.out.println("welk nummer op de X as?");
			Scanner scanner = new Scanner(System.in);
			antwoord = scanner.nextInt();
			if (antwoord == 9) {
				doorgaan = false;
			}
			else {
				System.out.println("welk nummer op de Y as? (toets 9 om af te sluiten)");
				Scanner scanner2 = new Scanner(System.in);
				antwoord2 = scanner.nextInt();
				
				if (Speelveld.veld[antwoord2-1][antwoord-1] == 0) {
					System.out.println("mis");
					}
					else {
						System.out.println("raak!");
						jan.bombarderen(antwoord2, antwoord);
						if (boot.gezonken() == true) {
							System.out.println("boot gezonken");
						}
					}
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						System.out.print(Speelveld.veld[i][j]);
					}
					System.out.println();
				}
				
			}
				
		}
		System.out.println("Game afgesloten");
	}
}

class Speelveld {
	static int [] [] veld = 
			{{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}};
}

class Boot {
	int lengte = 2;
	boolean gezonken() {
		boolean gzk = false;
		for (int i = 0; i < 10; i++) {
			int counter = 0;
			for (int j = 0; j < 10; j++) {	
				if (Speelveld.veld[i][j] == 8) {
					counter = counter + 1;
				}	
			}
			if (counter == lengte) {
				gzk = true;	
			}
		}
		return gzk;	
	}
}

class Patrouilleschip extends Boot {
	void positieHorizontaal(int plek, int plek2) {
		Speelveld.veld[plek2-1][plek-1] = 4;
		Speelveld.veld[plek2-1][plek] = 4;
	}
//	void positieVerticaal(int startplek) {
//		Speelveld.veld[startplek] = 1;
//		Speelveld.veld[startplekplek+1] = 1;
//	}
	int lengte = 2;
	boolean gezonken() {
		boolean gzk = false;
		for (int i = 0; i < 10; i++) {
			int counter = 0;
			for (int j = 0; j < 10; j++) {	
				if (Speelveld.veld[i][j] == 8) {
					counter = counter + 1;
				}	
			}
			if (counter == lengte) {
				gzk = true;	
			}
		}
		return gzk;	
	}
}

class Onderzeeer extends Boot {
	void positieHorizontaal(int plek, int plek2) {
		Speelveld.veld[plek][plek2] = 5;
		Speelveld.veld[plek][plek2+1] = 5;
		Speelveld.veld[plek][plek2+2] = 5;
	}
	int lengte = 3;
	boolean gezonken() {
		boolean gzk = false;
		for (int i = 0; i < 10; i++) {
			int counter = 0;
			for (int j = 0; j < 10; j++) {	
				if (Speelveld.veld[i][j] == 8) {
					counter = counter + 1;
				}	
			}
			if (counter == lengte) {
				gzk = true;	
			}
		}
		return gzk;	
	}
}

class Speler {
	void bootplaatsen() {		
	}
	static void bombarderen(int plek, int plek2) {
		Speelveld.veld[plek-1][plek2-1] = 8;
	}
}