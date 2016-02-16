package org.rpc.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileContentWriter implements Writer {
  @Override public boolean write(String line, String filePath) {
    try {
       BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
       writer.write("\n"+line);
       writer.close();
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }
}
