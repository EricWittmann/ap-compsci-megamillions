package io.wittmann.mm;

import java.util.Scanner;

public class LotterySimulation {

    public static final void main(String [] args) {
        // 1) Ask Millie to enter her numbers
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your lottery picks.");
        System.out.print("Number 1: ");
        int num1 = scanner.nextInt();

        System.out.print("Number 2: ");
        int num2 = scanner.nextInt();

        System.out.print("Number 3: ");
        int num3 = scanner.nextInt();

        System.out.print("Number 4: ");
        int num4 = scanner.nextInt();

        System.out.print("Number 5: ");
        int num5 = scanner.nextInt();

        System.out.print("Number 6: ");
        int num6 = scanner.nextInt();

        System.out.println("---");
        System.out.print("Mega Ball: ");
        int megaball = scanner.nextInt();

        LotteryDrawing millieDrawing = new LotteryDrawing(num1, num2, num3, num4, num5, num6, megaball);

        // 2) Generate 2 drawings per week for a year (104 total lottery drawings) and check if Millie won
        for (int drawingIdx = 0; drawingIdx < 104; drawingIdx++) {
            // Create a new random drawing
            LotteryDrawing drawing = new LotteryDrawing();
            // Check if millie's drawing is a winner
            boolean winner = drawing.checkWinning(millieDrawing);
            System.out.println(
                "  Drawing #" + (drawingIdx+1) + " - " +
                drawing.toString() +
                (winner ? " [!JACKPOT!]" : "")
            );
        }

        // 3) Print an end-of-year summary of the # of jackpots won and the frequency of each of Millie's numbers
        System.out.println("");
        System.out.println("Summary of Results");
        System.out.println("------------------");
        System.out.println("Number Frequencies:");
        LotteryDrawing.printFrequences();
        System.out.println("------------------");
        System.out.println("Jackpots Won: " + millieDrawing.getJackpotsWon());
    }

}