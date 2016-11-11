import java.util.Stack;

public class Solution {
    public int removeDuplicates(int[] A) {
        int n=A.length, idx=4;
        if(n<5) return n;
        for(int i=4;i<n;i++){
        	if(A[i]!=A[idx-4])
        		A[idx++]=A[i];
        }
        return idx;
    }

	
	  
	}
}
