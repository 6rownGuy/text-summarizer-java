package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StringBuilder text = new StringBuilder();


        try {
            System.out.print("Enter file path: ");
            Scanner tScan = new Scanner (System.in);
            String path = tScan.nextLine();


            File file = new File(path);
            Scanner fScan = new Scanner(file);
            while (fScan.hasNextLine()) {
                text.append(fScan.nextLine());
            }
            TextProcessor c = new TextProcessor();
            c.display(text.toString());

         } catch (Exception e) {
            System.out.println("File not found.");
        }
    }
}
