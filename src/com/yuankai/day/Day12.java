package com.yuankai.day;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yuankai
 * @since 2020-04-13
 */
public class Day12 {
    /**
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/submissions/
     * 二叉树的最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return  Math.max(left, right) + 1;
    }
}

/**
 * https://leetcode-cn.com/problems/design-twitter/submissions/
 * 设计推特
 */
class Twitter {

    Map<Integer, LinkedList<Integer>> followerMap = new HashMap<>();

    static int count = Integer.MAX_VALUE;

    List<Tweet> tweets = new ArrayList<>();

    class Tweet{
        Integer tweetId;
        Integer time;
        Integer userId;

        public Tweet (Integer userId, Integer tweetId, Integer time) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.time = time;
        }

        public Integer getTweetId() {
            return tweetId;
        }

        public Integer getTime() {
            return time;
        }

        public Integer getUserId() {
            return userId;
        }
    }


    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(userId, tweetId, count--));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> followerIds = followerMap.getOrDefault(userId, new LinkedList<Integer>(){{this.add(userId);}});
        return tweets.stream().filter(t -> followerIds.contains(t.getUserId()))
                .sorted(Comparator.comparing(Tweet::getTime)).limit(10)
                .map(Tweet::getTweetId).collect(Collectors.toList());
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!followerMap.containsKey(followerId)) {
            followerMap.put(followerId, new LinkedList<Integer>(){{this.add(followerId);}});
        }
        followerMap.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        followerMap.getOrDefault(followerId, new LinkedList()).remove(Integer.valueOf(followeeId));
    }
}
