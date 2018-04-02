package com.icloud.sclubber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Group implements Militar {
	private Student[] studentsArray = new Student[10];
	private String pattern = "[а-€ј-яЄ®a-zA-Z]+$";
	private Pattern p = Pattern.compile(pattern);
	private Matcher matcher;

	public Group() {
		super();
	}

	public void saveGroup(File file) {
		try (PrintWriter pw = new PrintWriter(file)) {
			for (Student student : studentsArray) {
				pw.println(student);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}

	public Group loadGroup(File file) {
		Group group = new Group();
		String[] linesArr = new String[getStudentsArray().length];
		String[] lineArr = new String[7];
		boolean sex;
		try {
			Scanner sc = new Scanner(new FileReader(file));
			for (int i = 0; sc.hasNextLine(); i++) {
				linesArr[i] = sc.nextLine();
				if (linesArr[i] != null) {
					lineArr = linesArr[i].split("( |\n)");
					if (lineArr[2].compareToIgnoreCase("Female") == 0) {
						sex = false;
					} else {
						sex = true;
					}
					Student student = new Student((String) lineArr[0], (String) lineArr[1], sex,
							Integer.valueOf(lineArr[3]), (String) lineArr[4], Integer.valueOf(lineArr[6]));
					studentsArray[i] = student;
					// System.out.println(student);
					group.addStudent(studentsArray[i]);
				}
			}

		} catch (Exception e) {
			 e.printStackTrace();
		}

		return group;
	}

	public void getInfo() {
		for (int i = 0; i < studentsArray.length; i++) {
			if (studentsArray[i] != null) {
				System.out.println(studentsArray[i]);
			}
		}
	}

	public void sortBy() {
		int s;
		int l;
		Scanner sc = new Scanner(System.in);
		System.out.println("1 - сортировки по фамилии " + "\n" + "2 - сортировки по имени " + "\n"
				+ "3 - сортировки по полу " + "\n" + "4 - сортировки по возрасту " + "\n"
				+ "5 - сортировки по специализации " + "\n" + "6 - сортировки по уровню " + "\n");
		s = sc.nextInt();
		System.out.println("¬осход€щ€€ сортировка : 1" + "\n" + "Ќисход€щ€€ сортировка : 2");
		l = sc.nextInt();
		switch (s) {
		case 1:
			if (l == 1) {
				Arrays.sort(studentsArray,
						(a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
								: a.getSurname().compareTo(b.getSurname()));
				break;
			}
			if (l == 2) {
				Arrays.sort(studentsArray,
						(a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
								: -1 * (a.getSurname().compareTo(b.getSurname())));
				break;
			}
		case 2:
			if (l == 1) {
				Arrays.sort(studentsArray,
						(a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
								: a.getName().compareTo(b.getName()));
				break;
			}
			if (l == 2) {
				Arrays.sort(studentsArray,
						(a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
								: -1 * (a.getName().compareTo(b.getName())));
				break;
			}
		case 3:
			if (l == 1) {
				Arrays.sort(studentsArray,
						(a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
								: Boolean.toString(a.isSex()).compareTo(Boolean.toString(b.isSex())));
				break;
			}
			if (l == 2) {
				Arrays.sort(studentsArray,
						(a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
								: -1 * (Boolean.toString(a.isSex()).compareTo(Boolean.toString(b.isSex()))));
				break;
			}
		case 4:
			if (l == 1) {
				Arrays.sort(studentsArray,
						(a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
								: a.getAge() - b.getAge());
				break;
			}
			if (l == 2) {
				Arrays.sort(studentsArray,
						(a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
								: -1 * (a.getAge() - b.getAge()));
				break;
			}
		case 5:
			if (l == 1) {
				Arrays.sort(studentsArray,
						(a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
								: a.getSpecialization().compareTo(b.getSpecialization()));
				break;
			}
			if (l == 2) {
				Arrays.sort(studentsArray,
						(a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
								: -1 * (a.getSpecialization().compareTo(b.getSpecialization())));
				break;
			}
		case 6:
			if (l == 1) {
				Arrays.sort(studentsArray,
						(a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
								: a.getLevel() - b.getLevel());
				break;
			}
			if (l == 2) {
				Arrays.sort(studentsArray,
						(a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
								: -1 * (a.getLevel() - b.getLevel()));
				break;
			}
		}
	}

	public String surnameAdd() {
		String surname = "";

		for (;;) {
			try {
				surname = JOptionPane.showInputDialog("Input surname of new student: ");
				matcher = p.matcher(surname);
				if (surname == null) {
					throw new NullPointerException();
				}
				if (surname == "") {
					throw new NullPointerException();
				}
				if (surname.isEmpty() == true) {
					throw new IllegalArgumentException();
				}
				if (!matcher.find()) {
					throw new IllegalArgumentException();
				}
				break;

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Invalid surname format");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Canceled");
				break;
			}
		}
		return surname;
	}

	public String nameAdd() {
		String name = "";
		for (;;) {
			try {
				name = JOptionPane.showInputDialog("Input name of new student: ");
				matcher = p.matcher(name);
				if (name == null) {
					throw new NullPointerException();
				}
				if (name == "") {
					throw new NullPointerException();
				}
				if (name.isEmpty() == true) {
					throw new IllegalArgumentException();
				}
				if (!matcher.find()) {
					throw new IllegalArgumentException();
				}
				break;

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Invalid name format");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Canceled");
				break;
			}
		}
		return name;
	}

	public boolean sexAdd() {
		String gender = "";
		boolean sex = false;
		for (;;) {
			try {
				gender = JOptionPane.showInputDialog("Input sex of new student(true = M; false = F)");
				matcher = p.matcher(gender);
				if ("true".compareToIgnoreCase(gender) != 0 && "false".compareToIgnoreCase(gender) != 0) {
					throw new IllegalArgumentException();
				}
				sex = Boolean.valueOf(gender);
				if (gender == null) {
					throw new NullPointerException();
				}
				if (gender == "") {
					throw new NullPointerException();
				}
				if (gender.isEmpty() == true) {
					throw new IllegalArgumentException();
				}
				if (!matcher.find()) {
					throw new IllegalArgumentException();
				}
				break;

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Invalid sex format");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Canceled");
				break;
			}
		}
		return sex;

	}

	public int ageAdd() {
		String temp = "";
		int age = 0;
		for (;;) {
			try {
				temp = JOptionPane.showInputDialog("Input age of student");
				if (temp == null) {
					throw new NullPointerException();
				}
				age = Integer.valueOf(temp);
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error number format");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Canceled");
				break;
			}
		}
		return age;
	}

	public String specializationAdd() {
		String specialization = "";
		for (;;) {
			try {
				specialization = JOptionPane.showInputDialog("Input specialization of new student: ");
				if (specialization == null) {
					throw new NullPointerException();
				}
				if (specialization == "") {
					throw new NullPointerException();
				}
				if (specialization.isEmpty() == true) {
					throw new IllegalArgumentException();
				}
				break;

			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Invalid specialization format");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Canceled");
				break;
			}
		}
		return specialization;
	}

	public int levelAdd() {
		int level = 0;
		String temp = "";
		for (;;) {
			try {
				temp = JOptionPane.showInputDialog("Input level of student");
				if (temp == null) {
					throw new NullPointerException();
				}
				level = Integer.valueOf(temp);
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error number format");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Canceled");
				break;
			}
		}
		return level;
	}

	public void addNewStudent() {
		String surname = surnameAdd();
		if (surname != null) {
			String name = nameAdd();
			if (name != null) {
				boolean sex = sexAdd();
				int age = ageAdd();
				if (age > 0) {
					String specialization = specializationAdd();
					if (specialization != null) {
						int level = levelAdd();
						if (level != 0) {
							Student newStudent = new Student(surname, name, sex, age, specialization, level);
							System.out.println(newStudent);
							addStudent(newStudent);
						} else {
							JOptionPane.showMessageDialog(null, "Incorrect parameters of student.");
						}
					}

				}
			}
		}

	}

	public void addStudent(Student student) {
		try {
			for (int i = 0; i < studentsArray.length; i++) {
				if (studentsArray[i] == null) {
					studentsArray[i] = student;
					break;
				} else if (i == 9) {
					throw new MyException();
				}
			}
		} catch (MyException e) {
			System.out.println(e);
		}
	}

	public void delStudent(Student student) {
		for (int i = 0; i < studentsArray.length; i++) {
			if (studentsArray[i] != null && studentsArray[i].equals(student)) {
				studentsArray[i] = null;
			}
		}
	}

	public String findStudent(String surname) {
		Student student = new Student();
		for (int i = 0; i < studentsArray.length; i++) {
			if (studentsArray[i] != null && studentsArray[i].getSurname().equals(surname)) {
				student = studentsArray[i];
			}

		}

		return student.toString();
	}

	public Student[] getStudentsArray() {
		return studentsArray;
	}

	@Override
	public String toString() {
		Student temp;
		for (int i = 0; i < studentsArray.length; i++) {
			for (int j = i; j < studentsArray.length; j++) {
				try {
					if (studentsArray[i].getSurname().compareTo(studentsArray[j].getSurname()) > 0) {
						temp = studentsArray[i];
						studentsArray[i] = studentsArray[j];
						studentsArray[j] = temp;
					}
				} catch (NullPointerException e) {

				}
			}

		}
		String info = "";
		for (int i = 0; i < studentsArray.length; i++) {
			if (studentsArray[i] != null) {
				info += "Group [" + studentsArray[i].toString() + "]" + "\n";
			}
		}
		return info;
	}

}
