package com.drm4d.investment;

import java.util.*;
import java.math.*;

class SystemC
{
  public static int step, startSumm, finalSumm, toDo, currDate, inpTime, again;
  public static float percent;
  
  public void intro()
  {
    step = 0;
    System.out.println("Welcome to Investment!");
    System.out.println("Author is Dr. M4D.");
    System.out.println("To get more, visited DrM4D.github.io");
    System.out.println();
  }
  
  public static int error(int err)
  {
    switch(err)
    {
      case 0:
        System.out.println("Error #00: Nonpositive numer. Please, try again. ");
        break;
      case 1:
        System.out.println("Error #01: Unkown input. Please, try again");
        break;
    }
    
    switch(step)
    {
      case 1:
        SystemC.inputStSm();
        break;
      case 2:
        SystemC.inputPercent();
        break;
      case 3:
        SystemC.getAct();
        break;
      case 4:
        SystemC.inputFnSm();
        break;
      case 5:
        SystemC.inputTime();
        break;
      case 7:
        SystemC.askRestart();
        break;
    }
    
    return 0;
  }
  
  public static int inputStSm()
  {
    Scanner in = new Scanner(System.in);
    step = 1;
    System.out.print("Please, enter the start summ: ");
    startSumm = in.nextInt();
    
    if (startSumm <= 0)
    {
        SystemC.error(0);
    }
    
    System.out.println("");
    return startSumm;
  }
  
  public static float inputPercent()
  {
    Scanner in = new Scanner(System.in);
    step = 2;
    System.out.print("Please, enter the bank's percent: ");
    percent = in.nextFloat();
    
    if (percent <= 0)
    {
      SystemC.error(0);
    }
    
    System.out.println("");
    percent = percent/100 + 1;
    return percent;
  }
  
  public static int getAct()
  {
    Scanner in = new Scanner(System.in);
    step = 3;
    System.out.println("What do you need?");
    System.out.println("Enter 'time' if you need to calculate time to specific summ,");
    System.out.println("or enter 'summ' if you need to calculate final summ from specific time:");
    String answ = in.nextLine();
    if (answ.equalsIgnoreCase("time"))
    {
      toDo = 1;
    } else if (answ.equalsIgnoreCase("summ"))
    {
      toDo = 2;
    } else
    {
      SystemC.error(2);
    }
    
    System.out.println("");
    return toDo;
  }
  
  public static int inputFnSm()
  {
    Scanner in = new Scanner(System.in);
    step = 4;
    System.out.print("Ok. Enter the final summ: ");
    finalSumm = in.nextInt();
    if (finalSumm <= 0)
    {
      SystemC.error(0);
    }
    
    System.out.println("");
    return finalSumm;
  }
  
  public static int inputTime()
  {
    Scanner in = new Scanner(System.in);
    step = 5;
    System.out.print("Ok. Enter the time: ");
    inpTime = in.nextInt();
    if (inpTime <= 0)
    {
      SystemC.error(0);
    }
    
    System.out.println("");
    return inpTime;
  }
  
  public static int calculate()
  {
    step = 6;
    System.out.println("Calculating...");
    System.out.println("");
    
    if (toDo == 1)
    {
      int currSumm = startSumm;
      currDate = 0;
      while (finalSumm > currSumm)
      {
        currSumm = Math.round(currSumm*percent);
        currDate++;
      }
      System.out.println("You will get " + currSumm + " from " + currDate + " years. ");
    }
    
    else 
    {
      int currSumm = startSumm;
      currDate = inpTime;
      while (currDate > 0)
      {
        currSumm = Math.round(currSumm*percent);
        currDate--;
      }
      System.out.println("After " + inpTime + " years you will get " + currSumm);
    }
    
    System.out.println("");
    return 0;
  }
  
  public static int askRestart()
  {
    Scanner in = new Scanner(System.in);
    step = 7;
    System.out.print("Would you like to try again? ");
    String answer = in.nextLine();
    
    if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) again = 1;
    else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) again = 0;
    else
    {
      SystemC.error(1);
    }
    
   if (again == 1) 
   {
     System.out.println("");
     Main.start();
   }
   return 0;
  }
}