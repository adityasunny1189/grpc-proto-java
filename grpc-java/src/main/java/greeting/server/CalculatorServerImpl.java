package greeting.server;

import com.proto.calculator.*;
import io.grpc.stub.StreamObserver;

public class CalculatorServerImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {
  @Override
  public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver) {
    responseObserver.onNext(SumResponse.newBuilder().setResult(request.getNumOne() + request.getNumTwo()).build());
    responseObserver.onCompleted();
  }

  @Override
  public void calculatePrime(PrimeRequest request, StreamObserver<PrimeResponse> responseObserver) {
    int number = request.getNum();
    int divisor = 2;
    while (number > 1) {
      if (number % divisor == 0) {
        number /= divisor;
        responseObserver.onNext(PrimeResponse.newBuilder().setNum(divisor).build());
      } else {
        divisor++;
      }
    }
    responseObserver.onCompleted();
  }
}
