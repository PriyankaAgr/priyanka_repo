import java.util.*;

public class FoodRating{

    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"}, new String[]{"snaxol", "snaxol", "snaxol", "fajbervsj", "fajbervsj"},new int[]{2,6,18,6,5});
        foodRatings.changeRating("qnvseohnoe",11);
        System.out.println(foodRatings.highestRated("fajbervsj"));
        foodRatings.changeRating("emgqdbo",3);
        foodRatings.changeRating("jmvfxjohq",9);
        foodRatings.changeRating("emgqdbo",14);
        System.out.println(foodRatings.highestRated("fajbervsj"));
        System.out.println(foodRatings.highestRated("snaxol"));
    }

}
class FoodRatings {

    Map<String, Map<String, Integer>> hm = new HashMap<>();
    Map<String, Integer> rating_map = new HashMap<>();
    Map<String, String> cuisine_food = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        for(int i=0;i<foods.length;i++){
            hm.computeIfAbsent(cuisines[i], k->new HashMap<>()).put(foods[i], ratings[i]);
            int rating=rating_map.getOrDefault(cuisines[i], 0);
            rating_map.put(cuisines[i], Math.max(rating, ratings[i]));
            cuisine_food.put(foods[i], cuisines[i]);

        }

    }



    public void changeRating(String food, int newRating) {
        String cuisine = cuisine_food.get(food);
        rating_map.put(cuisine, Math.max(rating_map.get(cuisine), newRating));
        hm.get(cuisine).put(food,newRating);



    }

    public String highestRated(String cuisine) {
        int highR = rating_map.get(cuisine);


        return hm.entrySet()
                .stream()
                .filter(e -> e.getKey().equals(cuisine)).flatMap(e->e.getValue().entrySet().stream().
                        filter(e1-> e1.getValue()==highR)).map(Map.Entry::getKey).findFirst().orElse(null);

        //**/

        /** if(k1.getValue()==k2.getValue()) return (k1.getKey().compareTo(k2.getKey()));
         else return (k2.getValue()-k1.getValue());
         }))**/

    }




}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */