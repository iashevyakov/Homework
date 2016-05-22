package ru.itis.inform;
import java.io.FileNotFoundException;

public class HumanThreads implements Runnable {
     String fileIn = "";

     String fileOut = "";

     HumansReaderWriter humansReaderWriter = new HumansReaderWriter();

     LinkedList<Human> humans = new LinkedList<Human>();

     HumansSorter humansSorter = new HumansSorter();

    public HumanThreads(String fileName, String outFileName) {
        this.fileIn = fileName;
        this.fileOut = outFileName;
    }

    @Override
    public void run() {
        try {
            this.humans = humansReaderWriter.readHumans(this.fileIn);
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        }


        humans = humansSorter.sort(humans);

        try {
            humansReaderWriter.writeHumans(this.fileOut, this.humans);
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        }
    }
}
