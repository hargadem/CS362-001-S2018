
package finalprojectB;

import junit.framework.TestCase;
import java.util.Random;
import java.io.*;
import java.util.Calendar;


//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing
       String[] schemes = {"HTTP", "HTTPS"};
       UrlValidator urlVal = new UrlValidator(schemes);
       
       String invalid1 = null;
       String invalid2 = "not good";
       String invalid3 = "com.google.www";
       String invalid4 = "google.com.http://";
       String invalid5 = "^@$&#.com";
       
       String valid1 = "HTTP://www.google.com";
       String valid2 = "www.website.org";
       String valid3 = "https://www.aaa.net:80";
       String valid4 = "http://255.255.255.255";
       String valid5 = "file:./hello.txt";
    
       assertTrue(urlVal.isValid(valid2));
       assertTrue(urlVal.isValid(valid1));
       assertTrue(urlVal.isValid(valid3));
       assertTrue(urlVal.isValid(valid4));
       assertTrue(urlVal.isValid(valid5));
       
       assertFalse(urlVal.isValid(invalid1));
       assertFalse(urlVal.isValid(invalid2));
       assertFalse(urlVal.isValid(invalid3));
       assertFalse(urlVal.isValid(invalid4));
       assertFalse(urlVal.isValid(invalid5));

      

   }

   
   public void testYourFirstPartition()
   {
        //tests valid URL combinations
       UrlValidator urlVal = new UrlValidator();

       String[] validScheme = {"http://","https://","ftp://","h3t://",""};
       String[] validAuthority = {"www.google.com","go.com","go.au","0.0.0.0","255.255.255.255","255.com"};
       String[] validPort = {":80",":65535",":0",""};
       String[] validPath = {"/test1","/t123","/$23","/test1/","/test1/file"};
       
       Random rand = new Random();
       
       for (int i=0;i<20;i++)
       {
           //generate random index for each string array
           int schemeNum = rand.nextInt(5);
           int authorityNum = rand.nextInt(6);
           int portNum = rand.nextInt(4);
           int pathNum = rand.nextInt(5);
           
           String validURL = new String();
           validURL += validScheme[schemeNum];
           validURL += validAuthority[authorityNum];
           validURL += validPort[portNum];
           validURL += validPath[pathNum];
    
           assertTrue(urlVal.isValid(validURL));
       }
   }
   
   public void testYourSecondPartition(){
		 //tests invalid URL combinations
       UrlValidator urlVal = new UrlValidator();
       
       String[] invalidScheme = {"http:/","http:","http/","3ht://","://"};
       String[] invalidAuthority = {"256.256.256.256","1.2.3.4.5","1.2.3.4.","1.2.3",".1.2.3.4",""};
       String[] invalidPort = {":-1",":65636",":65a"};
       String[] invalidPath = {"/..//file","/test1//file","/.."};
       
       Random rand = new Random();
       
       for (int i=0;i<20;i++)
       {
           //generate random index for each string array
           int schemeNum = rand.nextInt(5);
           int authorityNum = rand.nextInt(6);
           int portNum = rand.nextInt(3);
           int pathNum = rand.nextInt(3);
           
           String invalidURL = new String();
           invalidURL += invalidScheme[schemeNum];
           invalidURL += invalidAuthority[authorityNum];
           invalidURL += invalidPort[portNum];
           invalidURL += invalidPath[pathNum];
           
           assertFalse(urlVal.isValid(invalidURL));
       }
   }
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing
       
       long TestTimeout = 60*500*1; //timeout at 30 sec
       int NUM_TESTS = 100;
       
       Random rand = new Random();
       UrlValidator urlVal = new UrlValidator();

    
           long startTime = Calendar.getInstance().getTimeInMillis();
           long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
           
           try{
               for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                   
                   String[] schemeArray = {"http://","https://","ftp://","h3t://","","http:/","http:","http/","3ht://","://"};
                   String[] authorityArray = {"www.google.com","go.com","go.au","0.0.0.0","255.255.255.255","255.com","256.256.256.256","1.2.3.4.5","1.2.3.4.","1.2.3",".1.2.3.4",""};
                   String[] portArray = {":80",":65535",":0","",":-1",":65636",":65a"};
                   String[] pathArray = {"/test1","/t123","/$23","/test1/","/test1/file","/..//file","/test1//file","/.."};
                   
                   //true or false matching arrays above
                   boolean[] schemeBools = {true,true,true,true,true,false,false,false,false,false};
                   boolean[] authorityBools = {true,true,true,true,true,true,false,false,false,false,false,false};
                   boolean[] portBools = {true,true,true,true,false,false,false};
                   boolean[] pathBools = {true,true,true,true,true,false,false,false};
                   
                   int schemeNum = rand.nextInt(10);
                   int authorityNum = rand.nextInt(12);
                   int portNum = rand.nextInt(7);
                   int pathNum = rand.nextInt(8);
                   
                   boolean expected = true;
                   
                   if (schemeBools[schemeNum] == false)
                       expected = false;
                   else if (authorityBools[authorityNum] == false)
                       expected = false;
                   else if (portBools[portNum] == false)
                       expected = false;
                   else if (pathBools[pathNum] == false)
                       expected = false;
                   
                   String testURL = new String();
                   testURL += schemeArray[schemeNum];
                   testURL += authorityArray[authorityNum];
                   testURL += portArray[portNum];
                   testURL += pathArray[pathNum];
                   
                   assertEquals(expected, urlVal.isValid(testURL));
                   
                   elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                   if((iteration%10000)==0 && iteration!=0 )
                       System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
                   
               }
           }
           catch(NullPointerException e){
           }
       

   }

}


