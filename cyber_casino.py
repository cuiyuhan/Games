import itertools
import random

class Card:
    def __init__(self, value, suit):
        self.value=value
        self.suit=suit

    def get_value(self):
        return self.value

    def get_color(self):
        if(suit=="Hearts" or suit=="Diamonds"):
            return "red"
        else:
            return "black"

    def get_suit(self):
        return self.suit

    def __str__(self):
        if self.value==1:
            return "Ace of "+self.suit
        elif self.value==11:
            return "Jack of "+self.suit
        elif self.value==12:
            return "Queen of "+self.suit
        elif self.value==13:
            return "King of "+self.suit
        return str(self.value)+" of "+self.suit

class Deck:
    def __init__(self):
        self.deck = []
        self.discard_pile = []
        self.count=0
        for i in range(54):
            if i < 13:
                next_card = Card(i%13+1, 'Hearts')
                self.deck.append(next_card)
            elif i < 26:
                next_card = Card(i%13+1, 'Diamonds')
                self.deck.append(next_card)
            elif i < 39:
                next_card = Card(i%13+1, 'Spades')
                self.deck.append(next_card)
            else:
                next_card = Card(i%13+1, 'Clubs')
                self.deck.append(next_card)
        self.shuffle()
    def shuffle(self):
        for i in range(0,52-self.count):
            x=random.randint(0,len(self.deck)-1)
            y=random.randint(0,len(self.deck)-1)
            temp=self.deck[y]
            self.deck[y]=self.deck[x]
            self.deck[x]=temp
        self.count=0
    def draw_next_card(self):
        if self.count>51:
            self.deck = discard_pile
            self.discard_pile = []
            self.shuffle()
        card = self.deck.pop(0)
        self.count += 1
        self.discard_pile.append(card)
        return card

class Casino:
    def betting(self,money):
        print("Welcome to Antonella's Cyber Casino! You have $" + str(money) + ".")
        bet=int(raw_input("How much do you want to bet? (integer number required): "))
        if(money>bet):
            print("Bet accepted. Good luck!")
        else:
            print("You don't have enough money for this bet. Please try again.")
        while(money<bet):
            bet=int(raw_input("How much do you want to bet? (integer number required)"))
            if(money<bet):
                print("You don't have enough money for this bet. Please try again.")
            else:
                print("Good luck!")
        self.war_game(bet,money)
    def war_game(self,bet,money):
        casino_deck=Deck()
        user=casino_deck.draw_next_card()
        #print(casino_deck)
        #print(user)
        #casino_deck.discard_pile(user)
        computer=casino_deck.draw_next_card()
        #casino_deck.discard_pile(computer)
        print("Your card is: "+str(user)+" computer's card is: "+str(computer))
        value_user=user.get_value()
        value_computer=computer.get_value()
        if(value_user>value_computer):
            money=money+bet
            print("You win! Your current balance is: $"+str(money))
        elif(value_user<value_computer):
            money=money-bet
            print("You lose. Your current balance is: $"+str(money))
        else:
            print("It's a tie. Your current balance is: $"+str(money))
        if(money<1):
            print("Sorry, you are running out of money. See you next time.")
        else:
            while True:
                next_game=raw_input("Do you want another bet? (Enter \"yes\" or \"no\"): ")
                if (next_game.lower()=='yes'):
                    print("")
                    self.betting(money)
                    return
                elif (next_game.lower()=='no'):
                    print("See you next time!")
                    return
                else:
                    print("Error: Invalid input")

new = Casino()
new.betting(100)
