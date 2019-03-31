# Megamillions Project

Millie Honaire is very superstitious about playing the lottery.  She never misses a drawing and she always plays the same numbers: 4, 8, 15, 16, 23, 42, with a megaball value of 30.  However, her local megamillions lottery is moving from a ping-pong ball drawing to a computer-generated number drawing.  She knows that numbers picked by a computer are pseudo-random so she decides to make a computer program herself to simulate a year’s worth of drawings. 

Here are some facts about the megamillions lottery that you will need to know for this project:
* Drawings occur twice a week (on Wednesday and Saturday).  There are, of course, 52 weeks in a year.
* There are 42 possible numbers: 1 through 42 inclusively.  Every number can be selected only once, as each is removed from the pool once drawn.
* There are 6 normal balls drawn and a 7th bonus number (the Megaball!). The megaball is drawn from the same pool as the other 6 balls.  
* Some winnings rely on the megaball number being correct and some do not.  To win the jackpot you need only match the 6 main numbers in any order.

## Program requirements

1) Millie will enter her 6 chosen numbers 4-8-15-16-23-42 followed by the megaball number of 30 on the keyboard after being prompted. The simulation will test this set of numbers against a year’s worth of computer-generated picks.

2) For each lottery drawing, the computer must randomly pick and display an initial 6 numbers followed by the 7th megaball number. When printed, the 7th number should be identified as being the megaball number.  

3) After each drawing your simulation should **print** the seven lottery numbers and a message that Millie won or did not win the jackpot.  After each drawing your simulation should **calculate** a running total of how many jackpots Millie has won and how frequently each of her numbers showed up.

4) At the “end of the year” your simulation should **print** the total number of jackpots won (if none, just print 0) and the frequency of each of Millie’s numbers.

5) Your simulation should use two classes: a tester and a lottery drawing simulator. The tester class get Millie’s choice, loops through a year’s worth of lottery drawings and prints the resulting statistics. The lottery drawing class should have a constructor that creates the random lottery drawing (without duplicates) when the class is instantiated, storing the numbers in private ArrayList. Class data should also include a private static array of ints as frequencies counting (at least) Millie’s choices, and private static counter for the number of jackpots won. The methods for the lottery drawing class include: a method to update the frequencies, a method test for winning, static method(s) to print the static data that records the frequency of winning, and override the toString method to print the ArrayList and identify the bonus number. Be sure that the bonus number can be viewed and tested separately from the first 6 numbers since it’s not included in the big jackpot winnings.

6) Use Math.random for all number generation, and use an ArrayList for both the lottery drawings and Millie’s choices. (Yes, I know you might want to generate a random INT, but the AP Test ONLY uses Math.random and I would like you to practice it here) Your ArrayList needs to specify an appropriate data type. You must also use one "regular" integer array to accumulate/count frequencies of the Millie’s numbers throughout the year. It should use **multiple methods**.

## Update Options - Select one
_Update 1_: **EASY** -  Lotteries now have an EasyPick option, where the computer generates your numbers.  Let your simulation include this choice for Millie. Display these number after they’ve been generated.  (You’ll still need to avoid duplicates)

_Update 2_: **COMPLEX** - Show and count each win by category for the test set of numbers and key a total of money won  For example, matching exactly 3 numbers (out of the 42 possible), without the megaball, qualifies for a free ticket!  So, at the “end of the year” you would print out the number of jackpots won, the number of free tickets won, and the amount of money won.  
As you’re printing out the year’s worth of drawings you should indicate **any** winner.
The ways to win are listed below.

| **_Requirement_**     | **_Winnings_** |
|-----------------------|--------------|
| 6 Numbers             | JACKPOT      |
| 5 numbers + megaball  | $10,000      |
| 5 numbers             | $1,000       |
| 4 numbers + megaball  | $50          |
| 4 numbers             | $40          |
| 3 numbers + megaball  | $5           |
| 2 numbers + megaball  | $2           |
| 3 numbers             | Free Ticket! |
