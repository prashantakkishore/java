package com.pks.ds.dp;

/**
 * https://leetcode.com/problems/video-stitching/
 * You are given a series of video clips from a sporting event that lasted time seconds. These video clips can be overlapping with each other and have varying lengths.
 *
 * Each video clip is described by an array clips where clips[i] = [starti, endi] indicates that the ith
 * clip started at starti and ended at endi.
 *
 * We can cut these clips into segments freely.
 *
 * For example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
 * Return the minimum number of clips needed so that we can cut the clips into segments that cover the
 * entire sporting event [0, time]. If the task is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], time = 10
 * Output: 3
 * Explanation: We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
 * Then, we can reconstruct the sporting event as follows:
 * We cut [1,9] into segments [1,2] + [2,8] + [8,9].
 * Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0, 10].
 * Example 2:
 *
 * Input: clips = [[0,1],[1,2]], time = 5
 * Output: -1
 * Explanation: We cannot cover [0,5] with only [0,1] and [1,2].
 */
public class VideoClipsToMakeCompleteSportingEvent {


    public static void main(String[] args) {
        int [][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        System.out.println(videoStitching(clips, 10));
    }

    public static int videoStitching(int[][] clips, int time) {

        int min = 0, max = 0, stitches = 0;
        while(max < time) {

            for (int i = 0; i < clips.length; i++) {
                if (min >= clips[i][0] && max < clips[i][1])
                    max = clips[i][1];
            }
            stitches++;
            min = max;


        }
        return stitches;

    }
}
