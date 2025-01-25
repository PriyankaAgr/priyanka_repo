package org.dsa.incubation;

import java.util.*;

public class TwitterDesign {

    static Map<Integer, List<Pair<Long,Integer>>> userMap= new HashMap<>();
    static Map<Integer, Set<Integer>> followMap= new HashMap<>();

    public static void main(String[] args){
        TwitterDesign twt =new TwitterDesign();
        twt.postTweet(1,5);
        twt.postTweet(1,3);

        List<Integer> res = getNewsFeed(1);
        res.stream().forEach(t -> System.out.println(t));
       /** twt.follow(1,2);
        twt.postTweet(2,6);
        List<Integer> res1 = getNewsFeed(1);
        res1.stream().forEach(t -> System.out.println(t));
        twt.unfollow(1,2);
        List<Integer> f3 = getNewsFeed(1);
        f3.stream().forEach(t -> System.out.println(t));**/



    }
    int size;
    public TwitterDesign() {
        size=10;
    }

    public void postTweet(int userId, int tweetId) {
        long sysdate=System.currentTimeMillis();
        userMap.computeIfAbsent(userId, k-> new ArrayList<>());
      //  userMap.get(userId).add(new Pair<>(sysdate, tweetId));
        userMap.put(userId,userMap.get(userId));

    }

    public static List<Integer> getNewsFeed(int userId) {
        Set<Integer> follower = followMap.getOrDefault(userId, new HashSet<>());
        follower.add(userId);
        List<Pair<Long,Integer>> tweets = new ArrayList<>();
        follower.parallelStream().filter(user-> userMap.containsKey(user))
                .forEach(user-> tweets.addAll(userMap.get(user).stream().toList()));
        return tweets.stream().sorted(Collections.reverseOrder(Comparator.comparing(p->p.x))).map(p->p.y).distinct().limit(10).toList();

    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k-> new HashSet<>()).add(followeeId);
        followMap.put(followerId, followMap.get(followerId));

    }

    public void unfollow(int followerId, int followeeId) {
        followMap.get(followerId).remove((Integer)followeeId);

    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */