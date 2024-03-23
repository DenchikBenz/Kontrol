package Inf304.work;

public class BroadcastsTime implements Comparable<BroadcastsTime> {
    private byte hour;
    private byte minutes;
    public BroadcastsTime(byte hour, byte minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public byte getHour() {
        return hour;
    }

    public byte getMinutes() {
        return minutes;
    }

    public boolean after(BroadcastsTime t) {
        return this.compareTo(t) > 0;
    }
    public boolean before(BroadcastsTime t) {
        return this.compareTo(t) < 0;
    }

    public boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        return this.after(t1) && this.before(t2);
    }
    @Override
    public int compareTo(BroadcastsTime t) {
        if (this.hour != t.hour) {
            return this.hour - t.hour;
        } else {
            return this.minutes - t.minutes;
        }
    }

}
