//Q- https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559?leftPanelTab=0
//You are given the task of assigning stalls to cows such that the minimum distance between any two of them is the maximum possible.

package Binary_Search.Hard;

import java.util.*;

public class AgressiveCows {
    public static void main(String[] args) {
        int[] stalls = {4, 2, 1, 3, 6};
        int cows = 2;
        System.out.println(maxMinDistance(stalls, cows));
    }

    public static int maxMinDistance(int[] stalls, int cows){
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        while(low<=high){
        	int mid = low + (high - low) / 2;
        	if(canPlaceCow(stalls, cows, mid)){
        		low = mid + 1;
        	}else high = mid - 1;
        }

        return high;
    }

    public static Boolean canPlaceCow(int[] stalls, int cows, int dist){

        int countCow=1, lastCowPos=stalls[0];

        for(int i = 1; i<stalls.length; i++){
        	if(stalls[i] - lastCowPos>=dist){
        		countCow++;
        		lastCowPos=stalls[i];
        	}
        }
        if(countCow==cows) return true;

        return false;
    }

}
