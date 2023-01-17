package algo;

public class Algoritmos {

    public static void main(String[] args) {
        //System.out.println(bestSubarrayOfLengthK(new int[]{12, 9, 23, 17, 25, 19, 4, 8, 21, 34, 26, 17, 19, 14, 27, 22, 15, 7, 2, 14, 5, 18, 24}, 5));
        //System.out.println(findLengthOfLCIS2(new int[]{2,4,5,6,7,5,4,3}));
        
        //System.out.println(binarySearchRecursive(new int[]{6,7,7}, 6));
        //System.out.println(reverseString2("alog seripme fo ega buenas tardes"));
        //System.out.println(isPalindrome2("kollok"));
        
        System.out.println(isPalindrome(34243));
        System.out.println(decimalToBinary(233));
    }

    public static int bestSubarrayOfLengthK(int[] arr, int k) {
        int best = 0;
        int current = 0;
        for (int i = 0; i < k; i++) {
            current += arr[i];
        }
        best = current;
        for (int i = 0; i < arr.length - k; i++) {
            current -= arr[i];
            current += arr[i + k];

            if (current > best) {
                best = current;
            }
        }
        return best;
    }
    // Longest Continuous Increasing Subsequence
    public static int findLengthOfLCIS(int[] arr) {
        
        if (arr.length == 1) return 1;
        
        // Current range and sum of sliding window
        int start = 0;
        int end = 1;
        int len = 0;

        // Extend sliding window until condition is met
        while (end < arr.length) {

            if (arr[end-1] >= arr[end] || end == arr.length - 1) {
                
                int currentLen = end - start;
                if (end == arr.length - 1 && arr[end-1] != arr[end])
                    currentLen++;
                if (len < currentLen) {
                    len = currentLen;
                }
                start = end;
                end++;
            } else {
                end++;
            }
        }
        return len;
    }
    
    public static int findLengthOfLCIS2(int[] nums) {
        int result = 0;
        int anchor = 0;                                 // Start pointer
                                                
        for (int i = 0; i<nums.length; i++){            // i = End pointer
            if (i > 0 && nums[i-1] >= nums[i])          // anchor set when the condition is not met
                anchor = i;
            result = Math.max(result, i - anchor + 1);
        }
        return result ;
    }
    
    public static int binarySearch(int[] arr, int target){
        
        int left = 0;
        int right = arr.length - 1;
        int mid;
        
        while(left <= right){
            mid = left + (right-left) / 2;
            if(arr[mid] == target) return mid;
            if (arr[mid] > target)  right = mid-1;
            else left = mid+1;
        }
        return -1;
    }
    
    private static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        int mid = left + (right-left) / 2;
        
        if (arr[mid] == target) return mid;
        if (left >= right)      return -1;
        
        if (arr[mid] > target)  return binarySearchRecursive(arr, target, left, mid-1);
        else                    return binarySearchRecursive(arr, target, mid+1, right);
    }

    public static int binarySearchRecursive(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length-1);
    }
    
    private static String reverseString(String str){
        // Base case
        if (str.length() <= 1) return str;      // puede ser if(str.isEmpty()){ return "" }
        
        int midIndex = str.length()/2;
        return reverseString(str.substring(midIndex)) + reverseString(str.substring(0, midIndex));
//      return reverseString(str.substring(1)) + input.charAt(0)
    }
    
    private static String reverseString2(String str){
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }
    
    private static boolean isPalindrome(String str){
        return str.equals(reverseString(str));
    }
    
    private static boolean isPalindrome2(String str){
        if(str.isEmpty() || str.length() == 1) return true;
        
        if(str.charAt(0) == str.charAt(str.length()-1)) 
            return isPalindrome2(str.substring(1, str.length()-1));
        
        return false;
    }
    
    private static boolean isPalindrome(int num){
        // No funciona
        
        if (num < 0) return false;
        if (num < 10) return true;
        
        int digits = (int) Math.log10(num);
        int firstDigit = (int) (num / (int) Math.pow(10, digits));
        int lastDigit = num % 10;
        
        if (firstDigit == lastDigit){
            num -= firstDigit * (int)Math.pow(10, digits);
            if (num < (int)Math.pow(10, digits-1))
                num += (int)Math.pow(10, digits-1);
            
            
            num /= 10;
            return isPalindrome(num);
        }
        return false;
    }
    
    public static  boolean isPalindrome2(int x) {
        if(x < 0) return false;
        int y = x;
        int res = 0;
        while(y != 0) {
            res = res * 10 + y % 10;
            y /= 10;
        }
        return x == res;
    }
    
    public static String decimalToBinary(int decimal){
        if (decimal == 0) return "";
        
        int resto = decimal % 2;
        decimal /= 2;
        return decimalToBinary(decimal) + resto;
    }
    
    static int firstDigit (int n){
        n = Math.abs(n);
        int digits = (int) Math.log10(n);
        return (int) (n/(int)Math.pow(10, digits));
    }
}
