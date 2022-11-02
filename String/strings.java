import java.util.*;
public class strings {

public static boolean isPalindrom(String S) {
    int l=0, r=S.length()-1;
    while(l<r){
        if(S.charAt(l)==S.charAt(r)){
            l++;
            r--;
        }
        else{
            return false;
        }
    }
    
    return true;
}

public static String Uppercase(String S) {
    String res = "";
    for(int i=0; i<S.length(); i++){
        char ch = S.charAt(i);
        if(ch>='a'){
            ch =(char)(ch-32);
        }
        res += ch;
    }
    return res;
}
public static void main(String[] args) {
    String S = "Hey";
    for(int i=0; i<S.length(); i++){
        for(int j=i+1; j<=S.length(); j++ ){
            System.out.println(S.substring(i,j));
        }
        // System.out.println();
    }

    String Str = "1020302011";
    System.out.println(isPalindrom(Str));

    String StrU = "aBcceD";
    System.out.println(Uppercase(StrU));
}
}
