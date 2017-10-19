import Model.Game;

import java.util.Scanner;


public class Main {
	public static void main(String[]args){
		Game g = new Game();
		Scanner sc = new Scanner(System.in);
			String s = sc.next();
			if(s.equals("z")){
				g.bouger("haut");
			}
			if(s.equals("q")){
				g.bouger("gauche");
			}
			if(s.equals("s")){
				g.bouger("bas");
			}
			if(s.equals("d")){
				g.bouger("droite");
			}
		}
}
