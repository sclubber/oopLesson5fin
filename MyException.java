package com.icloud.sclubber;

public class MyException extends Exception {
	@Override
	public String getMessage() {

		return "This group is full! Create another group for this student.";
	}

}
