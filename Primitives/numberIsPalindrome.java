
import java.util.*;
class Main {
    public static void main(String[] args) {
       int number = 1213;
       
       Main mObj = new Main();
       boolean result = mObj.checkIfIsPalindrome(number);
       System.out.println(number+" Number is palindrome: "+result);
    }
    
    public boolean checkIfIsPalindrome(int number)
    {
        if(number < 0) return false;
        
        double logAns = Math.log10(number);
        int totalDigits = (int)(Math.floor(logAns)) + 1;
        int mask = (int)(Math.pow(10,totalDigits-1));
        
        for(int i=0;i<(totalDigits/2);i++)
        {
            int msb = number/mask;
            int lsb = number % 10;
            
            if(msb!=lsb) return false;
            
            number = number % mask;
            number = number / 10;
            mask = mask/100;
        }
        return true;
    }
}