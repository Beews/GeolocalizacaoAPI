package com.beews.webstart.util;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtil{
	
	private StringUtil() {
		throw new IllegalStateException("Util Class");
	}

    private static final  String BETWEEN_LOWER_AND_UPPER = "(?<=\\p{Ll})(?=\\p{Lu})";
    private static final  String BEFORE_UPPER_AND_LOWER = "(?<=\\p{L})(?=\\p{Lu}\\p{Ll})";

    private static final Pattern SPLIT_CAMEL_CASE = Pattern.compile(
        BETWEEN_LOWER_AND_UPPER +"|"+ BEFORE_UPPER_AND_LOWER
        
    );

    public static String splitCamelCase(String s) {
        return SPLIT_CAMEL_CASE.splitAsStream(s)
                        .collect(Collectors.joining(" "));
    }
}