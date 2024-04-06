import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ZoneId zoneId = ZoneId.of("UTC+1");
        TreeSet<Stop> TransalpinStops = getStopsTransalpin(zoneId);

        TreeSet<Stop> LernenAufRadern = getStopsLarenAufRadern(zoneId);

        Timetable timeTable = new Timetable();

        timeTable.trainsByName = new HashMap<String, Train>(){{
            put("Transalpin", new Train(TransalpinStops, "Transalpin"));
            put("Lernen auf Rädern", new Train(LernenAufRadern, "Lernen auf Rädern"));
        }};

        timeTable.printAll();
        timeTable.printDataByTrainName("Transalpin");
    }

    private static TreeSet<Stop> getStopsLarenAufRadern(ZoneId zoneId) {
        Stop stop4 = new Stop(12, ZonedDateTime.of(2024, 1, 1, 7, 10, 1, 1, zoneId),
                new Station("Salzburg"));
        Stop stop5 = new Stop(7, ZonedDateTime.of(2024, 1, 1, 8, 50, 1, 1, zoneId),
                new Station("Wien"));
        Stop stop6 = new Stop(11, ZonedDateTime.of(2024, 1, 1, 10, 10, 1, 1, zoneId),
                new Station("Wels"));

        TreeSet<Stop> LernenAufRadern = new TreeSet<>();
        LernenAufRadern.add(stop4);
        LernenAufRadern.add(stop5);
        LernenAufRadern.add(stop6);
        return LernenAufRadern;
    }

    private static TreeSet<Stop> getStopsTransalpin(ZoneId zoneId) {
        Stop stop = new Stop(8, ZonedDateTime.of(2024, 1, 1, 9, 10, 1, 1, zoneId),
                new Station("Wien"));
        Stop stop2 = new Stop(2, ZonedDateTime.of(2024, 1, 1, 10, 10, 1, 1, zoneId),
                new Station("St.Pölten"));
        Stop stop3 = new Stop(3, ZonedDateTime.of(2024, 1, 1, 12, 10, 1, 1, zoneId),
                new Station("Salzburg"));
        TreeSet<Stop> TransalpinStops = new TreeSet<>();
        TransalpinStops.add(stop);
        TransalpinStops.add(stop2);
        TransalpinStops.add(stop3);
        return TransalpinStops;
    }
}