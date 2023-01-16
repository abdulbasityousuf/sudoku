import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCombinations {

    public static void findCombinations(List<String> input, List<List<String>> result, List<String> accumulator) {
        for (int i = 0; i < input.size(); i++) {
            List<String> inputClone = new ArrayList<>();
            inputClone.addAll(input);
            String removedString = inputClone.remove(i);
            List<String> accumulatorClone = new ArrayList<>();
            accumulatorClone.addAll(accumulator);
            accumulatorClone.add(removedString);
            findCombinations(inputClone, result, accumulatorClone);
        }

        if (input.size() == 0) {
            result.add(accumulator);
        }

    }

    public static void main(String[] args) {

        List<List<String>> result = new ArrayList<>();
        findCombinations(Arrays.asList("1", "2", "3"), result, new ArrayList<>());
        System.out.println(result);
    }
}
