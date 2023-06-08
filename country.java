import java.util.ArrayList;
import java.util.List;

public class country {
    List<String> opponents = new ArrayList<String>();

    public String contSelect;
    public double armySize = 0;
    public double navySize = 0;
    public double population = 0;
    public double economy = 0;
    List<String> borders = new ArrayList<String>();
    public double getArmySize(){
        return armySize;
    }
    public double getNavySize(){
        return navySize;
    }

    public double getPopulation() {
        return population;
    }

    public double getEconomy() {
        return economy;
    }

    public List<String> getBorders() {
        return borders;
    }
    public void GermanySelect(){
        armySize = 2;
        navySize = 194;
        population = 60;
        economy = 55;
        borders.add("France");
        borders.add("Russia");
        borders.add("UK");
        borders.add("Italy");
    }
    public void FranceSelect(){
        armySize = 3;
        navySize = 564;
        population = 40;
        economy = 50;
        borders.add("UK");
        borders.add("USA");
        borders.add("Germany");
    }
    public void USASelect(){
        armySize = 1;
        navySize = 117;
        population = 103;
        economy = 80;
        borders.add("UK");
        borders.add("Italy");
        borders.add("France");
        borders.add("Germany");
    }
    public void UKSelect(){
        armySize = 1;
        navySize = 986;
        population = 40;
        economy = 55;
        borders.add("France");
        borders.add("USA");
        borders.add("Germany");
    }
    public void USSRSElect(){
        armySize = 5;
        navySize = 134;
        population = 193;
        economy = 35;
        borders.add("Germany");
        borders.add("Japan");

    }
    public void changeArmySize(double uLoss){
        armySize = armySize - uLoss;
    }
    public void changeNavySize(double uLoss){
        navySize = navySize - uLoss;
    }
    public void conscript(){
        armySize = population * 0.1;
        population = population * 0.9;
    }

}
