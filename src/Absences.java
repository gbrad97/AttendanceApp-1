import java.util.*;

public class Absences {
    public int numOfStudents;
    public int maxNumOfAbsences;
    public ArrayList<Integer> absences;

    public Absences(int numOfStudents, int maxNumOfAbsences) {
        this.numOfStudents = numOfStudents;
        this.maxNumOfAbsences = maxNumOfAbsences;
        absences = generateListOfAbsences(numOfStudents, maxNumOfAbsences);
    }

    public ArrayList<Integer> getAbsences() {
        return absences;
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


    public int howManyPerfectAttendance() {
        int numOfPerfectAttendance = 0;
        for (int numOfAbsences : absences) {
            if (numOfAbsences == 0) {
                numOfPerfectAttendance++;
            }
        }
        return numOfPerfectAttendance;
    }

    public double absenceAverage() {
        int sum = 0;
        for (int num : absences) {
            sum += num;
        }
        return sum / absences.size();
    }


    public ArrayList<Integer> whoHadXAbsences(int num) {
        ArrayList<Integer> studentsWithXAbsences = new ArrayList<>();
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == num) {
                studentsWithXAbsences.add(i + 1);
            }
        }
        return studentsWithXAbsences;
    }


    public  double averageOfNonFE(int num) {
        ArrayList<Integer> nonFEList = new ArrayList<>();
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) < num) {
                nonFEList.add(absences.get(i));
            }
        }
        int sum = 0;
        for (int FE : nonFEList) {
            sum += FE;
        }
        return sum / nonFEList.size();
    }


    public ArrayList<Integer> addXToYAbsences(int num, int numToAdd) {
        ArrayList<Integer> tempList = absences;
        for (int i = 0; i < tempList.size(); i++) {
            if (tempList.get(i) > num) {
                tempList.set(i, tempList.get(i) + numToAdd);
            }
        }
        return tempList;
    }


    public int howManyUniqueValues() {
        Set<Integer> absenceValueSet = new HashSet<>();
        for (int num : absences) {
            absenceValueSet.add(num);
        }
        return absenceValueSet.size();
    }


    public HashMap<Integer,Integer> howManyOfEachValue() {
        HashMap<Integer, Integer> valueMap = new HashMap<>();
        for (int num : absences) {
            if (!valueMap.containsKey(num)) {
                valueMap.put(num, 1);
            }
            else {
                valueMap.put(num, valueMap.get(num) + 1);
            }
        }
        return valueMap;
    }




    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < absences.size(); i++) {
            str.append("\nStudent " + (i + 1) + ": " + absences.get(i));
        }
        return str.toString();
    }
}
