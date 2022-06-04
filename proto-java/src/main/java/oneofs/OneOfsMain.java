package oneofs;

import example.oneofs.Oneof;

public class OneOfsMain {
  public static void main(String[] args) {
    Oneof.OneOfsExample message = Oneof.OneOfsExample.newBuilder()
        .setMessage("A new Message")
        .build();

    System.out.println(message);

    Oneof.OneOfsExample message2 = Oneof.OneOfsExample.newBuilder(message)
        .setId(23)
        .build();

    System.out.println(message2);
  }
}
