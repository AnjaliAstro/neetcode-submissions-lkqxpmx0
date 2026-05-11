class Twitter {
    int timeStamp = 0;
    Map<Integer, List<int[]>> userToTweet;
    Map<Integer, Set<Integer>> followersToFollowee;
    public Twitter() {
        userToTweet = new HashMap<>();
        followersToFollowee = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        timeStamp++;
        List<int[]> posts = userToTweet.getOrDefault(userId, new ArrayList<>());
        posts.add(new int[]{tweetId, timeStamp});
        userToTweet.put(userId, posts);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> feeds = new PriorityQueue<>((a,b)->(b[1]-a[1]));

        for(Integer celebrity: followersToFollowee.getOrDefault(userId, new HashSet<>())){
            List<int[]> feed = userToTweet.getOrDefault(celebrity, new ArrayList<>());
            feeds.addAll(feed);
        }
        feeds.addAll(userToTweet.getOrDefault(userId, new ArrayList<>()));
        List<Integer> latestFeed = new ArrayList<>();
        int top = 0;
        while(!feeds.isEmpty()){
            int[] fee = feeds.poll();
            latestFeed.add(fee[0]);
            top++;
            if(top == 10)
                break;
        }
        return latestFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        Set<Integer> followees = followersToFollowee.getOrDefault(followerId, new HashSet<>());
        followees.add(followeeId);
        followersToFollowee.put(followerId, followees);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        Set<Integer> followees = followersToFollowee.getOrDefault(followerId, new HashSet<>());
        followees.remove(followeeId);
        followersToFollowee.put(followerId, followees);
    }
}
