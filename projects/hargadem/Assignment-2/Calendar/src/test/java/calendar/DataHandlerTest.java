
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


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
	Appt newappt = new Appt(23,10,2018,"New Appt","test appt","myemail");
	DataHandler handle2 = new DataHandler("file2.xml", false);
	assertTrue(handle2.save());
	assertTrue(handle2.saveAppt(newappt));
	assertTrue(handle2.deleteAppt(newappt));
 }
}
