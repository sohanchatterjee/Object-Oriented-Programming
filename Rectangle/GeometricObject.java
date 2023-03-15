import java.time.LocalDate;

public abstract class GeometricObject implements Comparable<GeometricObject> {
	private String color;
	private boolean filled;
	private LocalDate dateCreated;

	/** Construct a default geometric object */
	public GeometricObject() {
		dateCreated = LocalDate.now();
		color = "white";
	}

	/**
	 * Construct a geometric object with the specified color and filled value
	 */
	public GeometricObject(String color, boolean filled, double area) {
		dateCreated = LocalDate.now();
		this.color = color;
		this.filled = filled;
	}

	/** Return color */
	public String getColor() {
		return color;
	}

	/** Set a new color */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Return filled. Since filled is boolean, its get method is named isFilled
	 */
	public boolean isFilled() {
		return filled;
	}

	/** Set a new filled */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/** Get dateCreated */
	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public abstract double getArea();

	@Override
	public int compareTo(GeometricObject o) {
		if (this.getArea() > o.getArea())
			return 1;
		else if (this.getArea() < o.getArea())
			return -1;
		return 0;
	}

	/** Return a string representation of this object */
	public String toString() {
		return "created: " + dateCreated + ", color: " + color + " and filled: " + filled;
	}
}