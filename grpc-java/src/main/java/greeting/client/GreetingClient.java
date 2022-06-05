package greeting.client;

import com.proto.calculator.CalculatorServiceGrpc;
import com.proto.calculator.SumRequest;
import com.proto.calculator.SumResponse;
import com.proto.greeting.GreetingRequest;
import com.proto.greeting.GreetingResponse;
import com.proto.greeting.GreetingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {
  private static void doGreet(ManagedChannel channel) {
    System.out.println("Enter doGreet");
    GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
    GreetingResponse response = stub.greet(GreetingRequest.newBuilder().setFirstName("Aditya").build());

    System.out.println("Greeting: " + response.getResult());
  }

  private static void doCalculation(ManagedChannel channel) {
    System.out.println("Enter doCalculation");
    CalculatorServiceGrpc.CalculatorServiceBlockingStub stub = CalculatorServiceGrpc.newBlockingStub(channel);
    SumResponse response = stub.sum(SumRequest.newBuilder().setNumOne(673).setNumTwo(190).build());

    System.out.println("Calculation: " + response.getResult());
  }

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Need one argument to work");
    }

    ManagedChannel channel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build();

    switch (args[0]) {
      case "greet": doGreet(channel); break;
      case "calc": doCalculation(channel); break;
      default:
        System.out.println("Keyword invalid");
    }

    System.out.println("Shutting down");
    channel.shutdown();
  }
}
