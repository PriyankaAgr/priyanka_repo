import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Coding2 {

    public static void main(String[] args) {
        String[] votes = {"john", "johnny", "jackie", "johnny", "john", "jamie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john"};
      //  String[] votes = {"john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny", "jamie", "johnny", "john"};
       Map<String, Long> map =  Arrays.stream(votes).collect(Collectors.groupingBy(k->k, Collectors.counting()));
      /* String res = map.entrySet().stream()
                .sorted((e1,e2)->{
                    int valComparison = Long.compare(e2.getValue(),e1.getValue());
                    if(valComparison !=0)
                        return valComparison;
                    else return e1.getKey().compareTo(e2.getKey());
                        }).map(Map.Entry::getKey).findFirst().orElse(null);*/

        String res = map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .findFirst()
                .get();


        System.out.println(res);
    }
}
