/**
 * @author 吴平福 E-mail:wupf@asiainfo.com
 * @version 创建时间：2018年1月26日 下午8:49:19 类说明
 */

package org.jpf.unittests.generateuts.genbylog;

import java.util.Vector;
import java.util.regex.Matcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
<<<<<<< HEAD
import org.jpf.unittests.generateuts.GenerateInputParam;
=======
>>>>>>> f37f043b207f8d15c65da51508ced7d10104a70e

import com.asiainfo.utils.ios.AiFileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 
 */
public class HandleLogFromDebug {
    private static final Logger logger = LogManager.getLogger();

    private final String LogFileType = ".log";

    private long lFindCount=0;
    /**
     * 
     */
    public HandleLogFromDebug(String strInputLogFilePath) {
        // TODO Auto-generated constructor stub
        // 2018-01-26 19:02:05,529 DEBUG [java.sql.PreparedStatement] - {pstm-100001} 北京移动电商
        long start = System.currentTimeMillis();
        try {

            Vector<String> vFiles = new Vector<String>();
            AiFileUtil.getFiles(strInputLogFilePath, vFiles, LogFileType);
            logger.info(vFiles.size());
            for (int i = 0; i < vFiles.size(); i++) {
                HandleLogFile(vFiles.get(i),i);
            }

        } catch (Exception ex) {
            // TODO: handle exception
            logger.error(ex);
            ex.printStackTrace();
        }
        logger.info("lFindCount " +lFindCount);
        logger.info("ExcuteTime " + (System.currentTimeMillis() - start) + "ms");
    }


    /**
     * @category @author 吴平福
     * @param args update 2018年1月26日
     */

    public static void main(String[] args) {
        // TODO Auto-generated method stub
<<<<<<< HEAD

            new HandleLogFromDebug(GenerateInputParam.RUN_LOG_SOURCE_FILEPATH);

=======
        if (1 == args.length) {
            new HandleLogFromDebug(args[0]);
        } else {
            logger.warn("no input");
        }
>>>>>>> f37f043b207f8d15c65da51508ced7d10104a70e
    }
    // DEBUG [java.sql.PreparedStatement] - {pstm-
    // Executing Statement:
    // Parameters:

    
    public void HandleLogFile(String strFileName,int iFileCount) throws Exception {
       // InputStreamReader read = null;
       BufferedReader reader = null;
        try {
            logger.info(strFileName);
            if (null == strFileName || 0 == strFileName.trim().length()) {
                return;
            }
            File f = new File(strFileName);
            if (!f.exists()) {

                return;
            }
                        long lCount=0;
            StringBuilder  sb = new StringBuilder();
            //read = new InputStreamReader(new FileInputStream(f), "GB2312");

            reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
            String line;
            boolean isFindSql=false;
            String strDateTime="";
            while ((line = reader.readLine()) != null) {
                
                if (line.indexOf(HandleLogConst.KEY_SQL)>0)
                {
                    int iPos=line.indexOf(HandleLogConst.KEY_SQL_STATEMENT);
                    if (iPos>0)
                    {
                        strDateTime=line.substring(0,19);
                        line=line.substring(iPos+HandleLogConst.KEY_SQL_STATEMENT.length()+1, line.length()).trim();
<<<<<<< HEAD
                        if (line.toUpperCase().startsWith("SELECT") && line.toUpperCase().endsWith(HandleLogConst.KEY_EXCLUDE_SQL))
=======
                        if (line.toUpperCase().startsWith("SELECT") && line.toUpperCase().endsWith(".NEXTVAL AS ID FROM DUAL"))
>>>>>>> f37f043b207f8d15c65da51508ced7d10104a70e
                        {
                            continue;
                        }
                        sb.append(strDateTime).append("\n");
                        Matcher m = HandleLogConst.p.matcher(line);
                        line= m.replaceAll(" ");
                       
                        sb.append(line).append("\n");
                        lCount++;
                        isFindSql=true;
                    }
                    iPos=line.indexOf(HandleLogConst.KEY_SQL_PARAM);
                    if (iPos>0 && isFindSql)
                    {
                        line=line.substring(iPos+HandleLogConst.KEY_SQL_PARAM.length()+1, line.length());
                        Matcher m = HandleLogConst.p.matcher(line);
                        line= m.replaceAll(" ");
                        //logger.info(line);
                        sb.append(line).append("\n");
                        isFindSql=false;
                    }
                }
                //sb.append(line).append("\r\n");

            }
            logger.info(lCount);
            lFindCount+=lCount;
            if (sb.length()>0)
            {
<<<<<<< HEAD
                AiFileUtil.saveFile(GenerateInputParam.RUN_LOG_FILEPATH+ "//debug_run_format"+iFileCount+".log", sb);
=======
                AiFileUtil.saveFile("D:\\abc\\b\\abc"+iFileCount+".log", sb);
>>>>>>> f37f043b207f8d15c65da51508ced7d10104a70e
            }
        } catch (Exception ex) {
            // TODO: handle exception
            ex.printStackTrace();
        } finally {
            if (null != reader) {
                reader.close();
            }

        }

    }

}
