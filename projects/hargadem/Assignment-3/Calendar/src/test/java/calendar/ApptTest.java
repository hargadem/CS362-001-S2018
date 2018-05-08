/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {
    
    
    int startHour=16;
    int startMinute=15;
    int startDay=7;
    int startMonth=5;
    int startYear=2018;
    String title="Party";
    String description="My birthday party.";
    String email="email@email.com";
    //Construct a new Appointment object with the initial data
    Appt appt = new Appt(startHour,
                         startMinute ,
                         startDay ,
                         startMonth ,
                         startYear ,
                         title,
                         description,
                         email);

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
  }

	@Test(timeout = 4000)
	public void test01()  throws Throwable 
	{
		Appt appt1 = new Appt(22,10,2018,"Work","go to work","myemail@gmail.com");

		assertEquals(0, appt1.getRecurNumber());
		assertTrue(appt1.isOn(22, 10, 2018));
		assertTrue(appt1.getValid());
		assertEquals("myemail@gmail.com",appt1.getEmailAddress());
		assertEquals("go to work", appt1.getDescription());
		assertEquals("Work", appt1.getTitle());
		assertEquals(2018, appt1.getStartYear());
		assertEquals(10, appt1.getStartMonth());
	}
    
    @Test
    public void test07()    throws Throwable {
        appt.setStartMonth(13);
        appt.setStartMonth(12);
        appt.setStartHour(11);
        assertFalse(appt.toString().contains("pm"));
        assertFalse(appt.toString().contains("-1"));
    }
}
    
    


