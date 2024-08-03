package fit5171.monash.edu;

import java.util.Scanner;

public class ScannerWrapper {
    private Scanner scanner;

    public ScannerWrapper(Scanner scanner) {
        this.scanner = scanner;
    }

    public int nextInt() {
        return scanner.nextInt();
    }

    public String nextLine(){return scanner.nextLine();}


    // Add more wrapper methods as needed
}
