/**
 * @author 吴平福 E-mail:wupf@asiainfo.com
 * @version 创建时间：2017年11月19日 下午10:16:58 类说明
 */

package org.jpf.gts.gtm;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jpf.unittests.generateuts.GenerateInputParam;

import com.asiainfo.utils.AiDateTimeUtil;


/**
 * 
 */
public class GenerateMethodUtil {
    private static final Logger logger = LogManager.getLogger();

    /**
     * 
     */
    public GenerateMethodUtil() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     * @category 增加启动结束主函数
     * @author 吴平福
     * @param strClass
     * @param sb update 2017年9月29日
     */
    public static String addTestEnd(String strClass) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n").append("  /**").append("\n");
        sb.append("  * 测试方法初始化.").append("\n");
        sb.append("  * ").append("\n");
        sb.append("  * @throws Exception ").append("\n");
        sb.append("  *         if the initialization fails for some reason ").append("\n");
        sb.append("  *  ").append("\n");
        sb.append("  * @generatedBy wupf@asiainfo.com at ").append(AiDateTimeUtil.getCurrDateTime()).append("\n");
        sb.append("  */  ").append("\n");
        sb.append(" @Before ").append("\n");
        sb.append("  public void setUp()  throws Exception ").append("\n");
        sb.append("  { ").append("\n");
        sb.append("     // TODO: add additional set up code here").append("\n");
        sb.append("  }").append("\n");

        sb.append("\n").append("  /**").append("\n");
        sb.append("  *  如果有必须，测试方法退出清理工作.").append("\n");
        sb.append("  * ").append("\n");
        sb.append("  * @throws Exception ").append("\n");
        sb.append("  * if the clean-up fails for some reason ").append("\n");
        sb.append("  *  ").append("\n");
        sb.append("  * @generatedBy wupf@asiainfo.com at ").append(AiDateTimeUtil.getCurrDateTime()).append("\n");
        sb.append("  */  ").append("\n");
        sb.append("  @After ").append("\n");
        sb.append("  public void tearDown()  throws Exception ").append("\n");
        sb.append("  { ").append("\n");
        sb.append("    // TODO: add additional clean-up code here").append("\n");
        sb.append("  }").append("\n");

        sb.append("\n").append("  /**").append("\n");
        sb.append("  * 测试类初始化.").append("\n");
        sb.append("  * ").append("\n");
        sb.append("  * @throws Exception ").append("\n");
        sb.append("  *         if the initialization fails for some reason ").append("\n");
        sb.append("  *  ").append("\n");
        sb.append("  * @generatedBy wupf@asiainfo.com at ").append(AiDateTimeUtil.getCurrDateTime()).append("\n");
        sb.append("  */  ").append("\n");
        sb.append(" @BeforeClass ").append("\n");
        sb.append("  public static void setUpBeforeClass()  throws Exception ").append("\n");
        sb.append("  { ").append("\n");
        sb.append("     // TODO: add additional set up code here").append("\n");
        sb.append("  }").append("\n");

        sb.append("\n").append("  /**").append("\n");
        sb.append("  *  如果有必须，测试类退出清理工作.").append("\n");
        sb.append("  * ").append("\n");
        sb.append("  * @throws Exception ").append("\n");
        sb.append("  * if the clean-up fails for some reason ").append("\n");
        sb.append("  *  ").append("\n");
        sb.append("  * @generatedBy wupf@asiainfo.com at ").append(AiDateTimeUtil.getCurrDateTime()).append("\n");
        sb.append("  */  ").append("\n");
        sb.append("  @AfterClass ").append("\n");
        sb.append("  public static void tearDownAfterClass()  throws Exception ").append("\n");
        sb.append("  { ").append("\n");
        sb.append("    // TODO: add additional clean-up code here").append("\n");
        sb.append("  }").append("\n");

        sb.append("\n").append("  /**").append("\n");
        sb.append("  * Launch the test").append("\n");
        sb.append("  * ").append("\n");
        sb.append("  * @param args the command line arguments ").append("\n");
        sb.append("  *  ").append("\n");
        sb.append("  * @generatedBy wupf@asiainfo.com at ").append(AiDateTimeUtil.getCurrDateTime()).append("\n");
        sb.append("  * ").append("\n");
        sb.append("  */").append("\n");
        sb.append("  public static void main(String[] args) ").append("\n");
        sb.append("  {").append("\n");
        sb.append("    new org.junit.runner.JUnitCore().run(").append(strClass).append("Test.class);\n");
        sb.append("  } ").append("\n");
        sb.append("} ").append("\n");

        return sb.toString();
    }

    /**
     * 
     * @category 增加类说明
     * @author 吴平福
     * @param strClass
     * @param sb update 2017年9月29日
     */
    public static String addClassDesc(String strClass) {
        StringBuffer sb = new StringBuffer();
        sb.append("/**").append("\n");
        sb.append("* The class <code>").append(strClass)
                .append("Test</code> contains tests for the class <code>{@link ").append(strClass).append("}</code>.")
                .append("\n");
        sb.append("* <p>").append("\n");
        sb.append("* Copyright (c) 2017").append("\n");
        sb.append("* ").append("\n");
        sb.append("* @generatedBy wupf@asiainfo.com at ").append(AiDateTimeUtil.getCurrDateTime()).append("\n");
        sb.append("* @author Administrator").append("\n");
        sb.append("* @version $Revision: 1.0 $").append("\n");
        sb.append("*/").append("\n");

        return sb.toString();
    }

    /**
     * 
     * @category 增加类说明
     * @author 吴平福
     * @param strClass
     * @param sb update 2017年9月29日
     */
    public static String addClassDeclare(String strClass) {
        StringBuffer sb = new StringBuffer();
        sb.append("public class ").append(strClass).append("Test ");
        if (null != GenerateInputParam.UT_ExtendClassName && GenerateInputParam.UT_ExtendClassName.trim().length() > 0) {
            sb.append(" extends ").append(GenerateInputParam.UT_ExtendClassName);
        }
        sb.append(" {\n");
        return sb.toString();
    }


    public static String addExtraMethod(String strClassName, String strPackageName) {
    	
    	/*
        StringBuilder sb = new StringBuilder();
        sb.append("  private static final Logger logger = Logger.getLogger(").append(strClassName)
                .append("Test.class);").append("\n").append("  @Override").append("\n")
                .append("  public Logger getLogger() {").append("\n").append("       return logger;").append("\n")
                .append("   }").append("\n").append("  public ").append(strClassName)
                .append("Test(JpfTestInfo cJpfTestInfo) {").append("\n").append("   super(cJpfTestInfo);").append("\n")
                .append("  }").append("\n");
        sb.append("        ").append(strClassName).append(" c").append(strClassName).append("= (").append(strClassName)
                .append(") ContextManager.getContext().getBean(\"")
                .append(Service2Bean.getInstance().findBeanIdFromXML(strClassName, strPackageName)).append("\");\n").append("  }");

        return sb.toString();
        */
    	return "";
    }

}