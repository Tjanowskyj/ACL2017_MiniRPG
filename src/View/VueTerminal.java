package View;

import java.util.Observable;
import java.util.Observer;

public class VueTerminal implements Observer {

	
	@Override
	public void update(Observable arg0, Object arg1) {
		String res = "";
		int[][] plateau = (Game)arg0.getLabyrinthe().getplateau();
		for(int i = 0;i < plateau.length;i++){
			for(int j=0;j < plateau[i].length;j++){
				switch(plateau[i][j]){
				
				case 0 : 
					res+="  ";
					break;
					
				case 1 :
					res+="▓▓";
					break;
					
				case 2 : 
					res+="o/";
					break;
				}
			}
			if( i == plateau.length-1 ){
				res+="\n";
			}
		}
		System.out.println(res);
	}

}
