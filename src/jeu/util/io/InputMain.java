package jeu.util.io;
public class InputMain {

    public static void readStringExample() {
		System.out.print(" chaine : ? ");
		String chaineLue = Input.readString();
		System.out.println("lue  => " + chaineLue);
    }

    public static void readIntExample() {
			int intLu;
		try {
			System.out.print(" int : ? ");
			intLu = Input.readInt();
			System.out.println("lu  => " + intLu);
		} catch (java.io.IOException e) {
		    //"exception... : la saisie n'est pas un entier";
		    // on peut par exemple ici fournir une valeur par défaut : 
		    intLu = 0;
			System.out.println("mauvaise saisie, corrigée  => " + intLu);
		}
    }
    
    
	// examples for  util.io.Input
	public static void main(String[] args) {
		
	    InputMain.readStringExample();
	    InputMain.readIntExample();
    }
}
