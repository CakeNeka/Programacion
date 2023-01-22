package algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Algoritmos {

    public static void main(String[] args) {
        //System.out.println(bestSubarrayOfLengthK(new int[]{12, 9, 23, 17, 25, 19, 4, 8, 21, 34, 26, 17, 19, 14, 27, 22, 15, 7, 2, 14, 5, 18, 24}, 5));
        //System.out.println(findLengthOfLCIS2(new int[]{2,4,5,6,7,5,4,3}));
        
        //System.out.println(binarySearchRecursive(new int[]{6,7,7}, 6));
        //System.out.println(reverseString2("alog seripme fo ega buenas tardes"));
        //System.out.println(isPalindrome2("kollok"));
        
        //System.out.println(isPalindrome2(34243));
        //System.out.println(decimalToBinary(233));
        //System.out.println(lengthOfLongestSubstring("abcabcbb"));
        
        System.out.println(sumOfNaturalNumbers(7));
        
        int[] arr = {2,5,7,34,123,7,3,1,34,35,76};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        
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
        int reversed = 0;
        while(y != 0) {
            reversed = reversed * 10 + y % 10;
            y /= 10;
        }
        return x == reversed;
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
    
    
    
    // 3. Longest Substring Without Repeating Characters (LC 3)
    public static  int lengthOfLongestSubstring(String s) {
        int[] letters = new int[128];
        int i = 0;
        int j = 1;
        int bestLength = 1;
        letters[s.charAt(i)] = 1;
        while (j < s.length()) {
            if (letters[s.charAt(j)] == 0){
                letters[s.charAt(j)] = 1;
                j++;
                bestLength = Math.max(j-i, bestLength);
            } else {
                letters[s.charAt(j)] = 2;
                while (letters[s.charAt(j)] == 2 && i < j){
                    letters[s.charAt(i)]--;
                    i++;
                }
                j++;
            }
        }
        return bestLength;
    }
    
    /* Recursion */
    public static int sumOfNaturalNumbers(int base) {
        return (base + 1) * base/2;
    }
    
    public static int recursiveSummation(int base) {
        if (base <= 1) 
            return base;
        return base + recursiveSummation(base-1);
    }
    
    public static long fibonacci(int n) {
        if(n == 0 || n == 1)
            return n;
        else
            return fibonacci(n-1) + fibonacci(n-2); 
    }
    
    
    
    static Map<Integer, Integer> memoizedCache = new HashMap<>();
    public static long optimizedFibo(int n) {
        memoizedCache.put(1,1);
        memoizedCache.put(0,1);
        return fibonacci2(n);
    }
    public static int fibonacci2(int n) {
        if(memoizedCache.containsKey(n))
            return memoizedCache.get(n);
        int result = fibonacci2(n-1) + fibonacci2(n-2);
        memoizedCache.put(n, result);
        return result;
    }
    
    public static void mergeSort(int[] arr){
        if(arr.length == 1) {
            return;
        }
        int mid = arr.length/2;
        int[] leftArr = new int[mid];          // se puedes usar Arrays.copyOf();
        int[] rightArr = new int[arr.length - mid];
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[i+mid];
        }
        
        mergeSort(leftArr);
        mergeSort(rightArr);
        
        int i = 0, j = 0, k = 0;
        while(i < leftArr.length && j < rightArr.length){
            if (leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while(i < leftArr.length){     // Some values left in rightArr OR leftArr
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while(j < rightArr.length){
            arr[k] = rightArr[j];
            j++;
            k++;
        }    
   }
    
   
    
}
