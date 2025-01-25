import java.util.*;

/**
 * Input:
 * words = ["wrt", "wrf", "er", "ett", "rftt"]
 * Output: "wertf"
 * <p>
 * w->r->t
 */
public class AlienDictionory {

    public static void main(String[] args) {

        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};

        System.out.println(linkedListApproach(words));
        System.out.println(graphBasedApproach(words));
    }

    private static String linkedListApproach(String[] words) {

        Map<Character, Node> hm = new HashMap<>();
        Node head = new Node('0');
        Node ptr=head;
        for (String word : words) {
            char[] arr = word.toCharArray();

            for (char ch : arr) {
                Node n;
                if (!hm.containsKey(ch))
                    n = new Node(ch);
                else n = hm.get(ch);
                hm.put(ch, n);
                ptr.next = n;
                ptr=ptr.next;
            }

        }
        ptr.next=null;
        head=head.next;
        StringBuilder sb = new StringBuilder();
        while(head.next!=null){
            sb.append(head.ch);
            head=head.next;
        }
        return sb.toString();

    }


    private static String graphBasedApproach(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.put(c, 0);
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLen = Math.min(word1.length(), word2.length());

            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        // topological sorting using BFS
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);

            for (char neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (result.length() == inDegree.size()) {
            return result.toString();
        } else {
            // There was a cycle (i.e., not all characters were processed)
            return "";
        }
    }
}


class Node {
    char ch;
    Node next;

    Node(char ch) {
        this.ch = ch;
        next = null;
    }
}
