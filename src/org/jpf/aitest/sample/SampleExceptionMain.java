/**
 * 
 */
package org.jpf.aitest.sample;

import org.jpf.aitest.GenerateInputParam;
import org.jpf.aitest.GenerateMain;

/**
 * @author Administrator
 *
 */
public class SampleExceptionMain {

    /**
     * @category @author 吴平福
     * @param args update 2017年11月20日
     */

    public static void main(String[] args) {
        
        //根据注释生成
        GenerateInputParam.bNeedTimeOut=true;
        GenerateInputParam.FileNameFilter="";
        
        
        //抓取运行异常
        String strFileName="D:\\jworkspaces\\JpfUnitTest2\\src\\org\\jpf\\aitest\\sample\\SampleException.java";
                
        new GenerateMain(1, strFileName);
    }

}
