package Hard;

import java.util.*;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);
        for(int i=0; i<res.length; i++){
            System.out.println(Arrays.toString(res[i]));
        }
    }

    //Optimal Force Approach
    //Time Complexity : O(nLogn) for Sorting + O(n)
    //Space complexity : O(N) for storing results only.
    public static int[][] merge(int[][] intervals) {

        // Step 1: Sort by start time
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end= intervals[0][1];

        //Step 2: Merge 2 Intervals
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]>=start && intervals[i][0]<=end){
                end=Math.max(end, intervals[i][1]);
            }else{//No overlap
                res.add(new int[]{start, end});
                start=intervals[i][0];
                end= intervals[i][1];
            }       
        }

        // Add last interval - bcz Overlap will not encounter
        res.add(new int[]{start, end});

        //this creates a new 2D array of the right size,and fills it with all elements from the list.
        return res.toArray(new int[res.size()][]);
    }
}
