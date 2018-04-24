// Name: Yuhan Cui
// Email: cuiyuhan@brandeis.edu
// Cosi 11A 2017 Fall Section 1
// Date: 3 Dec 2017
// PA 10 - Card class for casino
// Bugs: None
public class Card{
  private int value;//private values
  private String suit;
  public Card(int value, String suit){//constructor
    this.value=value;
    this.suit=suit;
  }
  public int getValue(){//this gets the private value
    return this.value;
  }
  public String getColor(){//this read the suit and return color
    if(suit.equals("Hearts")||suit.equals("Diamonds")){
      return "red";
    }
    return "black";
  }
  public String getSuit(){//reads the suit
    return this.suit;
  }
  public String toString(){//the returns the value and suit 
    if(value==1){
      return "Ace of "+suit;
    }else if(value==11){
      return "Jack of "+suit;
    }else if(value==12){
      return "Queen of "+suit;
    }else if(value==13){
      return "King of "+suit;
    }
    return value+" of "+suit;
  }
}
