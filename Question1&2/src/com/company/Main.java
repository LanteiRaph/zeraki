package com.company;

//import java.lang.reflect.Array;
//import java.util.Arrays;

public class Main{


    //Find the mmissing number in and array. 
    //Get the lenght and (one) and (two) divid the total by to
    //Minus each given number from the total number the result is the missing number 
    public static int missingNumber(int[] arr) {
        //Decaalre the missing number
        int missing;
        //Get the miising ie, the totol combination of element
        missing = (arr.length + 2) * (arr.length + 1) / 2;
        //Step through the given array and subtract it from the total.
        for (int i = 0; i < arr.length; i++) {
            missing -= arr[i];
        }
        //Return the missing number.
        return missing;
    }

    //Reverse a string 
    public static String fourWayReversal(String string) {
        //Start of with an empty string
        String result = "";
        //Declare the requler expression that split the stirng within four characters
        String regex = "(?<=\\G.{4})";
        //Use the regex to split the string
        String[] splitArray = string.split(regex);
        //Append the revers string to the result 
        for (String stringSubArray : splitArray) {
            System.out.println(stringSubArray);
            result= result.concat(new StringBuilder(stringSubArray).reverse().toString());
        }
        //Return the genereted string as the result.
        return result;
    }
    public static void main(String[] args) {
        int[] numbers = {1,2,4,5};
       //Print the missing number
       System.out.println(missingNumber(numbers));
       //Print the reveresed string.
       System.out.println(fourWayReversal("Lorem Ip"));
    }
}
