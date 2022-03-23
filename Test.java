import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scannerForReadingData = new Scanner(System.in);
        System.out.println("Enter the input file name!!");
        String inputFileName = scannerForReadingData.nextLine();

        while(true) {
            System.out.println("Enter the byte ordering (l or b)!!");
            String byteOrdering = scannerForReadingData.nextLine();
            if(byteOrdering.equals("l") || byteOrdering.equals("b"))
                break;
        }

        while (true){
            System.out.println("Enter the size of the data type (1,2,3,4)!!");
            int dataSize = scannerForReadingData.nextInt();
            if(dataSize == 1 || dataSize == 2 || dataSize == 3 || dataSize == 4)
                break;
        }

        File file = new File(System.getProperty("user.dir")+"\\"+inputFileName);
        Scanner scannerForFile = new Scanner(file);


        while (scannerForFile.hasNextLine())
            System.out.println(scannerForFile.nextLine());
    }
}
