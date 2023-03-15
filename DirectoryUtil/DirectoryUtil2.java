
//Sohan Chatterjee
//SSW 315 Lab 9
//October 28, 2022
import java.io.*;
import java.text.DecimalFormat;
import java.util.Stack;

public class DirectoryUtil2 {
    static Stack<String> fileStack;
    static Stack<String> orderedStack;

    static class FileInfo {
        public long count;
        public long size;
        public String sizeFormatted;
    }

    public static FileInfo getFileInfo(File file) {
        FileInfo fileInfo = new FileInfo();
        fileStack = new Stack<>();
        orderedStack = new Stack<>();

        long numberOfFiles = 0; // Store the total size of all files
        long sizeOfFiles = 0;

        if (file.isDirectory()) {
            File[] files = file.listFiles(); // All files and subdirectories
            long folderFileCount = 0;
            long folderFileSize = 0;

            for (int i = 0; i < files.length; i++) {
                FileInfo currentFolder = getFileInfo(files[i]); // Recursive call
                folderFileSize += currentFolder.size;
                folderFileCount += currentFolder.count;
            }
            numberOfFiles += folderFileCount;
            sizeOfFiles += folderFileSize;
            fileStack.push(numberOfFiles + "    " + readableFileSize(sizeOfFiles) + "   " + file.getPath());
        } else { // Base case
            numberOfFiles++;
            sizeOfFiles += file.length();
            fileStack.push(numberOfFiles + "    " + readableFileSize(sizeOfFiles) + "   " + file.getPath());
        }

        while (fileStack.size() > 0) {
            orderedStack.push(fileStack.pop());
        }
        while (orderedStack.size() > 0) {
            String temp = orderedStack.pop();
            System.out.println(temp);
            fileStack.push(temp);
        }

        fileInfo.count = numberOfFiles;
        fileInfo.size = sizeOfFiles;
        fileInfo.sizeFormatted = readableFileSize(sizeOfFiles);
        return fileInfo;
    }

    public static String readableFileSize(long size) {
        if (size <= 0)
            return "";
        final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.##").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    public static void getFileReport(String folderName) {
        File f = new File(folderName + ".log");
        getFileInfo(new File(folderName));

        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("could not create new log file");
            }

        }

        FileWriter fstream;
        try {
            fstream = new FileWriter(f, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(fileStack.pop());
            out.newLine();
            out.close();
        } catch (IOException e) {
            System.out.println("could not write to the file");
        }
    }

    public static void main(String[] args) {
        getFileReport("C:/Users/sohan/Documents/Stevens/2022 Fall/SSW 315");
    }
}
