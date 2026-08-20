class Tweet {
    private int tweetId;
    private int timestamp;

    public Tweet(int tweetId, int timestamp) {
        this.tweetId = tweetId;
        this.timestamp = timestamp;
    }

    public int getTweetId() {
        return tweetId;
    }

    public int getTimestamp() {
        return timestamp;
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
        Tweet tweet = new Tweet(tweetId, counter);

        if (userTweetsMap.containsKey(userId)) {
            userTweetsMap.get(userId).add(tweet);
        } else {
            userTweetsMap.put(userId, new ArrayList<>());
            userTweetsMap.get(userId).add(tweet);
        }

        counter++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> recentTweets = new PriorityQueue<>((tweet1, tweet2) ->tweet2.getTimestamp() - tweet1.getTimestamp());

        if (userTweetsMap.containsKey(userId)) {
            recentTweets.addAll(userTweetsMap.get(userId));
        }

        if (userFollowMap.containsKey(userId)) {
            if (userFollowMap.containsKey(userId)) {
                for(Integer followeeId : userFollowMap.get(userId)) {
                    if (userTweetsMap.containsKey(followeeId)) {
                        recentTweets.addAll(userTweetsMap.get(followeeId));
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!recentTweets.isEmpty() && result.size() < 10) {
            result.add(recentTweets.poll().getTweetId());
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (userFollowMap.containsKey(followerId)) {
            userFollowMap.get(followerId).add(followeeId);
        } else {
            userFollowMap.put(followerId, new HashSet<>());
            userFollowMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!userFollowMap.containsKey(followerId)) {
            return;
        }

        userFollowMap.get(followerId).remove(Integer.valueOf(followeeId));
    }
}
