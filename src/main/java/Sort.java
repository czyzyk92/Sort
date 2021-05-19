import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        input.close();
        List<Integer> list = getListFromString(inputString);

        List<Integer> sortedDistinctList = getSortedDistinct(list);
        sortedDistinctList.forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("count: " + list.size());
        System.out.println("distinct: " + sortedDistinctList.size());
        System.out.println("min: " + sortedDistinctList.get(0));
        System.out.println("max: " + sortedDistinctList.get(sortedDistinctList.size() - 1));
    }

    static List<Integer> getListFromString(String stringOfNumbers) {
        List<Integer> list = null;
        try {
            list = Stream.of(stringOfNumbers.split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("The value entered must be a number");
        }
        return list;
    }

    static List<Integer> getSortedDistinct(List<Integer> list) {
        return list.stream().
                distinct().sorted()
                .collect(Collectors.toList());
    }
}
