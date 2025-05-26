
public abstract class Animal {
	// abstract class mixes an interface with a super class
	protected String species;
    protected String genus;
    protected String family;
    
    public Animal () {}
    
    // in order to use makesSound from Cat class, you have to instantiate it here
    public abstract String makesSound();
    
    public String toString() {
        String message;
        message = "The " + species;
        message += " of genus " +  genus;
        message += " and family " + family;
        message += " makes this sound: ";
        message += makesSound();
        return message;
    }
}
