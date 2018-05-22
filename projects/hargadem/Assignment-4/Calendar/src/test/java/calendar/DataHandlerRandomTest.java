package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	
    
    private static final long TestTimeout = 60 * 500 * 1; // Time out 30 sec
    private static final int NUM_TESTS = 100;
    
    // Generate random Appt to add to LinkedList<Appt>
    public static Appt generateRandomAppt(Random random) {
        int startHour = (int) ValuesGenerator.getRandomIntBetween(random, 0, 26);
        int startMinute = (int) ValuesGenerator.getRandomIntBetween(random, 0, 65);
        int startDay = (int) ValuesGenerator.getRandomIntBetween(random, 0, 35);
        int startMonth = (int) ValuesGenerator.getRandomIntBetween(random, 0, 13);
        int startYear = (int) ValuesGenerator.getRandomIntBetween(random, 2000, 2020);
        String title = "Birthday Party";
        String description = "This is my birthday party.";
        String email = "email@email.com";
        
        Appt appt = new Appt(startHour,
                             startMinute,
                             startDay,
                             startMonth,
                             startYear,
                             title,
                             description,
                             email);
        
        return appt;
    }
    
    /**
     * Generate Random Tests that tests DataHandler Class.
     */
    
   
	 @Test
	  public void radnomtest()  throws Throwable  {
		 
          long startTime = Calendar.getInstance().getTimeInMillis();
          long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
          DataHandler testHandler = new DataHandler();
          
          System.out.println("Start testing...");
          
          long randomseed = 12;
          Random random = new Random(randomseed);
          
        //testing deleteAppt()
          for (int iteration = 0; elapsed < TestTimeout; iteration++) {
              // Create new random from static random
              
              randomseed = ValuesGenerator.getRandomIntBetween(random, 0, 30);
              //System.out.println("Randomseed: "+randomseed);
              random = new Random(randomseed);
              
              LinkedList<Appt> appts;
              int apptsSize = (int) ValuesGenerator.RandInt(random);
              //System.out.println("Appts Size: " + apptsSize);
              
              if(apptsSize != 0) {
                  appts = new LinkedList<Appt>();
                  
                  for(int i = 0; i < apptsSize; i++) {
                      appts.add(generateRandomAppt(random));
                  }
              }
              
              else {
                  appts = null;
              }
              
              testHandler.deleteAppt(generateRandomAppt(random));
              
              // Timing
              elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
              if((iteration%10000)==0 && iteration!=0)
                  System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
		 
	 }
          
          //Testing getApptRange()
          
          //Create two random GregorianCalendar days
          int gregDay1=ValuesGenerator.getRandomIntBetween(random, 1, 31);
          int gregMonth1=ValuesGenerator.getRandomIntBetween(random, 1, 12);
          int gregYear1=ValuesGenerator.getRandomIntBetween(random, -20, 2018);
          GregorianCalendar day1 = new GregorianCalendar(gregYear1, gregMonth1, gregDay1);
          
          int gregDay2=ValuesGenerator.getRandomIntBetween(random, -1, 32);
          int gregMonth2=ValuesGenerator.getRandomIntBetween(random, -1, 13);
          int gregYear2=ValuesGenerator.getRandomIntBetween(random, -20, 2018);
          GregorianCalendar day2 = new GregorianCalendar(gregYear2, gregMonth2, gregDay2);
          
          //LinkedList of CalDays
          LinkedList<CalDay> calDays = new LinkedList<CalDay>();
          
          //Random autosave
          int autosaveNum = ValuesGenerator.getRandomIntBetween(random, 0, 1);
          boolean autosave;
          if(autosaveNum==1)
              autosave = true;
          else
              autosave = false;
          
          //Random DataHandler
          DataHandler handle = new DataHandler("test.txt", autosave);
          
          //get appt range
          try{
              calDays = (LinkedList<CalDay>) handle.getApptRange(day1, day2);
          }catch(DateOutOfRangeException e){
              System.err.println(e.toString());
          }

    }

}
