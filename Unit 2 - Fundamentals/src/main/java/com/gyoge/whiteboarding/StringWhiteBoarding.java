package com.gyoge.whiteboarding;

@SuppressWarnings("all")
public class StringWhiteBoarding {

    /*
    Easy question

    Write a method that prints out every myNum character in a string.

    myNum is always less than the length of string!

    Examples:
        input:
            string1 = "Go away Ryo"
            myNum = "3"
        output = "Gayy"

        input:
            string1 = "deboring"
            myNum = 2
        output = "eoig"
     */
    public static void easyOne(String string1, int myNum) {
        // TODO: Finish the method
    }

    /*
    Easy question

    What does the method do?
    input:
        string1 = "calculus? *moans*"
        charArray = "Cubic formula?"

    output = ?
    */

    public static void easyTwo(String string1, char[] charArray) {
        for (int i = charArray.length - 1; i >= 0; i--) {
            System.out.print(charArray[i]);
            System.out.print(string1.charAt(i));
        }
    }

    /*
    Hard question

    Write a method that prints out a string, but all the consonants are replaced with
    whatever character is at that position in string2

    string2 is always larger than string1

    Examples:
        input:
            string1 = "Hello World!"
            string2 = "Four Function Calculators"
        output = "FeuroFuoctio"

        input:
            string1 = "abcdefghijklmnopqrstuvwxyz"
            string2 = "1234567890!@#$%^&*()[]{}<>,.;:-_=+"
        output = "a234e678i0!@#$o^&*()u]{}<>"
     */
    public static void hardOne(String string1, String string2) {
        // TODO: Finish the method
    }

    /*
    Hard question

    What does the method do?

    input:
        string1 = "mr cool is cool"
        string2 = "mr voetberg 123"
        string3 = "java is weird 1"

    output = ?
     */
    public static String hardTwo(String string1, String string2, String string3) {
        String returnString = "";

        for (int i = 0; i < string1.length(); i++) {

            returnString += string1.charAt(i);
            returnString += string2.charAt(i);
            returnString += string3.charAt(i);
        }

        return returnString;
    }

}
