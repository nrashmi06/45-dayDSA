package Arrays;

import java.util.*;
//gfg
public class AllUniquePermutation {
    public static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Collections.sort(arr);
        recursion(arr, 0, list, set);
        Collections.sort(list, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (a.get(i) < b.get(i)) return -1;
                if (a.get(i) > b.get(i)) return 1;
            }
            return 0;
        });
        return list;
    }

    static void recursion(ArrayList<Integer> arr, int index, ArrayList<ArrayList<Integer>> list, Set<List<Integer>> set) {
        if (index == arr.size()) {
            if (!set.contains(arr)) {
                list.add(new ArrayList<>(arr));
                set.add(new ArrayList<>(arr));
            }
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            Collections.swap(arr, i, index);
            recursion(arr, index + 1, list, set);
            Collections.swap(arr, i, index);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(1);
        int n = arr.size();
        ArrayList<ArrayList<Integer>> res = uniquePerms(arr, n);
        for (ArrayList<Integer> a : res) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
