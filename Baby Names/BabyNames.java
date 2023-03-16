
//Sohan Chatterjee
//SSW 315 Baby Names Homework
//November 16, 2022
import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BabyNames {
    // Name: Year, Occurrences
    private List<Map<String, HashMap<String, Integer>>> maps; // 0 = boy, 1 = girl
    private LinkedHashMap<String, String> csvStrings;
    private LinkedHashMap<String, Integer> sortedMap;

    // new functions
    // sort an entire hashmap of people to their total occurences. gives general map
    // ranking.
    // for each person in sorted hashmap, find ranking of person in each year. put
    // into nested list with name, year, rank.
    // go thru each person in already sorted nested hashmap, then each of their
    // years. create string, then put it into csv.

    public BabyNames() {
        maps = new ArrayList<Map<String, HashMap<String, Integer>>>();
        maps.add(new HashMap<String, HashMap<String, Integer>>());
        maps.add(new HashMap<String, HashMap<String, Integer>>());
        csvStrings = new LinkedHashMap<String, String>();
        sortedMap = new LinkedHashMap<String, Integer>();
    }

    private void goThroughAllFiles(String path, int gender) throws FileNotFoundException {
        File folder = new File(path);
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            for (File f : files) {
                buildMapToSort(f.getPath(), gender);
            }
        }
    }

    // builds unsorted map with just name and total occurences
    private void buildMapToSort(String f, int gender) throws FileNotFoundException {

        File file = new File(f);
        if (!file.exists()) {
            System.out.println("File " + file + " does not exist");
            System.exit(1);
        }
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String[] line = input.next().split(",");
            // filtering the lines based on gender's value. 1 for female, 0 for male.
            if (line[1].equals(gender == 1 ? "F" : "M")) {
                int occurences = Integer.parseInt(line[4]);
                String year = line[2];
                String name = line[3];

                if (!maps.get(gender).containsKey(name)) {
                    maps.get(gender).put(name, new HashMap<String, Integer>());
                }
                // build maps
                if (maps.get(gender).get(name).containsKey(year)) {
                    // replace that hashmap entry with the year that's already there added to the
                    // current year
                    maps.get(gender).get(name).put(year, maps.get(gender).get(name).get(year) + occurences);
                } else {
                    // if the gender map's name entry doesn't already have # occurence, create the
                    // hashmap entry for that year and give it value occurences.
                    maps.get(gender).get(name).put(year, occurences);
                }
            }
        }
    }

    private HashMap<String, Integer> getMapByYear(int gender, String year) {
        HashMap<String, Integer> temp = new HashMap<String, Integer>();

        if (year.equals("all")) {
            for (Map.Entry<String, HashMap<String, Integer>> t : maps.get(gender).entrySet()) {
                String key = t.getKey();
                for (Map.Entry<String, Integer> e : t.getValue().entrySet()) {
                    temp.put(key, e.getValue());
                }
            }
            return temp;
        }

        if (year.endsWith("s")) {
            String startYear = year.substring(0, 4);
            int count = Integer.parseInt(startYear);
            for (int i = count; i < count + 10; i++) {
                for (Map.Entry<String, HashMap<String, Integer>> t : maps.get(gender).entrySet()) {
                    String key = t.getKey();
                    for (Map.Entry<String, Integer> e : t.getValue().entrySet()) {
                        if (e.getKey().equals("" + i)) {
                            temp.put(key, e.getValue());
                        }
                    }
                }
            }
            return temp;
        }

        for (Map.Entry<String, HashMap<String, Integer>> t : maps.get(gender).entrySet()) {
            String key = t.getKey();
            for (Map.Entry<String, Integer> e : t.getValue().entrySet()) {
                if (e.getKey().equals(year)) {
                    temp.put(key, e.getValue());
                }
            }
        }
        return temp;
    }

    private LinkedHashMap<String, Integer> sortMap(HashMap<String, Integer> unsortedMap) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : unsortedMap.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer int1, Integer int2) {
                return (int1).compareTo(int1);
            }
        });
        int rank = 1;
        for (Integer int1 : list) {
            int max = Collections.max(unsortedMap.values());
            String tempKey = "";
            for (Entry<String, Integer> entry : unsortedMap.entrySet()) {
                if (entry.getValue() == max) {
                    tempKey = entry.getKey();
                    sortedMap.put(entry.getKey(), rank);
                    rank++;
                }
            }
            unsortedMap.remove(tempKey);
        }
        return sortedMap;
    }

    public void printmap(int gender, String year) throws FileNotFoundException {
        reset();
        goThroughAllFiles("C:/Users/sohan/Documents/Stevens/2022 Fall/SSW 315/Baby Names/namesbystate", gender);

        File result;
        if (gender == 0)
            result = new File(year + "_RankedBabyBoyNames" + ".csv");
        else
            result = new File(year + "_RankedBabyGirlNames" + ".csv");

        if (!result.exists()) {
            try {
                result.createNewFile();
            } catch (IOException e) {
                System.out.println("could not create new csv file");
            }
        }
        FileWriter fstream;
        try {
            fstream = new FileWriter(result, true);
            BufferedWriter out = new BufferedWriter(fstream);
            String csvTitle = " ";
            ArrayList<String> yearList = new ArrayList<String>();
            for (int i = 1910; i < 2022; i++) {
                yearList.add("" + i);
            }

            //print csv title
            for (int i = 0; i < yearList.size(); i++) {
                csvTitle += "," + yearList.get(i);
            }
            out.write(csvTitle);
            out.newLine();

            //rank input year names
            HashMap<String, Integer> inputYearMap = getMapByYear(gender, year);
            LinkedHashMap<String, Integer> inputSortedMap = sortMap(inputYearMap);
            for (Map.Entry<String, Integer> e : inputSortedMap.entrySet()) {
                if (!csvStrings.containsKey(e.getKey())) {
                    csvStrings.put(e.getKey(), e.getKey());
                }
            }

            //rank all years
            for (int i = 0; i < yearList.size(); i++) {
                HashMap<String, Integer> yearMap = getMapByYear(gender, yearList.get(i));
                LinkedHashMap<String, Integer> sortedYearMap = sortMap(yearMap);
                String tempValue = "";
                for (Map.Entry<String, Integer> t : sortedYearMap.entrySet()) {
                    if (!csvStrings.containsKey(t.getKey())) {
                        csvStrings.put(t.getKey(), t.getKey());
                    }
                    csvStrings.put(t.getKey(), csvStrings.get(t.getKey()) + "," + t.getValue());
                }
            }

            //iterate thru hashmap and print
            boolean write = true;
            int count = 1;
            for (Map.Entry<String, String> name : csvStrings.entrySet()) {
                if (write) {
                    out.write(name.getValue());
                    out.newLine();
                    count++;
                }
                if (count > 99) {
                    write = false;
                }
            }
            out.close();
        } catch (IOException e) {
            System.out.println("could not write to the file");
            System.exit(1);
        }
    }

    private void reset() {
        maps.clear();
        maps.add(new HashMap<String, HashMap<String, Integer>>());
        maps.add(new HashMap<String, HashMap<String, Integer>>());
        csvStrings.clear();
        sortedMap.clear();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the base year or decade or all: ");
        String userInput = scan.nextLine();
        BabyNames b = new BabyNames();
        try {
            b.printmap(0, userInput);
            b.printmap(1, userInput);
        } catch (Exception e) {
            System.out.println("ERROR!!!: " + e);
            System.exit(1);
        }
    }
}