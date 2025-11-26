package algoritham;
import java.util.ArrayList;
import java.util.List;

public class IncreasingSubsequences {
    public static List<List<Integer>> findIncreasing(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (current.isEmpty() || arr[i] > current.get(current.size() - 1)) {
                current.add(arr[i]);
            } else {
                if (current.size() > 1)
                    result.add(new ArrayList<>(current));
                current.clear();
                current.add(arr[i]);
            }
        }

        if (current.size() > 1)
            result.add(current);

        return result;
    }
    
}
