/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[][] lineSweep = new int[2*intervals.size()][2];

        int index = 0;
        for(Interval val:intervals){
            lineSweep[index] = new int[]{val.start, 1};
            lineSweep[index+1] = new int[]{val.end, -1};
            index += 2;
        }

        Arrays.sort(lineSweep, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int minRooms = 0;
        int rooms = 0;
        for(int[] line:lineSweep){
            rooms += line[1];
            minRooms = Math.max(Math.abs(rooms), minRooms);
        }
        return minRooms;
    }
}

// 0,1
// 5,1
// 10,-1
// 15,1
// 20,-1
// 40,-1
