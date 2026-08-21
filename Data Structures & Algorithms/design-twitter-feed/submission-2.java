class Tweet {
    private int userId;
    private int tweetId;
    private int timestamp;

    public Tweet(int userId, int tweetId, int timestamp) {
        this.userId = userId;
        this.tweetId = tweetId;
        this.timestamp = timestamp;
    }

    public int getUserId() {
        return userId;
    }

    public int getTweetId() {
        return tweetId;
    }

    public int getTimestamp() {
        return timestamp;
    }
}

class TweetEntry {
    private Tweet tweet;
    private int index;

    public TweetEntry(Tweet tweet, int index) {
        this.tweet = tweet;
        this.index = index;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public int getIndex() {
        return index;
    }
}

class Twitter {
    private int counter;
    private final HashMap<Integer, HashSet<Integer>> userFollowMap = new HashMap<>();
    private final HashMap<Integer, ArrayList<Tweet>> userTweetsMap = new HashMap<>();

    public Twitter() {
        this.counter = 0;    
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(userId, tweetId, counter++);

        if (!userTweetsMap.containsKey(userId)) {
            userTweetsMap.put(userId, new ArrayList<>());
        }

        userTweetsMap.get(userId).add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<TweetEntry> recentTweets = new PriorityQueue<>((a, b) -> b.getTweet().getTimestamp() - a.getTweet().getTimestamp());

        if (userTweetsMap.containsKey(userId)) {
            List<Tweet> tweets = userTweetsMap.get(userId);

            int index = tweets.size() - 1;

            recentTweets.add(new TweetEntry(tweets.get(index), index));
        }

        if (userFollowMap.containsKey(userId)) {
            for (Integer followeeId : userFollowMap.get(userId)) {
                if (userTweetsMap.containsKey(followeeId)) {
                    List<Tweet> tweets = userTweetsMap.get(followeeId);

                    int index = tweets.size() - 1;

                    recentTweets.add(new TweetEntry(tweets.get(index), index));
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!recentTweets.isEmpty() && result.size() < 10) {
            TweetEntry entry = recentTweets.poll();

            result.add(entry.getTweet().getTweetId());

            int nextIndex = entry.getIndex() - 1;

            if (nextIndex >= 0) {
                List<Tweet> tweets = userTweetsMap.get(entry.getTweet().getUserId());

                recentTweets.add(new TweetEntry(tweets.get(nextIndex), nextIndex));
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!userFollowMap.containsKey(followerId)) {
            userFollowMap.put(followerId, new HashSet<>());
        }

        userFollowMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (userFollowMap.containsKey(followerId)) {
            userFollowMap.get(followerId).remove(followeeId);
        }
    }
}
