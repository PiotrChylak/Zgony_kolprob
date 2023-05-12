import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DeathCauseStatisticList {
    List<DeathCauseStatistic> deathList = new ArrayList<>();
    public void repopulate(String path) throws FileNotFoundException {
        deathList= new ArrayList<>();
        File file = new File(path);
        if(file.exists()){
            Scanner scanner = new Scanner(file);
            scanner.nextLine(); //header
            scanner.nextLine(); //summed data
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                deathList.add(DeathCauseStatistic.fromCsvFile(line));
            }

        }
    }
    public List<DeathCauseStatistic> mostDeadlyDiseases(int age, int n){
        List<DeathCauseStatistic> result = new ArrayList<>(deathList);
            result.stream().sorted((p1,p2) -> {
                int a = p1.getAgeBracketDeaths(age).deathCount;
                int b = p2.getAgeBracketDeaths(age).deathCount;
                if(a==b){
                    return 0;
                }
                else if(a>b){
                    return -1;
                }
                else{
                    return 1;
                }
            }).collect(Collectors.toList());
            return result;

    }
}
