package com.icloud.sclubber;

public interface Militar {
	default Student[] studentsToArmy() {
		Group group = (Group) this;
		int count = 0;
		int countFin = 0;
		Student[] array = group.getStudentsArray();
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null && array[i].getAge() >= 18 && array[i].isSex() == true) {
				count++;
			}
		}
		Student[] arrayToArmy = new Student[count];
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null && array[i].getAge() >= 18 && array[i].isSex() == true) {
				arrayToArmy[countFin] = array[i];
				countFin++;
			}

		}

		return arrayToArmy;
	}

}
