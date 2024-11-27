package collections;

import inheritance.*;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        int [] num = {4,9,7,10};

        Shape[] shapes = {new Circle(),new Triangle(),new Rectangle()};

        for (int j : num) {
            System.out.println(j);

        }

        for (Shape shape : shapes){
            shape.draw();
        }

        Shape [] myShapes = new Shape[10];
        //myShapes[0].draw();

        System.out.println(myShapes.length);

        ArrayList myList = new ArrayList<>();
        myList.add(new Shape());
        myList.add(new Student());

        Iterator iterator = myList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //myList.remove(10);

        ArrayList<Shape> shapesList = new ArrayList<>();
        shapesList.add(new Shape());
        shapesList.add(new Triangle());
        shapesList.add(new Circle());

        for (Shape shape : shapesList){
            shape.draw();
        }

        HashSet<String> hs = new HashSet<>();
        hs.add("Alex");
        hs.add("Alex");


        System.out.println(hs.size());

        HashMap<Integer,String> map1 = new HashMap<>();
        map1.put(1,"value 1");
        map1.put(2,"value 2");
        map1.put(1,"Elena");

        for (Integer k : map1.keySet()){
            System.out.println(map1.get(k
            ));
        }

        Queue<String> breadQueue = new PriorityQueue<>();
        breadQueue.add("Alex");
        breadQueue.add("Silvia");

        System.out.println(Browsers.FIREFOX);

        String text = "Ana are mere si pere si struguri. Toamna e frumos pentru ca nu e inca frig.";
        printCharFrequency(computeMapFromString(text,false));







    }

    public static HashMap<Character,Integer> computeMapFromString(String text, boolean caseSensitive){
        HashMap<Character,Integer> charMap = new HashMap<>();
        String finalText = caseSensitive? text : text.toLowerCase();

        for (Character s : finalText.toCharArray()){
            if (charMap.containsKey(s)){
                charMap.put(s,charMap.get(s) + 1);
            }
            else {
                charMap.put(s,1);
            }
        }

        return charMap;
    }

    public static void printCharFrequency(HashMap<Character,Integer> charMap){
        int sum = 0;
        for (Character c : charMap.keySet()){
            sum += charMap.get(c);
        }

        for (Character c : charMap.keySet()){
            System.out.println(c + " : " + charMap.get(c) * 100.0 / sum);
        }


        for (Character c : charMap.keySet()){
            System.out.println(c + " : " + charMap.get(c));
        }

        HashSet<String> names = new HashSet<>();
        names.add("Carina");
        names.add("Alex");
        names.add("Ioana");
        names.add("Sofia");

        for (String s : names){
            System.out.println(s);
        }


    }
}
