

package ru.itis.inform;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


    public class LexReaderWriter {

        public LinkedList<String> readHumans() throws FileNotFoundException {

            Scanner sc = new Scanner(new File("C:\\Users\\Иван\\Desktop\\Projects\\LexSort\\src\\main\\resources\\Words.txt"));

            LinkedList<String> linkedText = new LinkedList<String>();

            String name = sc.nextLine();
            String names[] = name.split("\\ ");

            for (String i : names) {
                linkedText.add(i);
            }
            sc.close();
            return linkedText;
        }

        public void writeHumans(String fileName, LinkedList<String> linkedText) throws FileNotFoundException {
            PrintWriter pw = new PrintWriter(new File("C:\\Users\\Иван\\Desktop\\Projects\\LexSort\\src\\main\\resources\\"+fileName+".txt"));

            Iterator<String> iterator = linkedText.iterator();

            while (iterator.hasNext()) {
                pw.println(iterator.peakNext()+" ");
                iterator.next();
            }
            pw.close();
        }
    }

