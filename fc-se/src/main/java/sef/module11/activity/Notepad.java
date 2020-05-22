package sef.module11.activity;

//import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;


public class Notepad implements TextEditor {
	
	private BufferedReader in;
	private String pFile;
	private String pName;
	
	public Notepad() {
		System.out.println("Open editor");
		//TODO open input stream
		this.in = new BufferedReader(new InputStreamReader(System.in));
		SetPath();
		File file = new File(GetPath());
		if(file.exists()){
			Print();
		}

	}

	private String InputText(){
		try {
			return this.in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void SetPath(){
		//Example: test
		System.out.println("Enter FileName");
		this.pName = InputText();

		//Example: C:\Users\alexey.tarasenkov\Desktop\
		System.out.println("Enter Path");
		String tp = InputText();

		if(pName.isEmpty() || pFile.isEmpty() || pName == null || pFile == null){
			System.out.println("FileName or Path cannot be empty or null");
			SetPath();
			return;
		}

		this.pFile = "";
		if (tp != null && !tp.isEmpty()) {

			if (tp.lastIndexOf("\\") < 0)
				tp = tp + "\\";

			this.pFile = tp;
		}
	}

	private String GetPath(){
		return String.format(this.pFile + "%s.txt", this.pName);
	}

	private void Print(){
		try {
			List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath(GetPath()));
			for(String s : lines){
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void saveAs(String text) {
		//TODO implement
		if(GetPath().isEmpty())
			SetPath();
		try
		{
			File file = new File(GetPath());
			FileWriter fileWriter = new FileWriter(file.getPath());
			Writer output = new BufferedWriter(fileWriter);

			output.write(text.toString());
			output.flush();
			output.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("File saved");
	}

	@Override
	public String typeIn() {
		//TODO implement
		System.out.println("Input text");
		StringBuilder text = new StringBuilder();
		String line = "";

		while(!line.equals("END")){
			line = InputText();
			if (line.equals("END")) {
				System.out.println("End write");
			} else {
				text.append(line + System.lineSeparator());
			}
		}

		return text.toString();
	}
}
