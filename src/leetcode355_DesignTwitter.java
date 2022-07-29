import java.util.*;

public class leetcode355_DesignTwitter {
    class Twitter {
    private final int feedLimit = 10;
    private int time = 0;

    // Add to queue from back and remove from the front
    class Tweet {
        public int id;
        public int uid;
        public int time;

        Tweet(int id, int uid, int time) {
            this.id = id;
            this.uid = uid;
            this.time = time;
        }
    }

    class User {
        public int userId;
        public Set<Integer> follows;
        public Set<Integer> followedBy;
        public List<Tweet> tweets;
        public Queue<Tweet> newsFeed;

        User(int userId) {
            this.userId = userId;
            this.follows = new HashSet<>();
            this.followedBy = new HashSet<>();

            this.tweets = new ArrayList<>();
            this.newsFeed = new PriorityQueue<Tweet>((a, b) -> {
                return b.time - a.time;
            });
        }

    }

    private Map<Integer, User> twitter; //userId and user

    public Twitter() {
        this.twitter = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        this.time += 1;
        User cu = getUser(userId);
        Tweet tweet = new Tweet(tweetId, userId, this.time);
        cu.tweets.add(tweet);
        cu.newsFeed.add(tweet);

        for (int followerId : cu.followedBy) {
            getUser(followerId).newsFeed.add(tweet);
        }
    }

    private User getUser(int userId) {
        if (!this.twitter.containsKey(userId)) {
            this.twitter.put(userId, new User(userId));
        }
        return this.twitter.get(userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        // some sort of bucket to keep track of latest feed for user
        // This feed from people he follows or his own feed

        List<Integer> finalFeed = new ArrayList<>();
        Queue<Tweet> newsfeed = getUser(userId).newsFeed;
        List<Tweet> backup = new ArrayList<>();

        int i = 0;
        while (!newsfeed.isEmpty() && i < this.feedLimit) {
            Tweet curTweet = newsfeed.poll();
            backup.add(curTweet);
            finalFeed.add(curTweet.id);
            i++;
        }

        for (Tweet t : backup) {
            newsfeed.add(t);
        }
        return finalFeed;
    }

    public void follow(int followerId, int followeeId) {
        // followerId will start following followeeId
        User followerUser = getUser(followerId);
        User followeeUser = getUser(followeeId);
        if (followerUser.follows.contains(followeeId)) return;

        followerUser.follows.add(followeeId);
        followeeUser.followedBy.add(followerId);


        for (Tweet tweet : followeeUser.tweets) {
            followerUser.newsFeed.add(tweet);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        // remove this user
        User followerUser = getUser(followerId);
        if (!followerUser.follows.contains(followeeId)) return;

        followerUser.follows.remove(followeeId);
        getUser(followeeId).followedBy.remove(followerId);
        // anything that was introduced by user follower should be removed from his feed

        followerUser.newsFeed.removeIf(a -> (a.uid == followeeId));
    }
}

}
