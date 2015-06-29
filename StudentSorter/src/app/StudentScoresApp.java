package app;

import java.util.Arrays;
import java.util.Scanner;

import model.*;

public class StudentScoresApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Student Scores Application: ");		
		int num = Validator.getInt(sc, "Enter the number of Students: ");
		createStudentArray(sc,num);
		sc.close();
	}

	private static void createStudentArray(Scanner sc, int num) {
		Student[] studentArray = new Student[num];
		String firstName = "";
		String lastName ="";
		int score = 0;
		for(int i =0; i< num; i++){
			lastName = Validator.getString(sc, "Student "+ (i+1) + " lastname: ");
			firstName = Validator.getString(sc, "Student "+ (i+1) + " firstname: ");
			score = Validator.getIntInRange(sc, "Student "+ (i+1) + " score: ", 0,100);
			studentArray[i] = new Student();
			studentArray[i].setFirstName(firstName);
			studentArray[i].setLastName(lastName);
			studentArray[i].setScore(score);
		}
		sortAndDisplayStudent(sc,studentArray);		
	}

	private static void sortAndDisplayStudent(Scanner sc, Student[] studentArray) {
		System.out.println("How do you want to sort the Students: ");		
		String choice = Validator.getChoice(sc, "By Name or Score Enter (N/S): ","N", "S");
		if (choice.equalsIgnoreCase("S"))
			Student.compareByName = false;		
		
		Arrays.sort(studentArray);
		displayStudent(studentArray);
	}

	private static void displayStudent(Student[] studentArray) {
		for(Student s: studentArray){
			System.out.println(s.getLastName()+", "+s.getFirstName()+": "+s.getScore());
		}
		
	}

}
