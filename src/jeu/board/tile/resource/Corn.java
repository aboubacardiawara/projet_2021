package jeu.board.tile.resource;

/**
 *	Resource Corn's class 
 */
public class Corn extends Resource {

    public Corn(int value) {
        super(value);
    }


    /**
     * check if two resource are equals.
     * two resource are equals if they have the same type.
     * Example: Rock and another object Rock are equals even they are not same instance.
     * @param o: another object to compare with.
     * @return true if they are equals, else otherwise.
     */
    public boolean equals(Object o) {
        if ( o instanceof Corn ) 
            return true;
        return false;
    }    

    /**
     * The name of the resource, it can be the same as the type.
     * @return the resource's name.
	 */
	public String toString(){
        return "Corn";
    }
}
