package week_11_demo.collections;

import java.text.DecimalFormat;
import java.util.*;

public class CollectionsTest {
    /**
     *
     * @param cars input Cars collection
     * @param uniqueMakes output collection containing car makes once only.
     */
    public static void findAllUniqueMakes(Collection<Car> cars, Collection<String> uniqueMakes){
        for(Car c:cars){
            String str=c.getMake();
            if(!uniqueMakes.contains(str))
                uniqueMakes.add(str);
        }
    }

    public static long timeUniqueMakes(int numberOfCars,Collection<String> uniqueMakes){
//Create a randomised array of cars size numberOfCars
        ArrayList<Car> testy=Car.createRandomCars(numberOfCars);
//Record start time
        long time=System.nanoTime();
//Perform the selection
        findAllUniqueMakes(testy,uniqueMakes);
        time=System.nanoTime()-time;
        return time;
    }
    public static void timingExperiment(){
        DecimalFormat df = new DecimalFormat(".###");
        System.out.println("n, ArrayList,LinkedList,HashSet,TreeSet");

        for(int n=1000000;n<100000000;n+=1000000){
            ArrayList<Collection<String>> ds=new ArrayList<>();
            Collection<String> ar=new ArrayList<>();
            ds.add(ar);
            Collection<String> ll=new LinkedList<>();
            ds.add(ll);
            Collection<String> hs=new TreeSet<>();
            ds.add(hs);
            Collection<String> ts=new HashSet<>();
            ds.add(ts);
            long[] times=new long[ds.size()];
            System.out.print(n);
            for(int i=0;i<times.length;i++) {
                times[i] = timeUniqueMakes(n, ds.get(i));
                System.out.print("\t," + df.format(times[i]/1000000.0));
            }
            System.out.print("\n");

        }


    }
    public static class MyEntry {
        String key;
        int value;
        public MyEntry(String k, int v){
            key=k;
            value=v;
        }
        public boolean equals(Object o){
            MyEntry p = (MyEntry)o;
            if(key.equals(p.key)) return true;
            return false;
        }


    }

    public static class Pair<K extends Comparable<K>,V extends Number> implements Comparable<Pair<K,V>>{
        K key;
        V value;
        Pair(K k, V v){
            key=k;
            value =v;
        }
        public V getValue(){ return value;}
        public void setValue(V v){ value=v;}
        @Override
        public boolean equals(Object o){
            Pair<K,V> p = (Pair<K,V>)o;
            if(key.equals(p.key)) return true;
            return false;
        }
        @Override
        public int compareTo(Pair<K, V> o) {
            return key.compareTo(o.key);
        }
    }
    public static void myListProcessor(List<String> myList){
        myList.set(0,"foo");
        String str=myList.get(2);
        myList.add("bar");
        myList.add(2,"foo");



    }

    public static void usingSetsBasic() {
        double[] x = new double[100];
        List<String> myList = new ArrayList<>();

        myList.add("Bob");
        myList.add("Bob");
        myList.add("Alice");
        myList.add("Fred");
        myList.set(3,"Kate");
        String str3=myList.get(3);
        System.out.println(" pos 3 = "+str3);
        Set<String> myHashSet=new HashSet<>(myList);
        Set<String> myTreeSet=new TreeSet<>(myList);
        System.out.println("Hash Set");
        for(String str:myHashSet)
            System.out.println(str);
        System.out.println("Tree Set");
        for(String str:myTreeSet)
            System.out.println(str);
        if(myHashSet.equals(myTreeSet))
            System.out.println(" They are logically equal");
        myHashSet.add("Tony");
        myHashSet.add("Tony");
        myHashSet.add("Tony");
        myHashSet.add("Tony");
        myHashSet.add("Tony");
        myHashSet.add("Tony");
        myHashSet.add("Tony");
        myHashSet.add("Tony");
        System.out.println(myHashSet);
    }


    static ArrayList<String> getWords(){
        ArrayList<String> words= new ArrayList<>();
//Get the words from somewhere
        words.add("FOO");
        words.add("FOO");
        words.add("FOO");
        words.add("FOO");
        words.add("FOO");
        words.add("BAR");
        words.add("BAR");
        words.add("BAR");
        words.add("ARSENAL");
        return words;
    }


