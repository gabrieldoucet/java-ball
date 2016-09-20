package helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadFile {
  
  public static ArrayList<String> readFile(String filename) {
    ArrayList<String> lines = new ArrayList<String>();
    try {
      FileReader file = new FileReader(filename);

      BufferedReader reader = new BufferedReader(file);
      String line = reader.readLine();

      // Line by line reading
      while (line != null) {
        lines.add(line);
        line = reader.readLine();
      }
      reader.close();
    } catch (Exception e) {
      System.err.println("Cannot open " + filename + File.pathSeparatorChar);
      e.printStackTrace();
    }
    return lines;
  }
}
