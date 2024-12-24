    import jdk.jfr.SettingDefinition;
    import org.junit.Assert;
    import org.junit.Test;

    import java.util.*;

    /**
     * 7->9->3
     * 1->1->1
     * 904
     */


    public class AtlassianCodeTest {

        public static void main(String[] args) {

            LinkedList<Integer> list1 = new LinkedList<>();
            //list1.add(7);
            list1.add(9);
            list1.add(3);
            LinkedList<Integer> list2 = new LinkedList<>();

            list2.add(9);
            list2.add(1);
            list2.add(1);

            LinkedList<Integer> list3 = sumList(list1, list2);
            list3.forEach(v -> System.out.println(v));

        }

        public static LinkedList<Integer> sumList(LinkedList<Integer> list1, LinkedList<Integer> list2) {
            Iterator<Integer> itr1= list1.descendingIterator();
            Iterator<Integer> itr2 = list2.descendingIterator();
            LinkedList<Integer> list3 = new LinkedList<>();

            int carry = 0;

            while (itr1.hasNext() || itr2.hasNext() || carry>0) {

                int val = carry;
                if(itr1.hasNext()) val+=itr1.next();
                if(itr2.hasNext()) val+= itr2.next();
                carry = val / 10;
                val = val % 10;
                list3.add(val);

            }

            return list3.reversed();

        }
    }


        class Node {
            int val;
            Node next;

            Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
        }


        /**class TestSumList {

            AtlassianCodeTest testClass;

            LinkedList<Integer> list1;

            LinkedList<Integer> list2 = new LinkedList<>();


            public void init() {
                list1 = new LinkedList<>();
                list2 = new LinkedList<>();

            }

            @Test
            public void testSumList() {
                list1.add(1);
                list1.add(1);
                list1.add(9);
                list2.add(1);
                list2.add(1);
                list2.add(1);
                LinkedList<Integer> list3 = new LinkedList<>();
                list3.add(2);
                list3.add(3);
                list3.add(0);

                LinkedList<Integer> res = sumList(list1, list2);
                Assert.assertEquals(list3, res);


            }
        }**/
