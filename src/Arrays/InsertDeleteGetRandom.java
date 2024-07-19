package Arrays;

import java.util.*;

public class InsertDeleteGetRandom {
    Map<Integer, Integer> map;
    List<Integer> list;
    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            map.put(val, 1);
            list.add(val);
            return true;
        }
        map.put(val, map.get(val)+1);
        list.add(val);
        return false;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        else {
            map.put(val, map.get(val)-1);
            if(map.get(val) == 0) {
                map.remove(val);
            }
            int idx = list.indexOf(val);
            int last = list.get(list.size()-1);
            list.set(idx, last);
            list.remove(list.size()-1);
            return true;
        }
    }

    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom obj = new InsertDeleteGetRandom();
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.insert(3));
        System.out.println(obj.insert(4));
        System.out.println(obj.insert(5));
        System.out.println(obj.insert(6));
        System.out.println(obj.insert(7));
        System.out.println(obj.insert(8));
        System.out.println(obj.insert(9));
        System.out.println(obj.insert(10));
        System.out.println(obj.remove(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.remove(3));
        System.out.println(obj.remove(4));
        System.out.println(obj.remove(5));
        System.out.println(obj.remove(6));
        System.out.println(obj.remove(7));
        System.out.println(obj.remove(8));
        System.out.println(obj.remove(9));
        System.out.println(obj.remove(10));
        System.out.println(obj.getRandom());
    }
}
