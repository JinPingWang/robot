package util;

import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RecordFile {
	synchronized public static void record(String content){
//		Writer in = Files.newBufferedWriter("F:\\eclipse64WorkPlace\\robotOriginal\\robot\\record.txt", "UTF-8");
		Path path = Paths.get("F:\\eclipse64WorkPlace\\robotOriginal\\robot\\record.txt");
//		try(Writer out = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
		try{
			Files.write(path, content.getBytes(), StandardOpenOption.APPEND);
//			out.write(content+"\n");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
