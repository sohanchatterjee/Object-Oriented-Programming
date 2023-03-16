
//Sohan Chatterjee
//SSW 315 Homework 6 Student Records
//December 15, 2022
import java.io.*;
import java.util.*;

public class StudentRecords {
    static class Student {
        private int id;
        private String firstName;
        private String middleName;
        private String lastName;

        public Student() {
            id = 0;
            firstName = "";
            middleName = "";
            lastName = "";
        }

        public Student(String firstName, String middleName, String lastName, int id) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.id = id;
        }

        public String getFirst() {
            return firstName;
        }

        public String getMiddle() {
            return middleName;
        }

        public String getLast() {
            return lastName;
        }

        public int getID() {
            return id;
        }

        public String toString() {
            return firstName + " " + middleName + " " + lastName + " ID: " + id + "\n";
        }
    }

    private static long simulate(List<String> firstNames, List<String> lastNames, List<Student> students,
            String fileName) throws FileNotFoundException {
        long nameTime = readNames(new File("names.txt"), firstNames) + readNames(new File("surnames.txt"), lastNames);
        long generationTime = generateStudentData(firstNames, lastNames, students);
        long sortTime = sortStudentData(students);
        long sequenceTime = sequentialStudentData(students);
        long reportTime = generateReport("randomRecords", students, fileName);
        long totalTime = nameTime + generationTime + sortTime + sequenceTime + reportTime;
        System.out.println("parsed first names and last names in " + nameTime + " seconds");
        System.out.println("Generation: " + generationTime + " sec");
        System.out.println("Sorting: " + sortTime + " sec");
        System.out.println("Sequence: " + sequenceTime + " sec");
        System.out.println("Recording: " + reportTime + " sec");
        System.out.println(fileName + " total: " + totalTime + " sec");
        return totalTime;
    }

    private static long simulate(Set<String> firstNames, Set<String> lastNames, Map<Long, Student> idMap,
            String fileName) throws FileNotFoundException {
        long nameTime = readNames(new File("names.txt"), firstNames) + readNames(new File("surnames.txt"), lastNames);
        long generationTime = generateStudentData(firstNames, lastNames, idMap);
        long sequenceTime = sequentialStudentData(idMap);
        long reportTime = generateReport("randomRecords", idMap.values(), fileName);
        long totalTime = nameTime + generationTime + sequenceTime + reportTime;
        System.out.println("parsed first names and last names in " + nameTime + " seconds");
        System.out.println("Generation: " + generationTime + " sec");
        System.out.println("Sequence: " + sequenceTime + " sec");
        System.out.println("Recording: " + reportTime + " sec");
        System.out.println(fileName + " total: " + totalTime + " sec");
        System.out.println();
        return totalTime;
    }

    private static long readNames(File file, Collection<String> names) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        Scanner scan = new Scanner(file);
        // Adds each name from a file to a list until all lines have been checked.
        while (scan.hasNext()) {
            names.add(scan.next());
        }
        scan.close();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    // Helper method to get random middle initial 50% of the time.
    private static String getRandomMiddleInitial() {
        Random r = new Random();
        int initial = r.nextInt(2);
        if (initial == 1) {
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWZYZ";
            return "" + alphabet.toCharArray()[r.nextInt(alphabet.toCharArray().length)];
        }
        return "";
    }

    private static long generateStudentData(List<String> firstNames, List<String> lastNames, List<Student> students) {
        long startTime = System.currentTimeMillis();
        Random r = new Random();
        // Adds a new student to the student list 100,000 times with a random name each time and incremeting the ID by 1.
        for (int i = 1; i <= 100000; i++) {
            students.add(new Student(firstNames.get(r.nextInt(firstNames.size())), getRandomMiddleInitial(),
                    lastNames.get(r.nextInt(lastNames.size())), i));
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    // Helper method to return random element in a given set
    private static <E> E getRandomElement(Set<E> set) {
        Random r = new Random();
        int randomNum = r.nextInt(set.size());
        Iterator<E> iterator = set.iterator();

        int current = 0;
        E randomElement = null;

        while (iterator.hasNext()) {
            randomElement = iterator.next();
            if (current == randomNum)
                return randomElement;
            current++;
        }
        return randomElement;
    }

    private static long generateStudentData(Set<String> firstNames, Set<String> lastNames, Map<Long, Student> idMap) {
        long startTime = System.currentTimeMillis();
        // Adds a new student to the student list 100,000 times with a random name each time and incremeting the ID by 1.
        for (int i = 1; i <= 100000; i++) {
            idMap.put((long) i, new Student(getRandomElement(firstNames), getRandomMiddleInitial(),
                    getRandomElement(lastNames), i));
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long sortStudentData(List<Student> students) {
        long startTime = System.currentTimeMillis();
        Collections.sort(students, new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                int resultLast = o1.getLast().compareTo(o2.getLast());
                if (resultLast != 0) {
                    return resultLast;
                }
                int resultFirst = o1.getFirst().compareTo(o2.getFirst());
                if (resultFirst != 0) {
                    return resultFirst;
                }
                int resultMiddle = o1.getMiddle().compareTo(o2.getMiddle());
                if (resultMiddle != 0) {
                    return resultMiddle;
                }
                return Integer.compare(o1.getID(), o2.getID());
            }
        });
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long sequentialStudentData(List<Student> students) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            students.get(i).getID();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long sequentialStudentData(Map<Long, Student> studentMap) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
            studentMap.containsKey((long) i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long generateReport(String reportFile, Collection<Student> students, String fileName) {
        long startTime = System.currentTimeMillis();
        File report = new File(reportFile + "." + fileName + ".txt");
        if (!report.exists()) {
            try {
                report.createNewFile();
            } catch (IOException e) {
                System.out.println("could not create new text file");
            }
        }
        FileWriter fstream;
        try {
            fstream = new FileWriter(report, true);
            BufferedWriter out = new BufferedWriter(fstream);
            Iterator<Student> iterator = students.iterator();
            while (iterator.hasNext()) {
                out.write(iterator.next().toString());
            }
            out.close();
        } catch (IOException e) {
            System.out.println("could not write to the file");
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> firstAL = new ArrayList<String>();
        ArrayList<String> lastAL = new ArrayList<String>();
        ArrayList<Student> studentsAL = new ArrayList<Student>();
        StudentRecords.simulate(firstAL, lastAL, studentsAL, "ArrayList");
        LinkedList<String> firstLL = new LinkedList<String>();
        LinkedList<String> lastLL = new LinkedList<String>();
        LinkedList<Student> studentsLL = new LinkedList<Student>();
        StudentRecords.simulate(firstLL, lastLL, studentsLL, "LinkedList");
        HashSet<String> firstHM = new HashSet<String>();
        HashSet<String> lastHM = new HashSet<String>();
        HashMap<Long, Student> studentsHM = new HashMap<Long, Student>();
        StudentRecords.simulate(firstHM, lastHM, studentsHM, "HashMap");
        TreeSet<String> firstTM = new TreeSet<String>();
        TreeSet<String> lastTM = new TreeSet<String>();
        TreeMap<Long, Student> studentsTM = new TreeMap<Long, Student>();
        StudentRecords.simulate(firstTM, lastTM, studentsTM, "TreeMap");
    }
}