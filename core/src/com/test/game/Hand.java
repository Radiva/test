package com.test.game;

import java.util.ArrayList;

/**
 * Created by radiva on 20/10/16.
 */
public class Hand {

    private ArrayList<Kartu> hand;

    public Hand() {
        hand = new ArrayList<Kartu>();
    }

    public void clear() {
        hand.clear();
    }

    public void tbhKartu(Kartu c) {
        if(c == null)
            throw  new NullPointerException("Tidak ada Kartu");
        hand.add(c);
    }

    public void keluarKartu(Kartu c) {
        hand.remove(c);
    }

    public void keluarKartu(int pos) {
        if(pos < 0 || pos >= hand.size())
            throw new IllegalArgumentException("posisi tidak tersedia");
        hand.remove(pos);
    }

    public int jmlHand() {
        return hand.size();
    }

    public Kartu getKartu(int pos) {
        if(pos < 0 || pos >= hand.size())
            throw new IllegalArgumentException("posisi tidak tersedia");
        return hand.get(pos);
    }

    public void sortWarna() {
        ArrayList<Kartu> newHand = new ArrayList<Kartu>();
        while (hand.size() > 0) {
            int pos = 0;  // Position of minimal card.
            Kartu c = hand.get(0);  // Minimal card.
            for (int i = 1; i < hand.size(); i++) {
                Kartu c1 = hand.get(i);
                if ( c1.getWarna() < c.getWarna() || (c1.getWarna() == c.getWarna() && c1.getWarna() < c.getWarna()) ) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }

    public void sortAngka() {
        ArrayList<Kartu> newHand = new ArrayList<Kartu>();
        while (hand.size() > 0) {
            int pos = 0;  // Position of minimal card.
            Kartu c = hand.get(0);  // Minimal card.
            for (int i = 1; i < hand.size(); i++) {
                Kartu c1 = hand.get(i);
                if ( c1.getWarna() < c.getWarna() || (c1.getWarna() == c.getWarna() && c1.getWarna() < c.getWarna()) ) {
                    pos = i;
                    c = c1;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }

}
