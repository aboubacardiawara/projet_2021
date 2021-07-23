package jeu.board.tile.resource;
/**
 *	Resource class  
 */
public abstract class Resource {
	
	/**the value of the resource(in food or gold or another thing) after the conversion*/
	protected int value;
	
    /**
     * constructor.
     * @param value the resource value.
     */	
	public Resource(int value){
		this.value = value;
	}
	
	/**
	 * allow to get the resource value.
     * Each resource can be converted in another product.
     * It can be food or gold.
	 * @return the value of the resource.
	 */
    public int getValue() {
		return this.value;
	}
	/**
     * The name of the resource, it can be the same as the type.
     * @return the resource's name.
	 */
	public abstract String toString() ;





}
