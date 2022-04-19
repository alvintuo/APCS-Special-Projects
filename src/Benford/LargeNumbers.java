package Benford;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class LargeNumbers {

    int total = 0;
    int one = 0;
    int two = 0;
    int three = 0;
    int four = 0;
    int five = 0;
    int six = 0;
    int seven = 0;
    int eight = 0;
    int nine = 0;

    int testCounter = 0;

    public LargeNumbers(String filename) throws IOException {
        File f = new File("/Users/alvintuo/Desktop/apcs/APCS-Special-Projects/src/Benford/" + filename + ".txt");
        importer(f);
    }

    public void importer(File data) throws IOException {
        Scanner in = new Scanner(data);
        total = in.nextInt();
        for (int i = 0; i < total; i++) {
            int tempInt = in.nextInt();
            String tempString = tempInt + "";
            tempString = tempString.substring(0, 1);
            int firstDigit = Integer.parseInt(tempString);
            switch (firstDigit) {
                case 1:
                    one++;
                    break;
                case 2:
                    two++;
                    break;
                case 3:
                    three++;
                    break;
                case 4:
                    four++;
                    break;
                case 5:
                    five++;
                    break;
                case 6:
                    six++;
                    break;
                case 7:
                    seven++;
                    break;
                case 8:
                    eight++;
                    break;
                case 9:
                    nine++;
                    break;
                default:
                    System.err.println("An error has occured at switch.");

            }
            testCounter++;
        }
        System.out.println(one + " instances of 1");
        System.out.println(two + " instances of 2");
        System.out.println(three + " instances of 3");
        System.out.println(four + " instances of 4");
        System.out.println(five + " instances of 5");
        System.out.println(six + " instances of 6");
        System.out.println(seven + " instances of 7");
        System.out.println(eight + " instances of 8");
        System.out.println(nine + " instances of 9");

        System.out.println();
        System.out.println("*********");
        System.out.println("Checksum:");
        System.out.println("The total amount of numbers is: " + testCounter);
        System.out.println("*********");
        System.out.println();

    }

    public double compare() {
        double result = 0;
        result += Math.abs(30.1 - (((double) one / total) * 100));
        result += Math.abs(17.6 - (((double) two / total) * 100));
        result += Math.abs(12.5 - (((double) three / total) * 100));
        result += Math.abs(9.7 - (((double) four / total) * 100));
        result += Math.abs(7.9 - (((double) five / total) * 100));
        result += Math.abs(6.7 - (((double) six / total) * 100));
        result += Math.abs(5.8 - (((double) seven / total) * 100));
        result += Math.abs(5.1 - (((double) eight / total) * 100));
        result += Math.abs(4.6 - (((double) nine / total) * 100));
        return result;
    }

    public static void main(String[] args) throws IOException {
        String filename = "data3";
        LargeNumbers l = new LargeNumbers(filename);
        double total = l.compare();
        DecimalFormat twoDigits = new DecimalFormat("0.##");
        if (total > 13) System.out.println("There is a red flag (" + twoDigits.format(total) + ")");
        else System.out.println("There is no red flag (" + twoDigits.format(total) + ")");
    }
}