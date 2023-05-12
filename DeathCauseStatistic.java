import java.nio.file.Path;
import java.security.Key;
import java.util.List;
import java.util.Objects;

public class DeathCauseStatistic {
    private String deathCode;
    public int[] deathCounter= new int[20];

    public String getDeathCode() {
        return deathCode;
    }

    public static DeathCauseStatistic fromCsvFile(String line){
        String[] args = line.split(",");
        DeathCauseStatistic output = new DeathCauseStatistic();
        for(int i = 0; i<20;i++){
            if(args[i+2].equals("-")){
                output.deathCounter[i]=0;
            }

            else {
                output.deathCounter[i]= Integer.parseInt(args[i + 2]);
            }
        }
        return output;
    }
    public AgeBracketDeaths getAgeBracketDeaths(int age){
        if(age>95){
            age = 95;
        }
        int start=age/5*5 ;
        int end =(age/5*5)+4;
        int index = age/5;
        AgeBracketDeaths ageBracketDeaths = new AgeBracketDeaths(start,end,deathCounter[index]);
        return ageBracketDeaths;
    }
    public class AgeBracketDeaths{
        public final int young;
        public final int old;
        public final int deathCount;

        public AgeBracketDeaths(int young, int old, int deathCount) {
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;
        }
    }
}
