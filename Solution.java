import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String numberInWords(int i) {
        int tens = i / 10;
        int ones = i - (10 * tens);
        String tensString = "";
        String onesString = "";
        StringBuffer resultString = new StringBuffer();
        if (tens > 0) {
            switch(tens) {
                case 0:
                    tensString = "";
                    break;
                case 1:
                    tensString = "";
                    break;
                case 2:
                    tensString = "twenty ";
                    break;
                case 3:
                    tensString = "thirty ";
                    break;
                case 4:
                    tensString = "forty ";
                    break;
                case 5:
                    tensString = "fifty ";
                    break;
                default:
                    tensString = "";
                    break;
            }
        }
        switch(ones) {
            case 0:
                onesString = "zero";
                break;
            case 1:
                onesString = "one";
                break;
            case 2:
                onesString = "two";
                break;
            case 3:
                onesString = "three";
                break;
            case 4:
                onesString = "four";
                break;
            case 5:
                onesString = "five";
                break;
            case 6:
                onesString = "six";
                break;
            case 7:
                onesString = "seven";
                break;
            case 8:
                onesString = "eight";
                break;
            case 9:
                onesString = "nine";
                break;
            default:
                onesString = "";
                break;
        }
        if (tens == 1) {
            switch(ones) {
            case 0:
                resultString.append("ten");
                break;
            case 1:
                resultString.append("eleven");
                break;
            case 2:
                resultString.append("twelve");
                break;
            case 3:
                resultString.append("thirteen");
                break;
            case 4:
                resultString.append("fourteen");
                break;
            case 5:
                resultString.append("fifteen");
                break;
            case 6:
                resultString.append("sixteen");
                break;
            case 7:
                resultString.append("seventeen");
                break;
            case 8:
                resultString.append("eighteen");
                break;
            case 9:
                resultString.append("nineteen");
                break;
            default:
                onesString = "";
                break;
            }
        } else {
            if (tens > 0) {
                resultString.append(tensString + (ones == 0 ? "" : onesString));
            } else {
                resultString.append(onesString);
            }
        }
        return resultString.toString().trim();
    }

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String hourString = numberInWords(h);
        StringBuffer resultString = new StringBuffer();
        if (m == 0) {
            resultString.append(hourString + " o' clock");
        } else if (m == 15) {
            resultString.append("quarter past " + hourString);
        } else if (m == 30) {
            resultString.append("half past " + hourString);
        } else if (m == 45) {
            resultString.append("quarter to " + numberInWords((h + 1) % 12));
        } else {
            if (m > 0 && m < 30) {
                resultString.append(numberInWords(m) + " minute" + (m == 1 ? "" : "s") + " past " + hourString);
            } else {
                resultString.append(numberInWords(60 - m) + " minutes to " + numberInWords((h + 1) % 12));
            }
        }
        return resultString.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
