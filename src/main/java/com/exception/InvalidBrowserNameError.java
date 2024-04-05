package com.exception;

public class InvalidBrowserNameError extends Error {

	String msg;

	public InvalidBrowserNameError(String browserName) {

		msg = "Invalid browser name" + browserName;
	}

	public String toString() {

		return msg;
	}
}
