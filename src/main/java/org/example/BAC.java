/*
 *  UCF COP3330 Fall 2021 BAC Class file
 *  Copyright 2021 Celina Alzenor
 */

package org.example;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BAC
{
    private final int choice;
    private final int ounces;
    private final int weight;
    private final int hoursPast;

    public BAC()
    {
        Scanner input =  new Scanner(System.in);

        //asks user for their sex
        System.out.print("Enter 1 if you are a male or a 2 if you are a female: ");
        this.choice = input.nextInt();

        //asks for the amount of alcohol they had in ounces
        System.out.print("How many ounces of alcohol did you have? ");
        this.ounces = input.nextInt();

        //asks user for their weight in pounds
        System.out.print("What is your weight, in pounds? ");
        this.weight = input.nextInt();

        //asks for how many hours its been since they had their last drink
        System.out.print("How many hours has it been since your last drink? ");
        this.hoursPast = input.nextInt();
    }

    public void Sobriety()
    {
        //if user is a male
        if(this.choice == 1)
        {
            //for formatting
            DecimalFormat round = new DecimalFormat("###.######");

            //calculates blood alcohol content
            double BAC = (this.ounces * 5.14 / this.weight * .73) - .015 * this.hoursPast;

            System.out.println("\nYour BAC is "+round.format(BAC));

            //if user's BAC is within the legal limit
            if(BAC < 0.08)
            {
                System.out.print("It is legal for you to drive.");
            }

            //if it's not within the legal limit
            else
            {
                System.out.print("It is not legal for you to drive.");
            }

        }

        //if user is a female
        if(this.choice == 2)
        {
            double BAC = (this.ounces * 5.14 / this.weight * .66) - .015 * this.hoursPast;

            DecimalFormat round = new DecimalFormat("###.######");

            System.out.println("\nYour BAC is "+round.format(BAC));

            //if user's BAC is within the legal limit
            if(BAC < 0.08)
            {
                System.out.print("It is legal for you to drive.");
            }

            //if it's not within the legal limit
            else
            {
                System.out.print("It is not legal for you to drive.");
            }

        }
    }
}
