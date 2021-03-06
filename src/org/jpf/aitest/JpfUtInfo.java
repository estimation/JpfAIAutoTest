/** 
* @author 吴平福 
* E-mail:wupf@asiainfo.com 
* @version 创建时间：2017年12月9日 上午6:34:42 
* 类说明 
*/ 

package org.jpf.aitest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jdt.core.dom.ImportDeclaration;

import com.asiainfo.utils.AiDateTimeUtil;

/**
 * 
 */
public class JpfUtInfo {
    private static final Logger logger = LogManager.getLogger();
    private String utPackage="";
    private String SourcePackage="";

    private Map<String, String> mapImport=new HashMap<String, String>();
    private String currentJavaFilePackage="";
    
    private String utFileJavaDoc="";
    private String utClassDeclare="";

    private String utBasic="";

    private String utClassEnd="";
    private List<JpfUtMethodInfo> listUtMethodInfos =new ArrayList<JpfUtMethodInfo>() ;
    private String utMinConstructor="";
    private String utPrivateConstructor="";
    
    //初始化参数的变量，避免重复
    private Map<String, String> mapParamVar=new HashMap<String, String>();
    
    private JpfUtMethodInfo MethodSetup =new JpfUtMethodInfo();
    private JpfUtMethodInfo MethodSetUpBeforeClass=new JpfUtMethodInfo();
    private JpfUtMethodInfo MethodTearDown=new JpfUtMethodInfo();
    private JpfUtMethodInfo MethodTearDownAfterClass=new JpfUtMethodInfo();
    private JpfUtMethodInfo MethodUtMain=new JpfUtMethodInfo();
    
    
    //R：随机，D： JAVADOC ,L：从日志  r: 运行
    private String genType="R";
    /**
     * @return the genType
     */
    public String getGenType() {
        return genType;
    }
    /**
     * @param genType the genType to set
     */
    public void setGenType(String genType) {
        this.genType = genType;
    }
    
    
    /**
     * @return the mapParamVar
     */
    public Map<String, String> getMapParamVar() {
        return mapParamVar;
    }


    /**
     * @param mapParamVar the mapParamVar to set
     */
    public void setMapParamVar(Map<String, String> mapParamVar) {
        this.mapParamVar = mapParamVar;
    }


    /**
     * @return the mapImport
     */
    public Map<String, String> getMapImport() {
        return mapImport;
    }


    /**
     * @param mapImport the mapImport to set
     */
    public void setMapImport(Map<String, String> mapImport) {
        this.mapImport = mapImport;
    }


    /**
     * @return the currentJavaFile
     */
    public String getCurrentJavaFilePackage() {
        return currentJavaFilePackage;
    }


    /**
     * @param currentJavaFile the currentJavaFile to set
     */
    public void setCurrentJavaFilePackage(String currentJavaFile) {
        int iPos=currentJavaFile.lastIndexOf("\\");
        
        if (iPos>0)
        {
            currentJavaFile=currentJavaFile.substring(0, iPos);
        }
        iPos=currentJavaFile.indexOf(GenerateConst.SRC_KEY);
        if (iPos>0)
        {
            currentJavaFile=currentJavaFile.substring( iPos+GenerateConst.SRC_KEY.length(),currentJavaFile.length());
        }
        currentJavaFile=currentJavaFile.replaceAll("\\\\", ".");
        logger.debug(currentJavaFile);
        this.currentJavaFilePackage = currentJavaFile;
    }


    /**
     * @return the sourcePackage
     */
    public String getSourcePackage() {
        return SourcePackage;
    }

    /**
     * @param sourcePackage the sourcePackage to set
     */
    public void setSourcePackage(String sourcePackage) {
        SourcePackage = sourcePackage;
    }
    /**
     * 
     */
    public JpfUtInfo() {
        // TODO Auto-generated constructor stub
        initMethodSetup();
        initMethodSetUpBeforeClass();
        initMethodTearDown();
        initMethodTearDownAfterClass();
        initMethodUtMain();
    }
   
