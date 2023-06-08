// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
import java.util.Scanner;
import java.util.Collections;
public class Main {
    static boolean warStat = false;
    public static String contSelect;
    public int armySize = 0;
    public int navySize = 0;
    public int population = 0;
    public int economy = 0;
    static Scanner choiceSelect = new Scanner(System.in);
    public static void RhinelandOpp(country yourCountry){
        System.out.println("Germany Occupies the Rhineland!");
        System.out.println("[1] Support Germany");
        System.out.println("[2] Remain Neutral");
        System.out.println("[3] Support France");
        String Rchoice =  choiceSelect.next();
        if (contSelect.equals("Germany"))
        {

            int v = (int)(Math.random()  + 2);
            if (v == 2)
            {
                warStat = true;
                yourCountry.opponents.add("UK");
                yourCountry.opponents.add("France");
                yourCountry.opponents.add("USSR");
                yourCountry.opponents.add("USA");
                System.out.println("New objective: survive");
            }

        }
        else if (Rchoice.equals("3"))
        {
            yourCountry.opponents.add("Germany");
            System.out.println("You are at war with Germany!");
            warStat= true;
        }
        else if(Rchoice.equals("2")){
            System.out.println("You remain neutral.");
        }

    }
    public static void SCWar(country yourCountry){
        System.out.println("The Spanish Civil War has broken out!");
        System.out.println("[1] Support the Monarchists");
        System.out.println("[2] Remain Neutral");
        System.out.println("[3] Support the Republicans");
        String Rchoice =  choiceSelect.next();
        if (contSelect.equals("Germany") && Rchoice.equals("1"))
        {
            yourCountry.opponents.add("France");
            yourCountry.opponents.add("UK");
            warStat = true;
            System.out.println("You are at war with France and the UK!");
        }
        else if(Rchoice.equals("3")){
            yourCountry.opponents.add("Germany");
            warStat = true;
            System.out.println("You are at war with Germany!");
        }
        else{
            System.out.println("");
        }

    }
    public static void PolandWarStart(country yourCountry){
        System.out.println("Germany invades Poland.  The War has begun.");
        if (!warStat){
            if(yourCountry.equals("Germany")){
                yourCountry.opponents.add("France");
                yourCountry.opponents.add("USSR");
                yourCountry.opponents.add("UK");
                yourCountry.opponents.add("US");
                warStat = true;

            }
            else{
                yourCountry.opponents.add("Germany");
                warStat = !warStat;
            }
        }
    }
    public static void Attack(country yourCountry, country oppCountry){
        if (yourCountry.getArmySize() > oppCountry.getArmySize()){
            double ubonus = Math.random() * 10 + 5;
            if(ubonus > 10){
                double uLoss = Math.random();
                double tLoss = Math.random() + 0.5;
                yourCountry.changeArmySize(uLoss);
                oppCountry.changeArmySize(tLoss);
            }
            if (ubonus <= 10){
                double uLoss = Math.random() + 0.5;
                double tLoss = Math.random();
                yourCountry.changeArmySize(uLoss);
                oppCountry.changeArmySize(tLoss);
            }
        }
        if (yourCountry.getArmySize() < oppCountry.getArmySize()){
            double ubonus = Math.random() * 10 - 5;
            if(ubonus > 10){
                double uLoss = Math.random();
                double tLoss = Math.random() + 0.5;
                yourCountry.changeArmySize(uLoss);
                oppCountry.changeArmySize(tLoss);
            }
            if (ubonus <= 10){
                double uLoss = Math.random() + 0.5;
                double tLoss = Math.random();
                yourCountry.changeArmySize(uLoss);
                oppCountry.changeArmySize(tLoss);
            }
        }
        if(oppCountry.getArmySize() <=0)
        {
            List<String> borders2 = new ArrayList<String>();

            yourCountry.population+= oppCountry.population;
            yourCountry.navySize+= oppCountry.navySize;
            yourCountry.economy += 0.5*(oppCountry.economy);
            for(int i = 0; i< oppCountry.borders.size();i++)
            {
                int count = 0;
                for(int j =0;j< yourCountry.borders.size(); j++)
                {
                    if((!(oppCountry.borders.get(i).equals(yourCountry.borders.get(j))))&& !(oppCountry.borders.get(i).equals(yourCountry)))
                    {
                        count++;
                    }

                }
                if(count == yourCountry.borders.size()){
                    borders2.add(oppCountry.borders.get(i));
                }
            }
            for(int i = 0; i< borders2.size();i++)
            {
                yourCountry.borders.add(borders2.get(i));
            }
        }
    }
    public static void navyAttack(country yourCountry, country oppCountry){
        if (yourCountry.getNavySize() > oppCountry.getNavySize()){
            double ubonus = Math.random() * 10 + 5;
            if(ubonus > 10){
                double uLoss = Math.random() * 10;
                double tLoss = Math.random()*10 + 15;
                yourCountry.changeNavySize(uLoss);
                oppCountry.changeNavySize(tLoss);
            }
            if (ubonus <= 10){
                double uLoss = Math.random()*10 + 15;
                double tLoss = Math.random()*10;
                yourCountry.changeNavySize(uLoss);
                oppCountry.changeNavySize(tLoss);
            }
        }
        if (yourCountry.getArmySize() < oppCountry.getArmySize()){
            double ubonus = Math.random() * 10 - 5;
            if(ubonus > 10){
                double uLoss = Math.random();
                double tLoss = Math.random() + 0.5;
                yourCountry.changeNavySize(uLoss);
                oppCountry.changeNavySize(tLoss);
            }
            if (ubonus <= 10){
                double uLoss = Math.random() + 0.5;
                double tLoss = Math.random();
                yourCountry.changeNavySize(uLoss);
                oppCountry.changeNavySize(tLoss);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("WAR AGAIN");
        System.out.println("Begin by choosing your country");
        Scanner countrySelect = new Scanner(System.in);
        contSelect = countrySelect.next();
        country yourCountry = new country();
        country USA = new country();
        country USSR = new country();
        country France = new country();
        country UK = new country();
        country Germany = new country();
        int year = 1933;
        if (contSelect.equals("Germany")) {
            yourCountry.GermanySelect();
            USSR.USSRSElect();
            USA.USASelect();
            France.FranceSelect();

        }
        else if (contSelect.equals("France")) {
            yourCountry.FranceSelect();
            Germany.GermanySelect();
            UK.UKSelect();
            USSR.USSRSElect();
            USA.USASelect();

        }
        else if (contSelect.equals("USA")){
            yourCountry.USASelect();
            Germany.GermanySelect();
            UK.UKSelect();
            USSR.USSRSElect();
            France.FranceSelect();
        }
        else if (contSelect.equals("USSR")){
            yourCountry.USSRSElect();
            UK.UKSelect();
            Germany.GermanySelect();
            USA.USASelect();
            France.FranceSelect();
        }
        else if (contSelect.equals("UK")){
            yourCountry.UKSelect();
            Germany.GermanySelect();
            USA.USASelect();
            France.FranceSelect();
            USSR.USSRSElect();
        }

        while(year < 1945){
            boolean nyear = false;
            boolean attack = false;
            if (year == 1933){
                RhinelandOpp(yourCountry);
            }
            if (year == 1936){
                SCWar(yourCountry);
            }
            if (year == 1939){
                PolandWarStart(yourCountry);
            }
            while(nyear == false){
                String action = choiceSelect.next();
                System.out.println(action);
                if(action.equals("stats"))
                {
                    System.out.println("Army size: " + yourCountry.getArmySize());
                    System.out.println("Navy Size: " + yourCountry.getNavySize());
                    System.out.println("Econ: " + yourCountry.getEconomy());
                    System.out.println("Pop: " + yourCountry.getPopulation());
                   ;
                }
                if(action.equals("borders")){
                    for(int i = 0; i<yourCountry.borders.size();i++) {
                        System.out.println(yourCountry.borders.get(i));
                    }
                }
                if(action.equals("conscription")){
                    yourCountry.conscript();
                }
                if(action.equals("nextyear")){
                    nyear = true;
                }
                if(action.equals("getyear")){
                    System.out.println(year);
                }
                if (action.equals("navyattack")){
                    System.out.println("Which Country");
                    String oppCountry = choiceSelect.next();

                    if(attack == false && !oppCountry.equals(yourCountry)){

                        if (oppCountry.equals("Germany")) {
                            navyAttack(yourCountry, Germany);

                        } else if (oppCountry.equals("France")) {
                            navyAttack(yourCountry, France);

                        } else if (oppCountry.equals("UK")) {
                            navyAttack(yourCountry, UK);

                        } else if (oppCountry.equals("USSR")) {
                            navyAttack(yourCountry, USSR);

                        } else if (oppCountry.equals("USA")) {
                            navyAttack(yourCountry, USA);
                        }

                }



                }
                if(action.equals("attack")){
                    System.out.println("Which Country?");
                    String aoppCountry = choiceSelect.next();
                    for(int j =0; j<yourCountry.opponents.size();j++) {
                        for (int i = 0; i < yourCountry.borders.size(); i++ ) {
                            if (aoppCountry.equals(yourCountry)) {
                                System.out.println("This is your country, cannot attack yourself");
                                j = yourCountry.opponents.size();
                            }
                            else if (yourCountry.borders.get(i).equals(aoppCountry)) {
                                if (aoppCountry.equals("Germany")) {
                                    Attack(yourCountry, Germany);

                                } else if (aoppCountry.equals("France")) {
                                    Attack(yourCountry, France);

                                } else if (aoppCountry.equals("UK")) {
                                    Attack(yourCountry, UK);

                                } else if (aoppCountry.equals("USSR")) {
                                    Attack(yourCountry, USSR);

                                } else if (aoppCountry.equals("USA")) {
                                    Attack(yourCountry, USA);
                                }
                                attack = true;
                            }


                        }
                        if(!attack){
                            System.out.println("This is not a border country");

                        }
                    }
                }



            }
            year++;
            int counter =0;
            for(int i = 0; i<yourCountry.opponents.size();i++)
            {
                if(yourCountry.opponents.get(i).equals("UK"))
                {
                    if(UK.armySize <=0)
                    {
                        counter++;
                    }
                }
                else if(yourCountry.opponents.get(i).equals("Germany"))
                {
                    if(USA.armySize <=0)
                    {
                        counter++;

                    }
                }
                else if(yourCountry.opponents.get(i).equals("France"))
                {
                    if(USSR.armySize <=0)
                    {
                        counter++;

                    }
                }
                else if(yourCountry.opponents.get(i).equals("USSR"))
                {
                    if(Germany.armySize <=0)
                    {
                        counter++;

                    }
                }
                else if(yourCountry.opponents.get(i).equals("USA"))
                {
                    if(France.armySize <=0)
                    {
                        counter++;

                    }
                }
            }
            if(counter ==yourCountry.opponents.size())
            {
                System.out.println("YOU WIN");
                break;
            }else if(yourCountry.armySize <=0 ){
                System.out.println("HOW DOES IT FEEL TO LOSE?");
                break;
            }


        }






        }
    }
