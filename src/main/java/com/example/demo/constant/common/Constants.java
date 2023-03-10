package com.example.demo.constant.common;

public interface Constants {
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	public static final String DEFAULT_TIME_ZONE = "GMT+7";

	public static final int ID_MAX_LENGTH = 36;
	public static final String USER_SYSTEM = "SYSTEM";
	public static final String ZERO_UUID = "00000000-0000-0000-0000-000000000000";
	public static final String PATTERN_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
	public static final int DEFAULT_PAGE_SIZE_MAX = 1000;

	public static final Integer PAGE_SIZE_MAX = 1000;
	public static final String UNKNOWN = "unknown";
	public static final String DEFAULT = "DEFAULT";
}
