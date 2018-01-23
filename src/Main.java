import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //System.out.println("\n\nHi, AttendanceApp!\n");
        //System.out.println("Welcome to Attendance App!");

        outputWelcomeMsg();

        // Generates a list of absences for 10 students with a max num of 15 absences
        ArrayList<Integer> listOfAbsences = generateListOfAbsences(10, 15);

        // Outputs the list of absences
        outputList(listOfAbsences);

        // counts the number of students with 0 absences
        System.out.println("Number of Students with Perfect Attendance: " + howManyPerfectAttendance(listOfAbsences));
    }

    public static void outputWelcomeMsg() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scan.next();
        System.out.println("Hello " + name + "! Welcome to Attendance App!");
    }

    public static ArrayList<Integer> generateListOfAbsences(int numOfStudents,
                                                            int maxNumOfAbsences) {
        ArrayList<Integer> listOfAbsences = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < numOfStudents; i++) {
            int absences = rand.nextInt(maxNumOfAbsences + 1);
            listOfAbsences.add(absences);
        }
        return listOfAbsences;
    }

    public static void outputList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Student " + (i + 1) + ": " + list.get(i));
        }
    }

    public static int howManyPerfectAttendance(ArrayList<Integer> listOfAbsences) {
        int numOfPerfectAttendance = 0;
        for (int numOfAbsences : listOfAbsences) {
            if (numOfAbsences == 0) {
                numOfPerfectAttendance++;
            }
        }
        return numOfPerfectAttendance;
    }
}
