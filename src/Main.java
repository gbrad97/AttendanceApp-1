import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        //System.out.println("\n\nHi, AttendanceApp!\n");
        //System.out.println("Welcome to Attendance App!");

        //outputWelcomeMsg();

        // Generates a list of absences for 10 students with a max num of 15 absences
        ArrayList<Integer> listOfAbsences = generateListOfAbsences(10, 15);

        // Outputs the list of absences
        outputList(listOfAbsences);

        // counts the number of students with 0 absences
        int numOfAbsences = howManyPerfectAttendance(listOfAbsences);
        System.out.println("Number of Students with Perfect Attendance: " + numOfAbsences);

        // Finds the average amount of absences and outputs it
        double averageOfAbsences = absenceAverage(listOfAbsences);
        System.out.println("\nAverage Number of Absences: " + averageOfAbsences);

        // Finds the students who have 5 absences
        ArrayList<Integer> listOfStudentsWithXAbsences = whoHadXAbsences(listOfAbsences, 5);
        System.out.println("\nStudents with 5 Absences: " + listOfStudentsWithXAbsences);

        // Finds the average of non FE absences (absences less than 6)
        double nonFEAverage = averageOfNonFE(listOfAbsences, 6);
        System.out.println("\nAverage of Non-FE Absences: " + nonFEAverage);

        // Adds 2 to absences greater than 3
        ArrayList<Integer> modifiedListOfAbsences = addXToYAbsences(listOfAbsences, 3, 2);
        System.out.println("\nList of Absences with 3 added to Absences Greater Than 3: ");
        outputList(modifiedListOfAbsences);

        // Sorts the list of absences using a library function
        Collections.sort(listOfAbsences);
        System.out.println("\nSorted Using Library Function: " + listOfAbsences);

        // Shuffles the list of absences using a library function
        Collections.shuffle(listOfAbsences);
        System.out.println("\nShuffle Using a Library Function: " + listOfAbsences);

        // Counts the number of unique absence values
        int numOfUniqueValues = howManyUniqueValues(listOfAbsences);
        System.out.println("\nNumber of Unique Absence Values: " + numOfUniqueValues);


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


    public static double absenceAverage(ArrayList<Integer> listOfAbsences) {
        int sum = 0;
        for (int num : listOfAbsences) {
            sum += num;
        }
        return sum / listOfAbsences.size();
    }


    public static ArrayList<Integer> whoHadXAbsences(ArrayList<Integer> listOfAbsences, int num) {
        ArrayList<Integer> studentsWithXAbsences = new ArrayList<>();
        for (int i = 0; i < listOfAbsences.size(); i++) {
            if (listOfAbsences.get(i) == num) {
                studentsWithXAbsences.add(i + 1);
            }
        }
        return studentsWithXAbsences;
    }


    public static double averageOfNonFE(ArrayList<Integer> listOfAbsences, int num) {
        ArrayList<Integer> nonFEList = new ArrayList<>();
        for (int i = 0; i < listOfAbsences.size(); i++) {
            if (listOfAbsences.get(i) < num) {
                nonFEList.add(listOfAbsences.get(i));
            }
        }
        return absenceAverage(nonFEList);
    }


    public static ArrayList<Integer> addXToYAbsences(ArrayList<Integer> listOfAbsences, int num, int numToAdd) {
        for (int i = 0; i < listOfAbsences.size(); i++) {
            if (listOfAbsences.get(i) > num) {
                listOfAbsences.set(i, listOfAbsences.get(i) + numToAdd);
            }
        }
        return listOfAbsences;
    }


    public static int howManyUniqueValues(ArrayList<Integer> listOfAbsences) {
        Set<Integer> absenceValueSet = new HashSet<>();
        for (int num : listOfAbsences) {
            absenceValueSet.add(num);
        }
        return absenceValueSet.size();
    }
}
