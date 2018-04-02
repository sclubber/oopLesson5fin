package com.icloud.sclubber;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		Student studentOne = new Student("Domoslavskyi", "Mykola", true, 31, "OOP", 2);
		Student studentTwo = new Student("Einstein", "Albert", true, 66, "Phisics", 100500);
		Student studentThree = new Student("Fisun", "Magdalina", false, 22, "Economics", 1);
		Student studentFour = new Student("Armani", "Shcet", true, 45, "Design", 4);
		Student studentFive = new Student("Crowford", "Sindy", false, 30, "Java", 1);
		Student studentSix = new Student("Iyova", "Lara", false, 24, "C#", 4);
		Group groupOne = new Group();
		groupOne.addStudent(studentOne);
		groupOne.addStudent(studentTwo);
		groupOne.addStudent(studentThree);
		groupOne.addStudent(studentFour);
		groupOne.addStudent(studentFive);
		groupOne.addStudent(studentSix);
		// System.out.println(groupOne.toString());
		// groupOne.delStudent(studentFive);
		// System.out.println(groupOne.toString());
		// System.out.println(groupOne.findStudent("Domoslavskyi"));
		// System.out.println();
		// System.out.println(groupOne.toString());
		// groupOne.addNewStudent();
		// System.out.println(groupOne.toString());
		// groupOne.sortBy();
		groupOne.getInfo();
		// System.out.println();
		// System.out.println("To army");
		// System.out.println(groupOne.studentsToArmy(groupOne));
		// groupOne.studentsToArmy();
		// for (Student student : groupOne.studentsToArmy()) {
		// System.out.println(student);
		// }
		File fileOne = new File("test.txt");
		groupOne.saveGroup(fileOne);
		Group groupTwo = new Group();
		groupTwo.loadGroup(fileOne);
		System.out.println();
		groupTwo.getInfo();

	}

}
