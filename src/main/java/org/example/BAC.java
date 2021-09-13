/*
 *  UCF COP3330 Fall 2021 BAC Class file
 *  Copyright 2021 Celina Alzenor
 */

package org.example;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BAC
{
    private int choice;
    private  int ounces;
    private  int weight;
    private  int hoursPast;

    public BAC()
    {
        Scanner input =  new Scanner(System.in);
        boolean flag = false;

        //question will be asked as long as the flag has not been raised
        while(!flag)
        {
            //asks user for their sex
            System.out.print("Enter 1 if you are a male or a 2 if you are a female: ");

            //if user inputs a numeric value...
            if(input.hasNextInt())
            {
                this.choice = input.nextInt();

                //if it is a value inputted is appropriate
                if(this.choice == 1 || this.choice == 2)
                {
                    //input is valid, raise the flag
                    flag = true;
                }

                //if it's not one or 2
                else
                {
                    //prompt user to enter input again
                    System.out.print("Not a valid input. Please try again!\n");
                }

            }

            //if user inputs a non-numeric value
            else
            {
                System.out.print("Not a valid input. Please try again!\n");
            }

            input.nextLine();
        }


        //reset flag for the next question
        flag = false;
        while(!flag)
        {
            //asks for the amount of alcohol they had in ounces
            System.out.print("How many ounces of alcohol did you have? ");
            if(input.hasNextInt())
            {
                this.ounces = input.nextInt();
                flag = true;
            }
            else
            {
                System.out.print("Not a valid input. Please try again!\n");
            }

            input.nextLine();
        }
        //asks user for their weight in pounds
        flag = false;
        while(!flag)
        {
            System.out.print("What is your weight, in pounds? ");
            if(input.hasNextInt())
            {
                this.weight = input.nextInt();
                flag = true;
            }
            else
            {
                System.out.print("Not a valid input. Please try again!\n");
            }

            input.nextLine();
        }

        flag = false;
        while(!flag)
        {
            //asks for how many hours it's been since they had their last drink
            System.out.print("How many hours has it been since your last drink? ");
            if(input.hasNextInt())
            {
                this.hoursPast = input.nextInt();
                flag = true;
            }

            else
            {
                System.out.print("Not a valid input. Please try again!\n");
            }

            input.nextLine();
        }

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
