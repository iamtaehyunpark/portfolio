
public class UseAnimal {
    public static void main(String[] args) {
	
	Dog rover = new Dog("Rover", 5, 15, "Brown short haired chocolate lab");
	Dog pepper = new Dog("Pepper", 3, 5, "Yorkshire terrier");
	Wildcat iris = new Wildcat("Iris", 10, 75, "Sleek chetah");
	Wildcat mustafa = new Wildcat("Mustafa", 15, 60, "Majestic Lion");
	mustafa.setMane(true);
	Bird tweety = new Bird("Tweety", 2, "Yellow regular bird");

	
	System.out.println(rover.getName() + " : " + rover.describe());
	rover.makeNoise();
	System.out.println(pepper.getName() + " : " + pepper.describe());
	pepper.makeNoise();
	System.out.println(iris.getName() + " : " + iris.describe());
	iris.makeNoise();
	System.out.println(mustafa.getName() + " : " + mustafa.describe());
	mustafa.makeNoise();
	System.out.println(tweety.getName() + " : " + tweety.describe());
	tweety.makeNoise();
    }
}

    
