package com.icloud.sclubber;

public interface CheckNull {
	public static final int NOT_NULL = 10;

	public static int checkNull(Object a, Object b) {

		if (a == null && b != null) {
			return -1;
		}
		if (a != null && b == null) {
			return 1;
		}
		if (a == null && b == null) {
			return 0;
		}
		return NOT_NULL;
	}
}
