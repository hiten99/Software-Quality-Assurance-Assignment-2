package edu.iupui.cs.cs450;

import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TimeTest
{

  /*
  * Testcase Function for GetCurrentTime()
  */

  @Test
  public void testGetCurrentTime()
  {
     Time t1=Time.getCurrentTime();
     Time t2=Time.getCurrentTime();

    Assert.assertEquals (t1.getNanosecs(), t2.getNanosecs());
    Assert.assertEquals (t1.getSeconds(),t2.getSeconds());
  }

  /*
  *  Testcase Function for Time constructor with one long parameter
  */

  @Test
  public void testTimelong()
  {
    Time t1=new Time(360000);
    Assert.assertEquals (6,t1.convert(TimeUnit.MINUTES));
  }


  /*
  *  Testcase Function for Time constructor with two int paramenters
  */

  @Test
  public void testTime()
  {
    Time t1=new Time(5,6);
    Assert.assertEquals (5, t1.getSeconds ());
    Assert.assertEquals (6, t1.getNanosecs ());
  }

  /*
  *  Testcase Function for Time default constructor
  */

  @Test
  public void testConstructor ()
  {
    Time t = new Time ();

    Assert.assertEquals (0, t.getSeconds ());
    Assert.assertEquals (0, t.getNanosecs ());
  }

  /*
  *  Testcase Function for SetSeconds function
  */

  @Test
  public void testSetSeconds()
  {
    Time t1= new Time(4);
    t1.setSeconds(7);
    Assert.assertEquals (7,t1.getSeconds() );
  }


  /*
  *  Testcase Function for SetNanoSeconds function
  */

  @Test
  public void testSetNanoSeconds()
  {
    Time t1= new Time(4);
    t1.setNanosecs(5);
    Assert.assertEquals (5,t1.getNanosecs());
  }

  /*
  *  Testcase Function for Convert function
  */

  @Test
  public void testConvert()
  {
    Time t1 = new Time(360,0);
    Assert.assertEquals (6,t1.convert(TimeUnit.MINUTES));
  }

  /*
  *  Testcase Function for isAfter function
  */

  @Test
  public void testIsAfter()
  {
    Time t1 = new Time (7,9);
    Time t2 = new Time (5,6);
    Time t3 = new Time (5,6);
    Time t4 = new Time (5,6);
    Time t5 = new Time (5,6);
    Time t6 = new Time (7,6);
    Time t7 = new Time (5,6);
    Time t8 = new Time (5,7);

    Assert.assertEquals (true, t1.isAfter(t2));
    Assert.assertEquals (true, t8.isAfter(t7));
    Assert.assertEquals (false, t5.isAfter(t6));
    Assert.assertEquals (false, t3.isAfter(t4));

  }

  /*
  *  Testcase Function for isAfterOrEquals function
  */

  @Test
  public void testIsAfterOrEquals()
  {
    Time t1 = new Time (7,9);
    Time t2 = new Time (5,6);
    Time t3 = new Time (5,6);
    Time t4 = new Time (5,6);
    Time t5 = new Time (5,6);
    Time t6 = new Time (7,6);
    Time t7 = new Time (5,6);
    Time t8 = new Time (5,7);

    Assert.assertEquals (true, t1.isAfterOrEqual(t2));
    Assert.assertEquals (true, t8.isAfterOrEqual(t7));
    Assert.assertEquals (false, t5.isAfterOrEqual(t6));
    Assert.assertEquals (true, t3.isAfterOrEqual(t4));
    Assert.assertEquals (false, t7.isAfterOrEqual(t8));


  }

  /*
  *  Testcase Function for isBefore function
  */

  @Test
  public void testIsBefore()
  {
    Time t1 = new Time (7,9);
    Time t2 = new Time (5,6);
    Time t3 = new Time (5,6);
    Time t4 = new Time (5,6);
    Time t5 = new Time (5,6);
    Time t6 = new Time (7,6);
    Time t7 = new Time (5,6);
    Time t8 = new Time (5,7);

    Assert.assertEquals (true, t2.isBefore(t1));
    Assert.assertEquals (true, t7.isBefore(t8));
    Assert.assertEquals (false, t6.isBefore(t5));
    Assert.assertEquals (false, t3.isBefore(t4));

  }

  /*
  *  Testcase Function for isBeforeOrEquals function
  */

  @Test
  public void testIsBeforeOrEquals()
  {
    Time t1 = new Time (7,9);
    Time t2 = new Time (5,6);
    Time t3 = new Time (5,6);
    Time t4 = new Time (5,6);
    Time t5 = new Time (5,6);
    Time t6 = new Time (7,6);
    Time t7 = new Time (5,6);
    Time t8 = new Time (5,7);

    Assert.assertEquals (true, t2.isBeforeOrEqual(t1));
    Assert.assertEquals (true, t7.isBeforeOrEqual(t8));
    Assert.assertEquals (false, t6.isBeforeOrEqual(t5));
    Assert.assertEquals (true, t3.isBeforeOrEqual(t4));
    Assert.assertEquals (false, t8.isBeforeOrEqual(t7));

  }

  /*
  *  Testcase Function for isEqual function
  */

  @Test
  public void testIsEquals()
   {
    Time t1 = new Time (7,9);
    Time t2 = new Time (5,6);
    Time t3 = new Time (5,6);
    Time t4 = new Time (5,6);
    Time t5 = new Time (5,6);
    Time t6 = new Time (7,6);
    Time t7 = new Time (5,6);
    Time t8 = new Time (5,7);
    Assert.assertEquals (false, t2.isEqual(t1));
    Assert.assertEquals (false, t6.isEqual(t5));
    Assert.assertEquals (true, t3.isEqual(t4));
    Assert.assertEquals (false, t7.isEqual(t8));
  }

  /*
  *  Testcase Function for toDate function
  */

  @Test
  public void testToDate()
  {
    Time t1 = new Time(360,0);
    Date a= new Date(360000);
    Assert.assertEquals (a,t1.toDate());
  }

  /*
  *  Testcase Function for equals function
  */

  @Test
  public void testEquals()
  {
    Time t1 = new Time (7,9);
    Time t2 = new Time (5,6);
    Time t3 = new Time (5,6);
    Time t4 = new Time (5,6);
    Time t5 = new Time (5,6);
    Time t6 = new Time (7,6);
    Time t7 = new Time (5,6);
    Time t8 = new Time (5,7);
    ArrayList t9= new ArrayList();
    Assert.assertEquals (true, t3.equals(t4));
    Assert.assertEquals (false, t4.equals(t9));
    Assert.assertEquals (false, t9.equals(t4));
    Assert.assertEquals (false, t1.equals(t2));
    Assert.assertEquals (false, t6.equals(t7));
    Assert.assertEquals (true, t7.equals(t7));

  }

  /*
  *  Testcase Function for toString function
  */

  @Test
  public void testToString()
  {
    Time t1 = new Time(360,0);
    Assert.assertEquals ("7:06:00 PM",t1.toString());
  }
}
