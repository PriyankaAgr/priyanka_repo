import java.util.*;
import java.util.stream.Collectors;

/**
 * Get the Longest String with java 8 - Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");
 */

public class Java8Test {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

        String longestString = list.stream().max(Comparator.comparingInt(String::length)).get();

        System.out.println(longestString);
        Set<String> hashSet = new HashSet<>(List.of("a", "b", "c"));
        Set<String> treeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        treeSet.addAll(List.of("A", "B", "C"));
        System.out.println(hashSet.equals(treeSet));
        System.out.println(treeSet.equals(hashSet));

    }
}

