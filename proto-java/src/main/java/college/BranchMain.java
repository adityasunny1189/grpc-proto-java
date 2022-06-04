package college;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.branch.BranchOuterClass;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class BranchMain {

  private static BranchOuterClass.Student newStudent(String usn, String name, double cgpa) {
    return BranchOuterClass.Student.newBuilder()
        .setUsn(usn)
        .setName(name)
        .setCgpa(cgpa)
        .build();
  }

  private static String toJson(BranchOuterClass.Branch branch) throws InvalidProtocolBufferException {
    return JsonFormat.printer().print(branch);
  }

  private static void writeTo(BranchOuterClass.Branch message) {
    try (FileOutputStream fos = new FileOutputStream("ise.bin")) {
      message.writeTo(fos);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void writeToJson(String json) {
    try (FileWriter file = new FileWriter("ise.json")) {
      file.write(json);
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    BranchOuterClass.Branch ise = BranchOuterClass.Branch.newBuilder()
        .setName("Information Science")
        .addStudents(newStudent("1si18is003", "Aditya Pathak", 7.89))
        .addStudents(newStudent("1si18is063", "Amit Shahwal", 9.89))
        .addStudents(newStudent("1si18is002", "Adarsh Shukla", 8.12))
        .build();

    try {
      String json = toJson(ise);
      System.out.println(json);
      writeTo(ise);
      writeToJson(json);
    } catch (InvalidProtocolBufferException e) {
      e.printStackTrace();
    }
  }
}
