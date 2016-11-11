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

	public int calculate(String s) {
	    int len=s.length();
	    if ( s==null || len ==0) return 0; //对边界的定义与返回体现了逻辑的严密性,但是leetcode中这句话也可以省略
	    Stack <Integer> stack = new Stack <Integer>();
	    int num=0;
	    char sign='+';//this sign push the 1st number then change in theloop 虽然进入循环但并没有用当前的符号pushnum
	    for(int i=0;i<len;i++){
	        if (Character.isDigit(s.charAt(i))){
	            num= num*10+ s.charAt(i)-'0';
	        }
	        if ((!Character.isDigit(s.charAt(i))&&' '!=s.charAt(i))||i== len-1){ //push the last num with the last sign
	            if (sign=='-') stack.push(-num);
	            if (sign=='+') stack.push(num);
	            if (sign=='/') stack.push(stack.pop()/num);
	            if (sign=='*') stack.push(stack.pop()*num);               
	            sign=s.charAt(i);
	            num=0;
	        }
	    }
	    int re=0;
	    for(int i:stack) re+=i;
	    return re;
	  
	}
}