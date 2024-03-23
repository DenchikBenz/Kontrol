package Inf304.work;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
import java.time.LocalTime;

public class MethodsforMap {
    private Map<String, List<Program>> channelsAndPrograms = new HashMap<>();
    private List<Program> allPrograms = new ArrayList<>();
    public MethodsforMap(Map<String,List<Program>> mapa, List<Program> list){
        this.channelsAndPrograms = mapa;
        this.allPrograms = list;
    }
    public void showAllPrograms() {
        allPrograms.sort(Comparator.comparing(Program::getTime));
        for (Program program : allPrograms) {
            System.out.println(program.getChannel() + " " + program.getTime() + " " + program.getName());
        }
    }
    public void showProgramNow() {
        LocalTime currentTime =  LocalTime.now();
        for (Program program : allPrograms) {
            if (program.getTime().after(new BroadcastsTime((byte) currentTime.getHour(), (byte) currentTime.getMinute()))) {
                System.out.println("Сейчас идет: " + program.getChannel() + " " + program.getTime() + " " + program.getName());
                break;
            }
        }
    }
    public List<Program> searchName(String name) {
        List<Program> foundedPrograms = new ArrayList<>();
        for (Program program : allPrograms) {
            if (program.getName().equalsIgnoreCase(name)) {
                foundedPrograms.add(program);
            }
        }
        return foundedPrograms;
    }





}
