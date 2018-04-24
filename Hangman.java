// Name: Yuhan Cui
// Email: cuiyuhan@brandeis.edu
// Cosi 11A 2017 Fall Section 1
// Date: 12 Nov 2017
// PA 8 - This program plays hangman
// Bugs: None
import java.util.*;//to use scanner and Random
public class Problem3{
  public static void main(String[] args){
    Scanner console=new Scanner(System.in);
    System.out.println("How many numbers are there in the bids array?");//prompts
    int length=console.nextInt();//to get the length of the Array in order to create the Array
    int[] bids=new int[length];//create array
    for(int i=0; i<length; i++){
      System.out.println("The number "+i+":");//prompts
      bids[i]=console.nextInt();//user input numbers in the array
    }
    int price=280;
    int result=priceIsRight(bids,price);
    System.out.println("The closest bid to the price is:" +result);//print the result
  }
  public static int priceIsRight(int[] bids,int price){
    int differnce;
    int bidMax=0;
    int count=0;
    for(int i=0; i<bids.length; i++){//this for loop tells if the bid is higher than price
      if(bids[i]<=price){
        count++;
        if(bidMax<bids[i]){
          bidMax=bids[i];//this record the highest bid below real price
        }
      }
    }
    if(count>0){
      return bidMax;
    }
    return -1;//if all bid are higher than price
  }
}
