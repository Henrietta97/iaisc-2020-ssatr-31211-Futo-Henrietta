import simulator.Simulator;
import utililities.JSONLoader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        int step = 15;

        JSONLoader jsonLoader = new JSONLoader();

        if (jsonLoader.loadJson("src/files/input.json")) {
            System.out.println("JSON loaded");
            try {
                FileWriter fileWriter = new FileWriter("src/files/output.txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                Simulator simulator = new Simulator();
                simulator.setSteps(step);
                simulator.simulatePetriNet(printWriter);
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("JSON couldn't be loaded!");
        }

    }
}