    public static void usingMapsBasic() {
        //List vs Set vs Map
        List rawArray = new ArrayList();
        rawArray.add(77);
        rawArray.add("mixy");
        rawArray.add(new int[]{1,2,3,4});

        Set rawSet = new HashSet();
        rawSet.add(77);
        rawSet.add("mixy");
        rawSet.add(new int[]{1,2,3,4});


        Map rawMap = new HashMap();
        rawMap.put("key1",77);
        rawMap.put("key2","mixy");
        rawMap.put(33,new int[]{1,2,3,4});
/*
        System.out.println(" Value with key1 ="+ rawMap.get("key1"));
        System.out.println(" Value with foo ="+rawMap.get(33));
        System.out.println(rawMap.get(33));
        if(rawSet.contains(rawArray.get(0)))
            System.out.println(" Element 0 in array is in the set");
        if(rawArray.get(0).equals(rawMap.get("key1")))
            System.out.println(" Element 0 in array equal to element with key1 in map");


        System.exit(0);
//MAPS ARE NOT ITERABLE
*/

        Map<String,Integer> dictionary=new HashMap<>();
        ArrayList<String> words= getWords();
        for(String str: words){
            if(dictionary.containsKey(str)) {
                Integer count = dictionary.get(str);
                dictionary.put(str,count+1);
            }
            else
                dictionary.put(str,1);
        }
        for ( String key : dictionary.keySet() )
            System.out.println(" KEY = "+key);


        for ( Integer value : dictionary.values() )
            System.out.println(" Value = "+value);
        Set<Map.Entry<String, Integer>> entries = dictionary.entrySet();

        for ( Map.Entry<String, Integer> entry : entries )
            System.out.println("VALUE = "+entry.getValue()+" KEY = "+entry.getKey());
        System.exit(0);


        Map<MyEntry, MyEntry> myDict=new HashMap<>();
        MyEntry temp=new MyEntry("",1);
        for(String str: words) {
            temp.key=str;
            MyEntry ent=myDict.get(temp);
            if(ent!=null)
                ent.value++;
            else{
                MyEntry newEntry=new MyEntry(str,1);
                myDict.put(newEntry,newEntry);
            }
        }
        Set<MyEntry> all=myDict.keySet();
        for(MyEntry e:all)
            System.out.println("VALUE = "+e.value+" KEY = "+e.key);
        //List the key set
        Set<String> keys=dictionary.keySet();
        for(String str: keys)
            System.out.println("KEYS = "+str);
        //List the values
        Collection<Integer> vals=dictionary.values();
        System.out.println(" class is "+vals.getClass().getSuperclass().getSimpleName());
        for(Integer str: vals)
            System.out.println("VALUES = "+str);
        //List the Entry set
        Set<Map.Entry<String,Integer>> entrySet=dictionary.entrySet();
        for(Map.Entry e:entrySet)
            System.out.println("Entry = "+e);
        class Student{
            String name;
            int score;
        }
        HashMap<Integer,Student> hm=
                new HashMap<Integer,Student>();
        TreeMap<Integer,Student> tm = new TreeMap<Integer,Student>();


    }

    public static void main(String[] args) {
        usingMapsBasic();
        System.exit(0);

        ArrayList<Car> allCars=Car.createCars();
        Car myCar = allCars.get(0);
        Car otherCar = new Car();
        otherCar.make = myCar.make;
        otherCar.doors = myCar.doors;

        if(myCar==otherCar)
            System.out.println(" The same");
        else
            System.out.println(" Different");

        if(myCar.equals(otherCar))
            System.out.println(" The same");
        System.out.println(" Hash Code = "+otherCar.hashCode());
        System.out.println(" Hash Code = "+myCar.hashCode());
        HashSet<Car> myCars=new HashSet<>();
        myCars.add(myCar);
        myCars.add(otherCar);
        System.out.println(myCars);



        System.exit(0);
        System.out.println("************ Using ArrayList **********");
        System.out.println("Array list of Cars = "+allCars);
        Collection<String> carMakes=new ArrayList<>();
        System.out.println("Unique makes");
        findAllUniqueMakes(allCars,carMakes);
        for(String str:carMakes)
            System.out.println(str);
        System.out.println("************ Using LinkedList **********");
        carMakes=new LinkedList<>();
        findAllUniqueMakes(allCars,carMakes);
        for(String str:carMakes)
            System.out.println(str);
        System.out.println("************ Using HashSet **********");
        carMakes=new HashSet<>();
        findAllUniqueMakes(allCars,carMakes);
        for(String str:carMakes)
            System.out.println(str);
        System.out.println("************ Using TreeSet **********");
        carMakes=new TreeSet<>();
        findAllUniqueMakes(allCars,carMakes);
        for(String str:carMakes)
            System.out.println(str);

        usingMapsBasic();

    }


}
