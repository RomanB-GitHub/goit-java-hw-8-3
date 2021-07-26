package hashMap_Example;

public class TestMyHashMap {
    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        System.out.println(map);
        map.put(1, "Monitor");
        System.out.println(map);
        map.put(1, "Mouse");
        System.out.println(map);
        map.put(2, "KeyBoard");
        map.remove(1);
        System.out.println(map);

        for (int i = 0; i < 15; i++) {
            map.put(i, "Processor" + i);
        }

        System.out.println(map);
        System.out.println(map.size());
        System.out.println("Lets's get by key \"1\"" + map.get(1));
        System.out.println(map.size());
        System.out.println("Lets's get by key \"13\"" + map.get(13));
        System.out.println(map.size());
        System.out.println("Lets's get by key \"24\"" + map.get(24));
        System.out.println(map.size());
        System.out.println(map);
        System.out.println("Clearing operation");
        map.clear();
        System.out.println(map);


    }
}

