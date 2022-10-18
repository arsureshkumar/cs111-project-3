/*
 * Project #3
 * Source Code File: GradeBook.java
 * Programmer: Arjun Suresh Kumar
 * Due: 10/18/21
 * Description: A program that takes in
 * input grades, then displays some statistics
 * about the grades
 */

package Project3;

import java.util.Scanner;

public class GradeBook{
    public static void main(String[] args){

        //define scanner and initialize variables
        Scanner scanner = new Scanner(System.in);        
        
        //input grade from the user
        double input = 0;

        //total sum of the grades, needed to display average
        double sum = 0;

        //total number of grades
        int count = 0;

        //array to store each of the counts for the grades
        int[] counts = new int[5];

        //create loop
        while(true){

            //take in input
            System.out.print("Enter a score (a negative score exits): ");
            input = scanner.nextDouble();

            //check if user wants to exit the loop
            if (gradeConverter(input).equals("N")){
                break;
            }

            //increment counts and display reponse messages
            switch(gradeConverter(input)){
                case "A":
                    counts[0]++;
                    System.out.println("The score of " + input + " is an A");
                    break;
                case "B":
                    counts[1]++;
                    System.out.println("The score of " + input + " is a B");
                    break;
                case "C":
                    counts[2]++;
                    System.out.println("The score of " + input + " is a C");
                    break;
                case "D":
                    counts[3]++;
                    System.out.println("The score of " + input + " is a D");
                    break;
                case "F":
                    counts[4]++;
                    System.out.println("The score of " + input + " is an F");
                    break;
            }

            sum += input;
            count++;
        }
        

        //display per grade counts
        String[] grades = new String[] {"A", "B", "C", "D", "F"};
        for(int i = 0; i < grades.length; i++){
            System.out.println("Total number of " + grades[i] + "’s: " + counts[i]);
        }

        //display total counts, average grade, average grade letter
        System.out.println("Total number of scores input: "+ count);
        System.out.println("Average class score: " + sum/count);
        System.out.println("Average class score: " + gradeConverter(sum/count));

        scanner.close();

    }

    //method to return the letter grade of any given grade percentage, also checks for invalid values
    public static String gradeConverter(double input){
        
        if(input <= 100.0){
            if(input >= 90.0){
                return("A");
            } else if(input >= 80.0){
                return("B");
            } else if(input >= 70.0){
                return("C");
            } else if(input >= 60.0){
                return("D");
            } else if(input >= 0){
                return("F");
            }
        }

        return("N");
    }
}