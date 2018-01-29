import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        //System.out.println("\n\nHi, AttendanceApp!\n");
        //System.out.println("Welcome to Attendance App!");

        //outputWelcomeMsg();

        // Creates a list of absences for 10 students with a max num of 15 absences
        Absences absences = new Absences(10, 15);

        System.out.println(absences);



        // counts the number of students with 0 absences
        int numOfAbsences = absences.howManyPerfectAttendance();
        System.out.println("Number of Students with Perfect Attendance: " + numOfAbsences);

        // Finds the average amount of absences and outputs it
        double averageOfAbsences = absences.absenceAverage();
        System.out.println("\nAverage Number of Absences: " + averageOfAbsences);

        // Finds the students who have 5 absences
        ArrayList<Integer> listOfStudentsWithXAbsences = absences.whoHadXAbsences(5);
        System.out.println("\nStudents with 5 Absences: " + listOfStudentsWithXAbsences);

        // Finds the average of non FE absences (absences less than 6)
        double nonFEAverage = absences.averageOfNonFE(6);
        System.out.println("\nAverage of Non-FE Absences: " + nonFEAverage);

        // Adds 2 to absences greater than 3
        ArrayList<Integer> modifiedListOfAbsences = absences.addXToYAbsences(3, 2);
        System.out.println("\nList of Absences with 2 added to Absences Greater Than 3: ");
        System.out.println(modifiedListOfAbsences);


        /*
        // Sorts the list of absences using a library function
        Collections.sort(listOfAbsences.getAbsences());
        System.out.println("\nSorted Using Library Function: " + listOfAbsences);


        // Shuffles the list of absences using a library function
        Collections.shuffle(listOfAbsences.getAbsences());
        System.out.println("\nShuffle Using a Library Function: " + listOfAbsences);

        */


        // Counts the number of unique absence values
        int numOfUniqueValues = absences.howManyUniqueValues();
        System.out.println("\nNumber of Unique Absence Values: " + numOfUniqueValues);

        // Counts the amount of each absence value
        HashMap<Integer, Integer> absenceValueMap = absences.howManyOfEachValue();
        System.out.println("\nOccurrence of each value: " + absenceValueMap);

        // Sorts the list using a user-defined function
        quickSort(absences.getAbsences(), 0, absences.getAbsences().size() - 1);
        System.out.println("\nSorted List Using User-Defined Function: " + absences.absences);

        // Shuffles the list using a user-defined function
        shuffle(absences.absences);
        System.out.println("\nShuffled List Using a User-Defined Function: " + absences.absences);


    }


    public static void outputWelcomeMsg() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scan.next();
        System.out.println("Hello " + name + "! Welcome to Attendance App!");
    }


    public static void quickSort(ArrayList<Integer> listOfAbsences, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int partition = partition(listOfAbsences, lowIndex, highIndex);
            quickSort(listOfAbsences, lowIndex, partition - 1);
            quickSort(listOfAbsences, lowIndex + 1, highIndex);
        }
    }


    public static int partition(ArrayList<Integer> listOfAbsences, int lowIndex, int highIndex) {
        int pivot = listOfAbsences.get(highIndex);
        int index = lowIndex - 1;

        for (int i = lowIndex; i < highIndex; i++) {
            if (listOfAbsences.get(i) <= pivot) {
                index++;
                swap(listOfAbsences, index, i);
            }
        }
        swap(listOfAbsences, index + 1, highIndex);
        return index + 1;
    }


    public static void swap(ArrayList<Integer> list, int index, int newIndex) {
        int temp = list.get(index);
        list.set(index, list.get(newIndex));
        list.set(newIndex, temp);
    }


    public static void shuffle(ArrayList<Integer> listOfAbsences) {
        Random rand = new Random();
        for (int i = 0; i < listOfAbsences.size(); i++) {
            int newIndex = i + rand.nextInt(listOfAbsences.size() - i);
            swap(listOfAbsences, i, newIndex);
        }
    }












}
