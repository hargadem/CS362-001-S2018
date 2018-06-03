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
//	assertEquals(23, newday1.getDay());
	String today = newday1.toString();
	assertEquals(today, newday1.toString());	
	String info = newday1.getFullInfomrationApp(newday1);
	assertEquals(info, newday1.getFullInfomrationApp(newday1));
}
    @Test(timeout = 4000)
    public void test02()  throws Throwable  {
        GregorianCalendar cal = new GregorianCalendar();
        CalDay newday2 = new CalDay(cal);
        Appt appt1 = new Appt(0,0,0,0,0,"mytitle","mydescription","myemail");
        Appt appt2 = new Appt(61,24,1,1,1,"title2","description2","email2");
        Appt appt3 = new Appt(-1,-1,-1,-1,-1,"title2","description2","email2");
        Appt appt4 = new Appt(-1,-1,-1,"title","d","email");
        Appt nullappt = new Appt(0,0,0,null,null,null);
        newday2.addAppt(appt2);
        assertEquals(1, newday2.getSizeAppts());
        newday2.addAppt(appt1);
        newday2.addAppt(appt3);
        newday2.addAppt(appt1);
        newday2.addAppt(appt2);
        newday2.addAppt(appt4);
        appt1.setValid();
        String string1 = newday2.getFullInfomrationApp(newday2);
    }

}
