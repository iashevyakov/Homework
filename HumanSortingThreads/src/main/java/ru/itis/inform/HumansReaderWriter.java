package ru.itis.inform;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HumansReaderWriter  {

    public void change(String s) throws FileNotFoundException

    {readHumans(s);}

    public LinkedList<Human> readHumans(String file)
            throws FileNotFoundException {

        Scanner sc = new Scanner(new File("C:\\Users\\Иван\\Desktop\\JavaProjects\\HumanSortingThreads\\src\\main\\resources\\"+file+".txt"));

        LinkedList<Human> humanLinkedList = new LinkedList<Human>();

        Human human;

        while (sc.hasNext()) {

            int age = sc.nextInt();
            String name = sc.nextLine();

            human = new Human(age, name);

            humanLinkedList.add(human);
        }
        sc.close();
        return humanLinkedList;

    }

    public void writeHumans(String file, LinkedList<Human> humanLinkedList) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("C:\\Users\\Иван\\Desktop\\JavaProjects\\HumanSortingThreads\\src\\main\\resources\\"+file+".txt"));

        Iterator<Human> iterator = humanLinkedList.iterator();

        while (iterator.hasNext()) {
            pw.println(iterator.peakNext().toString()+" ");
            iterator.next();
        }



        pw.close();

    }


}