import java.util.*;

class Twitter {

    class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    Map<Integer, Set<Integer>> follows;
    Map<Integer, List<Tweet>> tweets;

    int timestamp;

    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId)
              .add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Tweet> feed = new ArrayList<>();

        if (tweets.containsKey(userId))
            feed.addAll(tweets.get(userId));

        Set<Integer> followees =
                follows.getOrDefault(userId,
                                     new HashSet<>());

        for (int user : followees) {
            if (tweets.containsKey(user))
                feed.addAll(tweets.get(user));
        }

        feed.sort((a, b) -> b.time - a.time);

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < Math.min(10, feed.size()); i++) {
            ans.add(feed.get(i).id);
        }

        return ans;
    }

    public void follow(int followerId,
                       int followeeId) {

        follows.putIfAbsent(followerId,
                            new HashSet<>());

        follows.get(followerId)
               .add(followeeId);
    }

    public void unfollow(int followerId,
                         int followeeId) {

        if (follows.containsKey(followerId))
            follows.get(followerId)
                   .remove(followeeId);
    }
}