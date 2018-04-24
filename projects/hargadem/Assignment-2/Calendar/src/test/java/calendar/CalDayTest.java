/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.Calendar;
import java.util.GregorianCalendar; 

public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	CalDay newday0 = new CalDay();
	assertFalse(newday0.isValid());
	assertEquals(null, newday0.iterator());
	 
  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	GregorianCalendar cal = new GregorianCalendar();
	CalDay newday1 = new CalDay(cal);
	assertTrue(newday1.isValid());
	assertEquals(0, newday1.getSizeAppts());
	assertEquals(2018, newday1.getYear());
//	assertEquals(4, newday1.getMonth());
	assertEquals(23, newday1.getDay());
	String today = newday1.toString();
	assertEquals(today, newday1.toString());	
	String info = newday1.getFullInfomrationApp(newday1);
	assertEquals(info, newday1.getFullInfomrationApp(newday1));
	 
}

}
