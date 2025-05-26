
public class Cat extends Animal {
	public Cat() {
        // super("Cat", "Felis", "Felidae");
		genus = "Cat";
		species = "Felis";
		family = "Felidae";
    }
    
	
    public String makesSound() {
        return "meow";
    }
}
