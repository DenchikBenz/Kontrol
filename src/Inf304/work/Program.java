package Inf304.work;

public class Program {
    private String channel;
    private BroadcastsTime time;
    private String name;

    public Program(String channel, BroadcastsTime time, String name) {
        this.channel = channel;
        this.time = time;
        this.name = name;
    }
    public String getChannel() {
        return channel;
    }

    public BroadcastsTime getTime() {
        return time;
    }

    public String getName() {
        return name;
    }
}
