import java.time.ZonedDateTime;

public class Stop implements Comparable<Stop>{
    private final int peron;
    private final ZonedDateTime time;
    private final Station bahnhof;

    public Stop(int peron, ZonedDateTime time, Station bahnhof) {
        this.peron = peron;
        this.time = time;
        this.bahnhof = bahnhof;
    }

    public int getPeron() {
        return peron;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public Station getBahnhof() {
        return bahnhof;
    }

    @Override
    public int compareTo(Stop o) {
        return this.time.compareTo(o.time);
    }
}
