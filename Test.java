import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scannerForReadingData = new Scanner(System.in);
//        System.out.println("Enter the input file name!!");
//        String inputFileName = scannerForReadingData.nextLine();
//
//        while(true) {
//            System.out.println("Enter the byte ordering (l or b)!!");
//            String byteOrdering = scannerForReadingData.nextLine();
//            if(byteOrdering.equals("l") || byteOrdering.equals("b"))
//                break;
//        }
//
//        while (true){
//            System.out.println("Enter the size of the data type (1,2,3,4)!!");
//            int dataSize = scannerForReadingData.nextInt();
//            if(dataSize == 1 || dataSize == 2 || dataSize == 3 || dataSize == 4)
//                break;
//        }
//
//        File file = new File(System.getProperty("user.dir")+"\\"+inputFileName);
//        Scanner scannerForFile = new Scanner(file);
//
//        ArrayList<String> numberList = new ArrayList<String>();
//
//        while (scannerForFile.hasNextLine())
//            numberList.add(scannerForFile.nextLine());
//
//
//        for(int i = 0; i<numberList.size();i++){
//
//            if(numberList.get(i).contains("u")){ // unsigned calculations
//
//            }
//
//            else if(numberList.get(i).contains(".")){ // floating point calculations
//
//            }
//
//            else {  // signed calculations
//
//            }
//        }

        System.out.println(binaryToHex(signedToBinary(349),"b"));



    }

    public static String signedToBinary(int number) {
        String binaryValue = "";
        if (number > 0) {
            while (number != 0) {
                binaryValue += number % 2;
                number /= 2;
            }
            while (binaryValue.length() < 16) {
                binaryValue += 0;
            }
            binaryValue = reverseString(binaryValue);

        } else if (number < 0) {
            number *= -1;
            while (number != 0) {
                binaryValue += number % 2;
                number /= 2;
            }
            while (binaryValue.length() < 16) {
                binaryValue += 0;
            }
            binaryValue = reverseString(binaryValue);
            StringBuffer str = new StringBuffer(binaryValue);
            findTwoscomplement(str);
            return str.toString();
        } else {
            while (binaryValue.length() < 16) {
                binaryValue += 0;
            }
        }
        return binaryValue;
    }


    public static String findTwoscomplement(StringBuffer str) {
        int n = str.length();
        int i;
        for (i = n - 1; i >= 0; i--)
            if (str.charAt(i) == '1')
                break;
        if (i == -1)
            return "1" + str;
        for (int k = i - 1; k >= 0; k--) {

            if (str.charAt(k) == '1')
                str.replace(k, k + 1, "0");
            else
                str.replace(k, k + 1, "1");
        }
        return str.toString();
    }

    public static String reverseString(String str) {
        String reverseStr = "";
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            reverseStr = ch + reverseStr;
        }
        return reverseStr;
    }



    public static String binaryToHex(String binaryValue, String byteOrdering){
        int byteLength = 4;
        int bitStartPos = 0, bitPos = 0;
        String hexString = "";
        int sum = 0;

        if(binaryValue.length()%4 !=0){
            int tempCnt = 0;
            int tempBit = binaryValue.length() % 4;
            while(tempCnt < (byteLength - tempBit)){
                binaryValue = "0" + binaryValue;
                tempCnt++;
            }
        }

        while(bitStartPos < binaryValue.length()){
            while(bitPos < byteLength){
                sum = (int) (sum + Integer.parseInt("" + binaryValue.charAt(binaryValue.length()- bitStartPos -1)) * Math.pow(2, bitPos)) ;
                bitPos++;
                bitStartPos++;
            }
            if(sum < 10)
                hexString = Integer.toString(sum) + hexString;
            else
                hexString = (char) (sum + 55) + hexString;

            bitPos = 0;
            sum = 0;
        }
        if (byteOrdering.equals("l")){
            int mid = hexString.length() / 2;
            String[] parts = {hexString.substring(0, mid),hexString.substring(mid)};

            String lHexString = parts[1]+" "+parts[0];
            return lHexString;
        }
        int mid = hexString.length() / 2;
        String[] parts = {hexString.substring(0, mid),hexString.substring(mid)};

        String bHexString = parts[0]+" "+parts[1];
        return bHexString;
    }


}









