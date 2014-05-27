package com.brillio.www.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class PatternMatcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "I will come and meet you at the woods 123woods and all the woods";

		ArrayList<String> tokens = new ArrayList<String>();
		tokens.add("123woods");
		tokens.add("woods");

		String patternString = "\\b(" + StringUtils.join(tokens, "|") + ")\\b";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
		    System.out.println(matcher.group(1));
		}
	}
	
	

}
