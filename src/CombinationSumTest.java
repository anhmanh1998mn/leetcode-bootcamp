import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTest {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 8;
        Solution solution = new Solution();
        List<List<Integer>> results = solution.combinationSum(candidates, target);
        results.forEach(x -> {
            System.out.printf(x + "\n");
        });
    }

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> results = new ArrayList<>();

            findCombinations(0, candidates, target, results, new ArrayList<>());
            return results;
        }

        public void findCombinations(int index, int[] candidates, int target, List<List<Integer>> results, List<Integer> list) {
            if (index == candidates.length) {
                if (target == 0) {
                    results.add(new ArrayList<>(list));
                }
                return;
            }

            if (candidates[index] <= target) {
                list.add(candidates[index]);
                findCombinations(index, candidates, target - candidates[index], results, list);
                list.remove(list.size() - 1);
            }
            findCombinations(index + 1, candidates, target, results, list);
        }
    }

}
