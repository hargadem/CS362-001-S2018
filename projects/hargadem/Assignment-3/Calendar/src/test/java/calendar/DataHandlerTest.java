
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.*;


public class DataHandlerTest{
    
  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	DataHandler handle0 = new DataHandler();
	GregorianCalendar day1 = new GregorianCalendar();
	GregorianCalendar day2 = new GregorianCalendar();
	day1.set(GregorianCalendar.MONTH,-1);
	assertNotNull(handle0.getApptRange(day1, day2));
  }
    
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	DataHandler handle1 = new DataHandler("file1.xml");
	Appt invalidappt = new Appt(-1,1,2018,"Invalid Appt","invalid","myemail");
	invalidappt.setValid();
	assertFalse(handle1.saveAppt(invalidappt));
	assertFalse(handle1.deleteAppt(invalidappt));
  }

  @Test(timeout = 4000)
  public void test02() throws Throwable	{
	Appt newappt = new Appt(-1,-1,-1,"New Appt","test appt","myemail");
	DataHandler handle2 = new DataHandler("file2.xml", false);
      DataHandler handle3 = new DataHandler("file3.xml", true);
	assertTrue(handle2.save());
	assertTrue(handle2.saveAppt(newappt));
      assertTrue(handle2.saveAppt(newappt));
	assertTrue(handle2.deleteAppt(newappt));
      assertFalse(handle3.deleteAppt(newappt));
     newappt.setValid();
      assertFalse(handle2.saveAppt(newappt));
      assertFalse(handle3.saveAppt(newappt));
      
  }
  
    @Test
    public void test03()    throws Throwable    {
        DataHandler handle = new DataHandler();
        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(new Appt(5, 30, 1, 5, 2018, "Birthday", "Birthday Party","email"));
        appts.add(new Appt(4, 30, 1, 4, 2018, "Work", "My Shift","email"));
        
        List<CalDay> calDayTest;
        calDayTest = handle.getApptRange(new GregorianCalendar(2017, 4, 28, 14, 30, 0),
                                            new GregorianCalendar(2017, 4, 31, 19, 30, 0));
        
        assertTrue(calDayTest.get(0).getSizeAppts() == 0);
    }
  
 
}
