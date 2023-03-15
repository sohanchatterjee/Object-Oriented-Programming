import java.time.LocalDate;

public class GeometricObject {
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
	public GeometricObject(String color, boolean filled) {
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

	/** Return a string representation of this object */
	public String toString() {
		return "created: " + dateCreated + ", color: " + color + " and filled: " + filled;
	}
}
