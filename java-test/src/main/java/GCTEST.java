import java.util.ArrayList;
import java.util.List;

public class GCTEST {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int i=0;
        try {
            while (true) {
                System.out.println("Adding integer in List");
                list.add(i++);

            }
        }
        catch (OutOfMemoryError error){
            System.out.println("Out of memory error detected");
        }
    }
}

//4GB