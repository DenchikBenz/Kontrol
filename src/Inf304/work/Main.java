package Inf304.work;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {
         Map<String, List<Program>> channelsAndPrograms = new HashMap<>();
         List<Program> allPrograms = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("schedule.txt"))) {
            String line;
            String channel = "";
            BroadcastsTime time = null;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")) {
                    channel = line.substring(1);
                } else {
                    if (time == null) {
                        String[] timeParts = line.split(":");
                        time = new BroadcastsTime(Byte.parseByte(timeParts[0]), Byte.parseByte(timeParts[1]));
                    } else {
                        String name = line;
                        Program program = new Program(channel, time, name);
                        allPrograms.add(program);
                        channelsAndPrograms.computeIfAbsent(channel, k -> new ArrayList<>()).add(program);
                        time = null;
                    }
                }
            }
            System.out.println(channelsAndPrograms.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}