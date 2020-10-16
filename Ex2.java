package War;

import java.util.Scanner;
import java.util.LinkedList;

public class Ex2 implements War {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedList<Integer> deck1 = new LinkedList<>();
        for(int i = 0; i < nCardsInDeck; i++) {
            deck1.add(console.nextInt());
        }
        LinkedList<Integer> deck2 = new LinkedList<>();
        for(int i = 0; i < nCardsInDeck; i++) {
            deck2.add(console.nextInt());
        }
        int i, t1, t2;
        for(i = 0; i < maxNMoves && deck1.size() != 0 && deck2.size() != 0; i++) {
            t1 = deck1.poll();
            t2 = deck2.poll();
            if((t1 > t2 || (t1 == 0 && t2 == maxCardValue)) &&
                    (t1 != maxCardValue || t2 != 0)) {
                deck1.add(t1);
                deck1.add(t2);
            }
            else {
                deck2.add(t2);
                deck2.add(t1);
            }
        }
        if(i == maxNMoves)
            System.out.println("botva");
        else
            System.out.println(
                    (deck1.size() == 0 ? "second" : "first") + ' ' + i);
    }
}