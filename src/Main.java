import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //System.out.println("\n\nHi, AttendanceApp!\n");
        //System.out.println("Welcome to Attendance App!");

        outputWelcomeMsg();
    }

    public static void outputWelcomeMsg() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scan.next();
        System.out.println("Hello " + name + "! Welcome to Attendance App!");
    }
}
