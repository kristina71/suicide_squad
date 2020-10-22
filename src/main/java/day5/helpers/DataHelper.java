package day5.helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataHelper {
  public static void filePutContent(String jsonText) {
    Path path = Paths.get("src/data/");
    if (!Files.exists(path)) {
      try {
        Files.createDirectories(path);
      } catch (IOException e) {
        System.err.println("Failed to create directory!" + e.getMessage());
      }
    }

    try (FileWriter writer = new FileWriter("src/data/notes.txt", false)) {
      writer.write(jsonText);
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

  public static String fileGetContent() {
    try (FileReader file = new FileReader("src/data/notes.txt")) {
      BufferedReader reader = new BufferedReader(file);

      String str = "";
      String line = reader.readLine();

      while (line != null) {
        str += line;
        line = reader.readLine();
      }
      return str;

    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    return null;
  }
}
