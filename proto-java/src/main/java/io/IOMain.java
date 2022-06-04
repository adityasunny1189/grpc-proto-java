package io;

import example.simple.SimpleOuterClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOMain {

  private static void writeTo(SimpleOuterClass.Simple message, String path) {
    try (FileOutputStream fos = new FileOutputStream(path)) {
      message.writeTo(fos);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void readFrom(String path) {
    try (FileInputStream fis = new FileInputStream(path)) {
      SimpleOuterClass.Simple message = SimpleOuterClass.Simple.parseFrom(fis);
      System.out.println(message);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    SimpleOuterClass.Simple message = SimpleOuterClass.Simple.newBuilder()
        .setId(3)
        .setName("Aditya")
        .setIsSimple(true)
        .build();

    String path = "simple.bin";

    writeTo(message, path);
    readFrom(path);
  }
}
