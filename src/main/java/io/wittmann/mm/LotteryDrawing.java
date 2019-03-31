package io.wittmann.mm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class that represents both a random lottery drawing and a single drawing selected
 * by Millie.
 */
public class LotteryDrawing {

    private static int[] frequencies = new int[43];
    private static int numJackpots = 0;

    private ArrayList<Integer> numbers = new ArrayList<>();
    private int megaball;

    /**
     * Create a random lottery drawing by picking 6+1 numbers randomly.
     */
    public LotteryDrawing() {
        // First, create a collection of numbers to draw from (equivalent of the ping pong balls)
        List<Integer> balls = new ArrayList<>(43);
        for (int number = 1; number <= 42; number++) {
            balls.add(number);
        }
        // Now draw 6 balls from that collection (at random)
        for (int pick = 0; pick < 6; pick++) {
            int position = (int) Math.floor(new Double(balls.size()) * Math.random());
            numbers.add(balls.remove(position));
        }
        // And now pick the megaball
        int position = (int) Math.floor(new Double(balls.size()) * Math.random());
        this.megaball = balls.remove(position);
        updateFrequences(this);
    }

    /**
     * Create a drawing from a set of numbers (and a megaball).
     */
    public LotteryDrawing(int num1, int num2, int num3, int num4, int num5, int num6, int megaball) {
        this.numbers.add(num1);
        this.numbers.add(num2);
        this.numbers.add(num3);
        this.numbers.add(num4);
        this.numbers.add(num5);
        this.numbers.add(num6);
        this.megaball = megaball;
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }

    public int getMegaBall() {
        return this.megaball;
    }

    /**
     * Override the toString() method to output the drawing as "N1, N2, N3, N4, N5, N6  Mega: MB"
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        this.getNumbers().forEach( number -> {
            builder.append(number).append(", ");
        });
        builder.deleteCharAt(builder.length() - 2); // Remove the comma from the last number
        builder.append(" Mega: ").append(this.megaball);
        return builder.toString();
    }

    /**
     * Checks whether the given drawing is a winning drawing compared to this (presumably) generated drawing.
     */
    public boolean checkWinning(LotteryDrawing drawing) {
        // Check if the numbers in the two drawings are the same (irrespective of ordering).  To do this,
        // we must first sort both sets of numbers so that we can compare them in order.
        Integer[] thisDrawing = this.getNumbers().toArray(new Integer[this.getNumbers().size()]);
        Integer[] millieDrawing = drawing.getNumbers().toArray(new Integer[this.getNumbers().size()]);
        Arrays.sort(thisDrawing);
        Arrays.sort(millieDrawing);
        boolean winner = Arrays.equals(thisDrawing, millieDrawing);
        if (winner) {
            this.numJackpots++;
        }
        return winner;
    }

    public int getJackpotsWon() {
        return LotteryDrawing.numJackpots;
    }

    /**
     * Print the accumulated number/ball frequencies accumulated thus far.
     */
    public void printFrequences() {
        for (int num = 1; num <= 42; num++) {
            int frequency = LotteryDrawing.frequencies[num-1];
            System.out.println("Pick " + num + " :: " + frequency);
        }
    }

    /**
     * Updates the lottery number/ball frequencies.  This basically increments the total
     * for each number found in the drawing.
     */
    private static void updateFrequences(LotteryDrawing drawing) {
        // Increment the frequency for each number in the drawing.
        drawing.getNumbers().forEach( number -> {
            LotteryDrawing.frequencies[number-1]++;
        });
        // And now also increment the frequency for the megaball number
        LotteryDrawing.frequencies[drawing.getMegaBall()-1]++;
    }

}