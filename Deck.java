// Name: Yuhan Cui
// Email: cuiyuhan@brandeis.edu
// Cosi 11A 2017 Fall Section 1
// Date: 7 Dec 2017
// PA 10 - Deck class for casino
// Bugs: None
import java.util.*;
public class Deck{
  Card[]deck=new Card[52];//creates two array
  Card[]discardPile=new Card[52];
  int count=0;//count how many card has been discarded
  public Deck(){//constructor
    for(int i=1; i<=52;i++){
      if(i<=13){
        Card nextCard=new Card(i%13,"Hearts");
        deck[i-1]=nextCard;
      }else if(i>13 && i<=26){
        Card nextCard=new Card(i%13,"Diamonds");
        deck[i-1]=nextCard;
      }else if(i>26 && i<=39){
        Card nextCard=new Card(i%13,"Spades");
        deck[i-1]=nextCard;
      }else{
        Card nextCard=new Card(i%13,"Clubs");
        deck[i-1]=nextCard;
      }
    }
    shuffle();//calls the shuffle method
  }
  public void shuffle(){
    Random rand=new Random();
    for(int i=0;i<52-count;i++){//shuffle the card and excluding the null
      int x=rand.nextInt(52-count);
      int y=rand.nextInt(52-count);
      Card temp=deck[y];
      deck[y]=deck[x];
      deck[x]=temp;
    }
    count=0;
  }
  public Card drawNextCard(){//this gives you the next card in the array
    if(count>51){
      deck=discardPile;
      discardPile=new Card[52];
      shuffle();
    }
    return deck[count];
  }
  public void discardPile(Card c){//this let you discard a card
    discardPile[count]=c;
    count++;
  }
}
