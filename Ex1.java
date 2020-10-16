package War;

import java.util.Scanner;
import java.util.Stack;

public class Ex1 implements War {
    private static Stack<Integer> reverse(Stack<Integer> deck) {
        Stack<Integer> newDeck = new Stack<>();
        while(!deck.empty()) {
            newDeck.push(deck.pop());
        }
        return newDeck;
    }

    private static Stack<Integer> add(Stack<Integer> deck, int t1, int t2) {
        deck = reverse(deck);
        deck.push(t1);
        deck.push(t2);
        return reverse(deck);
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Stack<Integer> deck1 = new Stack<>();
        for(int i = 0; i < nCardsInDeck; i++) {
            deck1.push(console.nextInt());
        }
        deck1 = reverse(deck1);
        Stack<Integer> deck2 = new Stack<>();
        for(int i = 0; i < nCardsInDeck; i++) {
            deck2.push(console.nextInt());
        }
        deck2 = reverse(deck2);
        int i, t1, t2;
        for(i = 0; i < maxNMoves && !deck1.empty() && !deck2.empty(); i++) {
            t1 = deck1.pop();
            t2 = deck2.pop();
            if((t1 > t2 || (t1 == 0 && t2 == maxCardValue)) &&
                    (t1 != maxCardValue || t2 != 0))
                deck1 = add(deck1, t1, t2);
            else
                deck2 = add(deck2, t2, t1);
        }
        if(i == maxNMoves)
            System.out.println("botva");
        else
            System.out.println((deck1.empty() ? "second" : "first") + ' ' + i);
    }
}