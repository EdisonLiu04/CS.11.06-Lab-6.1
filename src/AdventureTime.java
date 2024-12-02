import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(challengeOne("inputOneTwo.txt"));
        System.out.println(challengeTwo("inputOneTwo.txt"));
        System.out.println(challengeThree("inputThreeFour.txt"));
        System.out.println(challengeFour("inputThreeFour.txt"));

    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] numbers = readFile(fileName);
        int counter = 0;
        for(int i = 0; i<numbers.length-1;i++){
            if(numbers[i]>numbers[i+1]){
                counter ++;
            }
        }
        return counter;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] numbers = readFile(fileName);
        int count = 0;
        for(int i = 0;i<numbers.length-3;i++){
            int firstSum = numbers[i]+numbers[i+1]+numbers[i+2];
            int secondSum = numbers[i+1]+numbers[1+2]+numbers[i+3];
            if(secondSum>firstSum){
                count++;
            }
        }
        return count;
     }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] readfile = readStringFile(fileName);
        int depth = 0;
        int horizontal = 0;
        for(int i = 0; i<readfile.length; i++){
            String currentPosition = readfile[i];
            String[] splitting = currentPosition.split(" ");
            if (splitting[0].equals("forward")){
                horizontal += Integer.parseInt(splitting[1]);
            } else if (splitting[0].equals("down")) {
                depth += Integer.parseInt(splitting[1]);
            } else  {
                depth -= Integer.parseInt(splitting[1]);
            }

        }
        return depth*horizontal;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String[] read = readStringFile(filename);
        int depth = 0;
        int horizontal = 0;
        int aim = 0;
        for(int i =0; i<read.length; i++){
            String currentPosition = read[i];
            String[] splitting = currentPosition.split(" ");
            if (splitting[0].equals("forward")){
                horizontal += Integer.parseInt(splitting[1]);
                depth += aim*Integer.parseInt(splitting[1]);
            } else if (splitting[0].equals("up")) {
                aim-=Integer.parseInt(splitting[1]);
            } else {
                aim+=Integer.parseInt(splitting[1]);
            }
        }
        return horizontal*depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static String[] readStringFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }
}