    private void initMethodSetup()
    {
        StringBuffer sb=new StringBuffer();
        sb.append("\n").append("  /**").append("\n");
        sb.append("  * 测试方法初始化.").append("\n");
        sb.append("  * ").append("\n");
        sb.append("  * @throws Exception ").append("\n");
        sb.append("  *         if the initialization fails for some reason ").append("\n");
        sb.append("  *  ").append("\n");
        sb.append("  * @generatedBy wupf@asiainfo.com at ").append(AiDateTimeUtil.getCurrDateTime()).append("\n");
        sb.append("  */  ").append("\n");
        sb.append(" @Before ").append("\n");
        MethodSetup.setMethodJavaDoc(sb.toString());
    }
    private void initMethodSetUpBeforeClass()
    {
        
    }
    private void initMethodTearDown()
    {
        
    }
    private void initMethodTearDownAfterClass()
    {
        
    }
    private void initMethodUtMain()
    {
        
    }
    /**
     * @return the utFileDesc
     */
    public String getUtFileDesc() {
        return utFileJavaDoc;
    }
    /**
     * @param utFileDesc the utFileDesc to set
     */
    public void setUtFileDesc(String utFileDesc) {
        this.utFileJavaDoc = utFileDesc;
    }
    /**
     * @return the utClassDeclare
     */
    public String getUtClassDeclare() {
        return utClassDeclare;
    }
    /**
     * @param utClassDeclare the utClassDeclare to set
     */
    public void setUtClassDeclare(String utClassDeclare) {
        this.utClassDeclare = utClassDeclare;
    }
    /**
     * @return the utClassEnd
     */
    public String getUtClassEnd() {
        return utClassEnd;
    }
    /**
     * @param utClassEnd the utClassEnd to set
     */
    public void setUtClassEnd(String utClassEnd) {
        this.utClassEnd = utClassEnd;
    }
    /**
     * @return the listUtMethodInfos
     */
    public List<JpfUtMethodInfo> getListUtMethodInfos() {
        return listUtMethodInfos;
    }
    /**
     * @param listUtMethodInfos the listUtMethodInfos to set
     */
    public void setListUtMethodInfos(List<JpfUtMethodInfo> listUtMethodInfos) {
        this.listUtMethodInfos = listUtMethodInfos;
    }
    /**
     * @return the utMinConstructor
     */
    public String getUtMinConstructor() {
        if (utMinConstructor.length() > 0) {
            return utMinConstructor;
        } else if (utPrivateConstructor.length() > 0) {
            return utPrivateConstructor;
        }
        return "";
    }
    /**
     * @param utMinConstructor the utMinConstructor to set
     */
    public void setUtMinConstructor(String utMinConstructor) {
        this.utMinConstructor = utMinConstructor.replaceAll("result", "fixture");
    }

    /**
     * @return the utPrivateConstructor
     */
    public String getUtPrivateConstructor() {
        return utPrivateConstructor;
    }

    /**
     * @param utPrivateConstructor the utPrivateConstructor to set
     */
    public void setUtPrivateConstructor(String utPrivateConstructor) {
        this.utPrivateConstructor = utPrivateConstructor;
    }

    
    /**
     * @return the utPackage
     */
    public String getUtPackage() {
        return utPackage;
    }

    /**
     * @param utPackage the utPackage to set
     */
    public void setUtPackage(String utPackage) {
        this.utPackage = utPackage;
    }

    /**
     * 
     * @category 根据方法参数类型增加IMPORT
     * @author 吴平福
     * @param strImport update 2017年11月8日
     */
    public void addImport(String strImport) {

        if (strImport==null || strImport.trim().length()==0)
        {
            return;
        }

        strImport=strImport.replaceAll("import ", "").replaceAll(";", "") .trim();
        logger.trace(strImport);
        int iPos=strImport.lastIndexOf(".");
        String strKey=strImport.substring(iPos+1,strImport.length()).trim();
        logger.trace(strKey);
        mapImport.put(strKey, strImport);
        
        Iterator<Map.Entry<String, String>> it = mapImport.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            logger.trace("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
    }
    
    /**
     * 
     * @category 增加IMPORT
     * @author 吴平福
     * @param importList
     * @param sb update 2017年9月29日
     */
    public void addImport(List importList) {

        for (Object obj : importList) {
            ImportDeclaration importDec = (ImportDeclaration) obj;
            //logger.debug(importDec.toString());
            addImport(importDec.toString().trim());
        }
    }
    /**
     * 
     * @category 
     * @author 吴平福 
     * @param strClassName
     * @return
     * update 2018年3月6日
     */
    public String findImport(String strClassName)
    {
        Iterator<Map.Entry<String, String>> it = mapImport.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
           // logger.debug("key= " + entry.getKey() + " and value= " + entry.getValue());
            if (entry.getKey().equalsIgnoreCase(strClassName))
            {
                logger.debug("key= " + entry.getKey() + " and value= " + entry.getValue());
                strClassName=entry.getValue();
                break;
            }
        }
        return strClassName;
    }
    
