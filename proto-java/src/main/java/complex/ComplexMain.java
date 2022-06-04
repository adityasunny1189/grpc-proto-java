package complex;

import example.complex.ComplexOuterClass;

import java.util.Arrays;

public class ComplexMain {

  public static ComplexOuterClass.Dummy newDummy(int id, String name) {
    return ComplexOuterClass.Dummy.newBuilder()
        .setId(id)
        .setName(name)
        .build();
  }

  public static void main(String[] args) {
    ComplexOuterClass.Complex message = ComplexOuterClass.Complex.newBuilder()
        .setOne(newDummy(11, "Dummy 1"))
        .addAllDummies(
            Arrays.asList(
                newDummy(22, "Dummy 2"),
                newDummy(33, "Dummy 3"),
                newDummy(44, "Dummy 4")
            )
        )
        .build();

    System.out.println(message);
  }
}
