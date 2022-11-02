import java.util.Arrays;

public class LongestCommonPrefix{

    public static String longestCommString(String[] a) {
        if(a.length==0) return "";
        if(a.length==1) return a[0];

        Arrays.sort(a);

        int end = Math.min(a[0].length() , a[a.length-1].length());
        int i=0;
        while(i<end && a[0].charAt(i)==a[a.length-1].charAt(i)){
            i++;
        }

        return a[0].substring(0,i);
    }
    public static void main(String[] args) {
        
        String[] input = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println(longestCommString(input));
    }
}