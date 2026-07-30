package com.patrick;

import com.patrick.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.print("Enter file path: ");
        String sourceFileStr = sc.nextLine();

        File sourceFile = new File(sourceFileStr);
        String sourceFolderStr = sourceFile.getParent();

        try {
            boolean outDirectoryCreated = new File(sourceFolderStr + "/out").mkdir();

            System.out.println(outDirectoryCreated ? "DIR Created" : "DIR Already Exist");
        } catch (SecurityException e) {
            System.out.println("Do not permission");
        }

        String targetFileStr = sourceFolderStr + "/out/summary.csv";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(sourceFileStr));
            BufferedWriter writer = new BufferedWriter(new FileWriter(targetFileStr))
        ) {
            String itemCsv = reader.readLine();

            while (itemCsv != null) {
                String[] fields = itemCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                list.add(new Product(name, price, quantity));
                itemCsv = reader.readLine();
            }

            for (Product item : list) {
                writer.write(item.getName() + "," + String.format("%.2f", item.total()));
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println(targetFileStr + " CREATED");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        sc.close();
    }
}
