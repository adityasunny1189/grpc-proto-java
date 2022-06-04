package json;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.SimpleOuterClass;

import java.util.Arrays;

public class JsonMain {

  /**
   * Not working properly will have to look into it.
   * @param json as string
   * @return builder
   */
  private static SimpleOuterClass.Simple fromJson(String json) {
    SimpleOuterClass.Simple builder = SimpleOuterClass.Simple.newBuilder().buildPartial();

    try {
      JsonFormat.parser().merge(json, builder.toBuilder());
    } catch (InvalidProtocolBufferException e) {
      e.printStackTrace();
    }
    return builder;
  }

  private static String toJson(SimpleOuterClass.Simple message) throws InvalidProtocolBufferException {
    return JsonFormat.printer().print(message);
  }

  public static void main(String[] args) {
    SimpleOuterClass.Simple message = SimpleOuterClass.Simple.newBuilder()
        .setId(3)
        .setName("Aditya")
        .setIsSimple(true)
        .addAllSampleList(Arrays.asList(1,2,4,5,6,7))
        .build();

    try {
      String json = toJson(message);
      System.out.println(json);
    } catch (InvalidProtocolBufferException e) {
      e.printStackTrace();
    }
  }
}
