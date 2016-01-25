public abstract class Animal {
	private int order;
	protected String name;
	public Animal(String n) {name = n;}
	public void setOrder(int ord) {order = ord;}
	public int getOrder() {return order;}
}
class Dog extends Animal {
	public Dog(String n) {
		super(n);
	}
}
class Cat extends Animal {
	public Cat(String n) {
		super(n);
	}
}

class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	int order = 0;
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;

		if (a instanceof Cat) cats.add((Cat)a);
		else if (b instanceof Dog) dogs.add((Dog)a);
	}

	public Animal dequeueAny() {
		if (dogs.size() == 0) return cats.poll();
		else if (cats.size() == 0) return dogs.poll();

		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		if (dog.getOrder() < cat.getOrder()) {
			return dogs.poll();
		} else {
			return cats.poll();
		}
	}
}

