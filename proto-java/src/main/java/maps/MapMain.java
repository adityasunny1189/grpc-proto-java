package maps;

import example.maps.Maps;

import java.util.Map;

public class MapMain {

  private static Maps.IdWrapper newIdWrapper(int id) {
    return Maps.IdWrapper.newBuilder()
        .setId(id)
        .build();
  }

  public static void main(String[] args) {
    Maps.MapExample message = Maps.MapExample.newBuilder()
        .putIds("Aditya", newIdWrapper(3))
        .putIds("Amit", newIdWrapper(63))
        .putAllIds(Map.of(
            "Adarsh", newIdWrapper(2),
            "Kunal", newIdWrapper(21)
        ))
        .build();

    System.out.println(message);
  }
}
