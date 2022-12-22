import java.util.*;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
      
      rules();
      
      int round = 0;
      double points = 100;
      double bet;
      double c;
      

       try (Scanner sc = new Scanner(System.in)) {
        while( points > 0 && round < 5 ){ // places a loop which will continue until one of the conditions turns out to be false
          
          System.out.println("Type 1 for Single Die Bet " + '\n' + "Type 2 for Over 11" + '\n' + "Type 3 for Less Than 10" + '\n' + "Type 4 for Ouside 8-12");
          int type = sc.nextInt(); // assigns the next input from user to the next integer
          do{ // it will keep repeating the code inside its curly braces if the user's input does not meet the requirments.

            Scanner sc2 = new Scanner(System.in); // takes input from user
            System.out.println("Make your bet");
            bet= sc2.nextDouble();
            c=bet-Math.round(bet);

          }while( bet > points || bet <= 0 || c != 0 ); // it will keep asking the user for an input until the conditions are met (bet cannot be less than or equal to 0 and more than his available points)
            

        
           // assigns the next input from user to the next integer
  
        
          if (type == 1) {
              System.out.println("You have selected Single Die Bet");
              Scanner sc1 = new Scanner(System.in);
              System.out.println("Select a number from 1 to 6");
              int Chosen = sc1.nextInt();
            
              Random ranNum = new Random(); // creates a random number generator

              int total = 0;
              int randomNumber = 0;
              int count = 0;
              
              for (int i = 0; i < 3; i++) {
                randomNumber = ranNum.nextInt(6) +1; // assigns random numbers to the integer from 1-6
                ArrayList diceList = new ArrayList(); // creates a new ArrayList
                diceList.add(randomNumber); // adds variable "randomNumber" to the ArrayList named "diceList"
                System.out.println(diceList);
                total = total + randomNumber;
                             
                if (randomNumber == Chosen) {
                  count = 1;
                }
               
                }
              System.out.println("Total: " + total);
              points=wallet(bet,count,points); // calls in the method "wallet" and assigns in under points so that variable "points" doesn't refreshed
              round++ ;  // adds 1 to  the number of rounds after every round
            }
              else if (type == 2) {
              System.out.println("You have selected Over 11");
              double count1=user(type); // calls in the method "user(type)" and assigns it to "count1" so that it knows how much to multiply with the users bet to give him enough points
              points=wallet(bet,count1,points);
              round++ ; 
              } else if (type == 3) {
              System.out.println("You have selected Less Than 10");
              double count1=user(type);
              points=wallet(bet,count1,points);
              round++ ; 
              } else if (type == 4) {
              System.out.println("You have selected Outside 8-12");
              double count1=user(type);
              points=wallet(bet,count1,points);
              round++ ; 
              } else {
              System.out.println("Invalid Selection, Please try again");
          }
        
          System.out.println("Round: " + round); 
          System.out.println("");
           
          }
      }

      System.out.println("Game Over, Thank You For Playing!");

      
      
          }

        public static int user (int userType){
          Random ranNum = new Random();

            int total = 0;
            int count = 0;

            
            total = rollDie(); // calls in the method "rollDie"
            System.out.println("Total: " + total);
              
              if ( total > 11 && userType == 2 ){
                count = 1;
                
              }else if ( total < 10 && userType == 3 ){
                count = 1;
                
              }else if ( total < 8 || total > 12 && userType == 4){
                count = 1;
              }
       
        return count; // returns the value of the variable "count", also known "multiple" in method "wallet", from this method to anywhere asked for
       }

          
        public static double wallet( double betpoint , double multiple , double avpoints ){
          
         
          
          avpoints = avpoints-betpoint; // takes away points if bet lost
          double gain=  betpoint * multiple; // calculates the amount of points the user gains
          avpoints = avpoints + gain; // adds point if bet won
          System.out.println("You won " + gain + " points");
          System.out.println("You now have " + avpoints + " points");
          System.out.println("");

          
        return avpoints; // returns the value of the variable "avpoints", also known as "points" in other methods, from this method to anywhere asked for
        }

        public static int rollDie(){

          
          Random ranNum = new Random();// creates a random number generator
          int randomNumber1 = 0;
          int total1 = 0;
          
        
          for (int i = 0; i < 3; i++) {
              randomNumber1 = ranNum.nextInt(6) +1; // assigns random numbers to the integer from 1-6
              ArrayList diceList1 = new ArrayList(); // // creates a new ArrayList
              diceList1.add(randomNumber1); // adds variable "randomNumber" to the ArrayList named "diceList"
              System.out.println(diceList1);
              total1 = total1 + randomNumber1;
 
        }
          
        return total1; // returns the value of the variable "avpoints" from this method to anywhere asked for
        

          }
  
        public static void rules(){

          System.out.println("Welcome to the dice game of the century! Bucket of Luck is played with three standard dice that are kept in a device shaped somewhat like an hourglass that resembles a wire-frame bird cage and pivots about its center. The dealer rotates the cage end over end, with the dice landing on the bottom. \n ");


          System.out.println("Wagers are placed based on possible combinations that can appear on the three dice. See the following table for how the payouts work: \n ");


          System.out.println("Single Die Bet : Betting how many of a given roll will appear. The payout for this bet is 1 to 1 if one die, 2 to 1 if two dice and 10 to 1 if three dice are involed. \n ");

          
          System.out.println("'Over 11' : To win this bet the sum of all your dice has to be over 11. The payout for this bet is 1 to 1. \n ");


          System.out.println("'Less than 10' : The sum of all your dice has to be less than 10 if you want to win this bet. The payout for this bet is also 1 to 1. \n ");


          System.out.println("'Outside 8-12' : The total of the dice should be outside the range of 8 to 12 (inclusive) in order to win. Meaning less than 8 or greater than 12. The payout for this bet is the same as the last two, 1 to 1. \n ");

          System.out.println("Now that we know all the rules, lets begin the game! \n ");

          
        }


    }

