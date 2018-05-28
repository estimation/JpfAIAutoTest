package org.jpf.aitest.sample;

import static org.junit.Assert.fail;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.jpf.aitest.runtime.WriteException.WritePrivateException;
import java.util.Vector;

/**
* The class <code>SampleExceptionTest</code> contains tests for the class <code>{@link SampleException}</code>.
* <p>
* Copyright (c) 2017
* 
* @generatedBy wupf@asiainfo.com at 2018-04-17 07:09:31
* @author Administrator
* @version $Revision: 1.0 $
*/

public class SampleExceptionTest  {


  /**
  * Run the showOutArry method test.
  *
  * @throws Exception
  * 
  * @generated By wupf@asiainfo.com 
  * @generated at 2018-04-17 07:09:37
  *@see  Modifier=1  void showOutArry)
  */
  @Test(timeout=1000)

  public void test_showOutArry_W2() throws Exception
  {

    try{

  SampleException fixture = new SampleException();
  fixture.showOutArry();

   //请在这里增加检查点:比如 assertEquals(true, result);
    assertTrue(true);

    }catch(Exception ex){
      WritePrivateException(ex,Thread.currentThread().getStackTrace(),true);
      ex.printStackTrace();
      fail();
    }

  }



  /**
  * Run the showOutMap method test.
  *
  * @throws Exception
  * 
  * @generated By wupf@asiainfo.com 
  * @generated at 2018-04-17 07:09:37
  *@see  Modifier=1  void showOutMap)
  */
  @Test(timeout=1000)

  public void test_showOutMap_W3() throws Exception
  {

    try{

  SampleException fixture = new SampleException();
  fixture.showOutMap();

   //请在这里增加检查点:比如 assertEquals(true, result);
    assertTrue(true);

    }catch(SQLException ex){
       WritePrivateException(ex,Thread.currentThread().getStackTrace(),false);
       ex.printStackTrace();    
    }catch(Exception ex){
      WritePrivateException(ex,Thread.currentThread().getStackTrace(),true);
      ex.printStackTrace();
      fail();
    }

  }



}