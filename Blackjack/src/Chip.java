// Chip class
public class Chip {
	// attributes
	private String name;
	private int value;

	// constructor
	public Chip(String n, int c) {
		if (n.toLowerCase().equals("hundred") && c == 100) {
			name = n;
			value = c;
		} else if (n.toLowerCase().equals("fifty") && c == 50) {
			name = n;
			value = c;
		} else if (n.toLowerCase().equals("twentyfive") && c == 25) {
			name = n;
			value = c;
		} else if (n.toLowerCase().equals("ten") && c == 10) {
			name = n;
			value = c;
		}
	}

	// get methods
	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	// set methods
	public void setName(String n) {
		name = n;
	}

	public void setValue(int c) {
		value = c;
	}

	// toString method
	public String toString() {
		return "Name: " + name + "\nValue: " + value;
	}
}
