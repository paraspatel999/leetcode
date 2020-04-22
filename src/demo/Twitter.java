package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @auther parapatel
 */

class Twitter {

    class TweetComparator implements Comparator<TweetData> {

        @Override
        public int compare(TweetData o1, TweetData o2) {
            if (o1.time < o2.time) {
                return 1;
            }
            if (o1.time > o2.time) {
                return -1;
            }
            return 0;
        }
    }

    class TweetData {
        int userId;
        int tweetId;
        long time;

        public TweetData(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.time = ++currTweet;
        }
    }

    //LinkedList<TweetData> allTweet = new LinkedList<>();
    Map<Integer, LinkedList<TweetData>> data = new HashMap<>();

    Map<Integer, Set<Integer>> userData = new HashMap<>();

    long currTweet = 0;
    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        //allTweet.add(new TweetData(userId, tweetId));
        TweetData tweetData = new TweetData(userId, tweetId);
        addTweetToUser(userId, tweetData);
    }

    private void addTweetToUser(int userId, TweetData tweetData) {
        if (!this.data.containsKey(userId)) {
            this.data.put(userId, new LinkedList<>());
        }
        this.data.get(userId).add(tweetData);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<TweetData> queue = new PriorityQueue<>(new TweetComparator());
        addToQueue(userId, queue);
        for (int followUsers: userData.getOrDefault(userId, new HashSet<>())) {
            addToQueue(followUsers, queue);
        }
        int i = 1;
        while ( i <= 10 && !queue.isEmpty()) {
            res.add(queue.poll().tweetId);
        }
        return res;
    }

    private void addToQueue(int userId, PriorityQueue<TweetData> queue) {
        Iterator<TweetData> it = this.data.get(userId).descendingIterator();
        int max = 0;
        while (it.hasNext() && max < 10) {
            TweetData tweetData = it.next();
            queue.add(tweetData);
        }
    }

    private void reCalculateNewsFeed(int userid, int followId) {
        LinkedList<TweetData> userTweet = this.data.get(userid) != null ? this.data.get(userid) : new LinkedList<>();
        if (this.data.containsKey(followId)) {
            LinkedList<TweetData> followerTweet = this.data.get(followId);
            userTweet.addAll(followerTweet);
            Collections.sort(userTweet, new TweetComparator());
        }

    }

    private void removeTweet(int userid, int followId) {
        LinkedList<TweetData> userTweet = this.data.get(userid) != null ? this.data.get(userid) : new LinkedList<>();
        Iterator<TweetData> it = userTweet.descendingIterator();
        while (it.hasNext()) {
            TweetData tweetData = it.next();
            if (tweetData.userId == followId) {
                it.remove();
            }
        }
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userData.containsKey(followerId)) {
            userData.put(followerId, new HashSet<>());
        }
        userData.get(followerId).add(followeeId);
        //reCalculateNewsFeed(followeeId, followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userData.containsKey(followerId)) {
            userData.put(followerId, new HashSet<>());
        }
        userData.get(followerId).remove(followeeId);
        //removeTweet(followerId, followeeId);
    }

    public static void main(String[] args) {
        Twitter t = new Twitter();
        t.postTweet(2,5);
        t.postTweet(1,3);
        t.postTweet(1,101);
        t.postTweet(2,13);
        t.postTweet(2,10);
        t.postTweet(1,2);
        t.postTweet(2,94);
        t.postTweet(2,505);
        t.postTweet(1,333);
        t.postTweet(1,22);
        System.out.println(t.getNewsFeed(2));
        t.follow(2,1);
       // t.postTweet(2,6);
        System.out.println(t.getNewsFeed(2));
       // t.unfollow(1,2);
        //System.out.println(t.getNewsFeed(1));
    }
}