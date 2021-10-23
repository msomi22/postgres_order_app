package com.himansusahoo.FileAPI;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main1(String[] args) {
		// TODO Auto-generated method stub

		String s = "3305673. 12";

		System.out.println("=======" + s.trim());
		System.out.println("=======" + StringUtils.trimToEmpty(s));
		System.out.println("=======" + s.replaceAll(" ", ""));
		System.out.println("=======" + new Timestamp(new Date().getTime()));

	}

}
