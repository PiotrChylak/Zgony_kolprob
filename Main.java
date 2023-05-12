import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
//        DeathCauseStatistic test = DeathCauseStatistic.fromCsvFile("A02.1          ,5,-,-,-,-,-,-,-,-,-,-,-,-,1,2,-,1,1,-,-,-");
//        System.out.println(test.getDeathCode()+" nie ma tabulacji");
        DeathCauseStatisticList testList = new DeathCauseStatisticList();
        try {
            testList.repopulate("data/zgony.csv" );
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int i =0;i<testList.mostDeadlyDiseases(36, 10).size();i++){
            System.out.println(testList.mostDeadlyDiseases(36,10).get(i).getDeathCode());
        }
    }
}
