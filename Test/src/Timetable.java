import java.util.HashMap;
import java.util.Map;

public class Timetable {
    public HashMap<String, Train> trainsByName= new HashMap<>();

    public void printAll(){
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<String, Train> entry: trainsByName.entrySet()){
            sb.append("\n");
            sb.append(entry.getKey());
            Train train = entry.getValue();
            buildTrainDataByName(train, sb);
        }

        System.out.println(sb);
    }

    public void printDataByTrainName(String trainName){
        StringBuilder sb = new StringBuilder();
        Train train = trainsByName.get(trainName);

        sb.append(train.getName());
        buildTrainDataByName(train, sb);
        System.out.println(sb);
    }

    public void buildTrainDataByName(Train train, StringBuilder sb){
        sb.append(" (").append(train.getFirst().getBahnhof().getName()).append(" - ").append(train.getLast().getBahnhof().getName()).append(")");

        for(Stop s : train.getStopTreeSets()){
            int hour = s.getTime().getHour();
            int minutes = s.getTime().getMinute();
            String name = s.getBahnhof().getName();
            int peron = s.getPeron();
            sb.append("\n").append(hour).append(":").append(minutes).append(" ").append(name).append(" (").append(peron).append(")");
        }
    }
}