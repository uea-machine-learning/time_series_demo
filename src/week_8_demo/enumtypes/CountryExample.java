package week_8_demo.enumtypes;

import java.text.DecimalFormat;

public class CountryExample {
    public enum Country{UK(68016177,2855),FRANCE(65325997,2752),
        GERMANY(83881435,3948),ITALY(60429692,2084);
        private double population;
        private double gdp; //In billions
        private static double globalPopulation=7824443830.0;
        private static double globalGDP=80934;

        Country(double p, double g){
            population=p;
            gdp=g;
        }
        public double gdpPerPerson(){
            return (1000000000*gdp)/population;
        }
        public double proportionOfTheWorldPop(){
            return population/globalPopulation;
        }
        public double proportionOfTheWorldGDP(){
            return gdp/globalGDP;
        }
    }

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("##.##");
        Country myCountry=Country.UK;
        Country otherCountry=Country.FRANCE;
        System.out.println(myCountry+" has GDP per head = $"+df.format(myCountry.gdpPerPerson()));
        System.out.println(myCountry+" has = "+df.format(100*myCountry.proportionOfTheWorldPop())+"% of the world population");
        System.out.println(myCountry+" has = "+df.format(100*myCountry.proportionOfTheWorldGDP())+"% of the world GDP");
    }
    public static boolean biggestCountry(Country a){
        if(a==Country.GERMANY)//Current biggest in the list
            return true;
        return false;
    }

/*
	static public abstract class Country{
		private long population;
		private double gdp;//in millions
		public double gdpPerPerson(){return (1000000*gdp)/population;}
		private Country(long p, double g){
			population=p;
			gdp=g;
		}
		public static final Country UK=new Country(68016177,2855){};
		public static final Country FRANCE=new Country(65325997,2752){};
		public static final Country GERMANY=new Country(83881435,3948){};
		public static final Country ITALY=new Country(60429692,2084){};
	}
*/


}
