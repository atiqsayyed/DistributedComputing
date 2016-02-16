package org.rpc.reader;
/**
 * @author
 * Atiq Sayyed
 * 13/02/2016
 */

import java.io.*;
import java.util.ArrayList;

public class FileContentReader implements Reader {

  @Override public ArrayList<String> read(String filePath) {
    ArrayList<String> lines = new ArrayList<String>();
    File file = new File(filePath);
    FileReader fileReader = null;
    try {
      fileReader = new FileReader(file);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        lines.add(line);
      }
      fileReader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return lines;
  }
}

