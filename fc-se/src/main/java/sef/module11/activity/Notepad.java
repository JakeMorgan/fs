package sef.module11.activity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

public class Notepad implements TextEditor {
	
	private BufferedReader in;
	
	public Notepad() {
		System.out.println("Open editor");
		//TODO open input stream
	}


	@Override
	public void saveAs(String text) {
		//TODO implement
	}

	@Override
	public String typeIn() {
		//TODO implement
		return null;
	}
}
