import java.util.SortedSet;
import java.util.TreeSet;

public class Train {
    private final TreeSet<Stop> stopTreeSets;

    private final String name;

    public Train(TreeSet<Stop> stopTreeSets, String name) {
        this.stopTreeSets = stopTreeSets;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Stop getFirst() {
        return stopTreeSets.first();
    }

    public Stop getLast() {
        return stopTreeSets.last();
    }

    public TreeSet<Stop> getStopTreeSets() {
        return stopTreeSets;
    }

    public int getNumOfStationsAfterGivenStation(String name) throws Exception {
        Stop beginningStop = stopTreeSets.stream().filter(x -> x.getBahnhof().getName().equals(name)).findFirst().orElse(null);
        Stop end = stopTreeSets.last();

        if(beginningStop == null) throw new Exception("No stop with name " +name);

        SortedSet<Stop> subSet = stopTreeSets.subSet(beginningStop, end);
        if(subSet.isEmpty()) throw new Exception("Sub set is null");

        return subSet.size();
    }
}