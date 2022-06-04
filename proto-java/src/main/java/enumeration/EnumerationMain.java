package enumeration;

import example.enumeration.EnumerationOuterClass;

public class EnumerationMain {
  public static void main(String[] args) {
    EnumerationOuterClass.Enumeration message = EnumerationOuterClass.Enumeration.newBuilder()
        .setEyeColor(EnumerationOuterClass.EyeColor.EYE_COLOR_BROWN)
        .build();

    System.out.println(message);
  }
}
