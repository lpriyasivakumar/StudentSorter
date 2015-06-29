package model;

public class Student implements Comparable<Student> {
	private String firstName;
	private String lastName;
	private int score;
	public static boolean compareByName = true;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int compareTo(Student o) {
		if (compareByName == true) {
			if ((this.lastName.compareToIgnoreCase(o.lastName) == 0)) {
				return this.firstName.compareToIgnoreCase(o.firstName);
			}
			return this.lastName.compareToIgnoreCase(o.lastName);
		} else {
			return compareByScore(o);
		}
	}

	private int compareByScore(Student o) {
		int comparison;
		if (this.score == o.score)
			comparison = 0;
		else if (this.score > o.score)
			comparison = 1;
		else
			comparison = -1;

		return comparison;
	}
}
