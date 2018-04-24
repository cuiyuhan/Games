// Name: Yuhan Cui
// Email: cuiyuhan@brandeis.edu
// Cosi 11A 2017 Fall Section 1
// Date: 7 Dec 2017
// PA 10 - this Program plays card games
// Bugs: None
import java.util.*;
public class Casino{
  public static void main(String[] args){
    int money=100;//starting money
    System.out.println("Welcome to Antonella's Cyber Casino! You got "+money+" to start.");
    betting(money);
  }
  public static void betting(int money){
    Scanner console=new Scanner(System.in);
    int bet;//define the bet before do-while loop
    do{
      System.out.println("How much do you want to bet?(integer number required)");//prompt
      bet=console.nextInt();
      if(money<bet){//
        System.out.println("You don't have enough money for this bet. Please try again.");
      }else{
        System.out.println("Good luck!");
      }
    }while(money<bet);//keep looping if bet is more than money
    warGame(bet, money);//calls the game method
  }
  public static void warGame(int bet, int money){
    Deck casinoDeck=new Deck();
    Scanner console=new Scanner(System.in);
    Card user=casinoDeck.drawNextCard();//the user's card
    casinoDeck.discardPile(user);//discard it
    Card computer=casinoDeck.drawNextCard();//the computer's card
    casinoDeck.discardPile(computer);//discard it
    System.out.println("Your card is: "+user+" computer's card is: "+computer);
    int valueU=user.getValue();//get the value of two cards
    int valueC=computer.getValue();
    if(valueU>valueC){//if you win
      money+=bet;
      System.out.println("You win! Your current balance is: "+money);
    }else if(valueU<valueC){//if you lose
      money-=bet;
      System.out.println("You lose. Your current balence is: "+money);
    }else{//if its a tie
      System.out.println("It's a tie. Your current balance is: "+money);
    }
    if(money<1){//if running out og money
      System.out.println("Sorry, you are running out of money. See you next time.");
    }else{
      System.out.println("Do you want another bet?(Enter \"yes\" or \"no\")");
      String next=console.next();
      if(next.equals("yes")){//ask if user wants to quit gaming 
        betting(money);
      }else{
        System.out.println("See you next time!");
      }
    }
  }
}