    /**
     * 
     * @category 
     * @author 吴平福 
     * @param strImport
     * update 2018年3月6日
     */
    public void removeImport(String strImport) {
        Iterator<Map.Entry<String, String>> it = mapImport.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            if (entry.getValue().trim().equalsIgnoreCase(strImport))
            {
                mapImport.remove(entry.getKey());
            }
        }

    }
    public String toString() {
        StringBuffer  sbUtText=new StringBuffer();   
        
        /*
        if (GenerateInputParam.New_Package_Name.length()>0)
        {
            utPackage=GenerateInputParam.New_Package_Name+"\n//"+utPackage;
        }
        */
        
        sbUtText.append(utPackage).append("\n");
        
        Iterator<Map.Entry<String, String>> it = mapImport.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            sbUtText.append("import ").append(entry.getValue()+";\n");
        }
        sbUtText.append("\n").append(utFileJavaDoc).append("\n").append(utClassDeclare).append("\n");
        
        for(int i=0;i<listUtMethodInfos.size();i++)
        {
            sbUtText.append(listUtMethodInfos.get(i).toString()).append("\n");
        }
        sbUtText.append(utBasic).append("\n").append(utClassEnd);
        return sbUtText.toString();
    }
    /**
     * @return the utBasic
     */
    public String getUtBasic() {
        return utBasic;
    }

    /**
     * @param utBasic the utBasic to set
     */
    public void setUtBasic(String utBasic) {
        this.utBasic = utBasic;
    }
    

    /**
     * @return the methodSetup
     */
    public JpfUtMethodInfo getMethodSetup() {
        return MethodSetup;
    }

    /**
     * @param methodSetup the methodSetup to set
     */
    public void setMethodSetup(JpfUtMethodInfo methodSetup) {
        MethodSetup = methodSetup;
    }

    /**
     * @return the methodSetUpBeforeClass
     */
    public JpfUtMethodInfo getMethodSetUpBeforeClass() {
        return MethodSetUpBeforeClass;
    }

    /**
     * @param methodSetUpBeforeClass the methodSetUpBeforeClass to set
     */
    public void setMethodSetUpBeforeClass(JpfUtMethodInfo methodSetUpBeforeClass) {
        MethodSetUpBeforeClass = methodSetUpBeforeClass;
    }

    /**
     * @return the methodTearDown
     */
    public JpfUtMethodInfo getMethodTearDown() {
        return MethodTearDown;
    }

    /**
     * @param methodTearDown the methodTearDown to set
     */
    public void setMethodTearDown(JpfUtMethodInfo methodTearDown) {
        MethodTearDown = methodTearDown;
    }

    /**
     * @return the methodTearDownAfterClass
     */
    public JpfUtMethodInfo getMethodTearDownAfterClass() {
        return MethodTearDownAfterClass;
    }

    /**
     * @param methodTearDownAfterClass the methodTearDownAfterClass to set
     */
    public void setMethodTearDownAfterClass(JpfUtMethodInfo methodTearDownAfterClass) {
        MethodTearDownAfterClass = methodTearDownAfterClass;
    }

    /**
     * @return the methodUtMain
     */
    public JpfUtMethodInfo getMethodUtMain() {
        return MethodUtMain;
    }

    /**
     * @param methodUtMain the methodUtMain to set
     */
    public void setMethodUtMain(JpfUtMethodInfo methodUtMain) {
        MethodUtMain = methodUtMain;
    }

}
