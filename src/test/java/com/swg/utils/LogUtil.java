package com.swg.utils;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.swg.config.GlobalVariables;

public class LogUtil extends GlobalVariables{
	 static Logger errorLogger;
	 static Logger normalLogger;
	 static FileAppender normalFileApp;
	 static FileAppender errorFileApp;
	 static ConsoleAppender conApp;
	 public static boolean isInit=false;
	//If log4j.property file is not in the root dir of project
	 //String log4jConfigFile = System.getProperty("user.dir")
     //          + File.separator + "log4j.properties";
      // DOMConfigurator.configure(log4jConfigFile);
	static PatternLayout patternLayout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p - %m%n");
	static PatternLayout consolePatternLayout = new PatternLayout("\tLOG-: [%m -  %d{yyyy-MM-dd HH:mm:ss a}] %n");
	 public  void init(Class clazz){
		 if(!isInit){		 
		 normalLogger = Logger.getLogger(clazz+",NormalLogger");
		 normalLogger.setLevel(Level.INFO);	 
		 normalFileApp= new FileAppender();
		 normalFileApp.setLayout(patternLayout);
		 //normalFileApp.setFile(System.getProperty("user.dir")+GetValue("logInfoFilePath"));		 
		 normalFileApp.setImmediateFlush(true);
		 normalLogger.addAppender(normalFileApp);
		 normalFileApp.activateOptions();		 
		 errorLogger = Logger.getLogger(clazz+",ErrorLogger");
		 errorLogger.setLevel(Level.ERROR);
		 errorFileApp= new FileAppender();
		 errorFileApp.setLayout(patternLayout);
		 //errorFileApp.setFile(System.getProperty("user.dir")+GetValue("logErrorFilePath"));		 
		 errorFileApp.setImmediateFlush(true);
		 errorLogger.addAppender(errorFileApp);
		 errorFileApp.activateOptions();
		 conApp = new ConsoleAppender();
		 conApp.setLayout(consolePatternLayout);
		 conApp.setTarget("System.out");
		 conApp.activateOptions();		 
		 normalLogger.addAppender(conApp);				 		 
		 isInit=true;
		 }
	 }			 
	 public  void init(String className){
		 if(!isInit){
		 normalLogger = Logger.getLogger(className+",NormalLogger");
		 normalLogger.setLevel(Level.INFO);	
		 normalFileApp= new FileAppender();
		 normalFileApp.setLayout(patternLayout);
		 normalFileApp.setFile(System.getProperty("user.dir")+"\\src\\test\\resources\\Logs\\appLog.txt");
		 normalFileApp.setImmediateFlush(true);
		 normalLogger.addAppender(normalFileApp);
		 normalFileApp.activateOptions();		 
		 errorLogger = Logger.getLogger(className+",ErrorLogger");
		 errorLogger.setLevel(Level.ERROR);
		 errorFileApp= new FileAppender();
		 errorFileApp.setLayout(patternLayout);
		 errorFileApp.setFile(System.getProperty("user.dir")+"\\src\\test\\resources\\Logs\\errorLog.txt");
		 errorFileApp.setImmediateFlush(true);
		 errorLogger.addAppender(errorFileApp);
		 errorFileApp.activateOptions();		 		 
		 conApp = new ConsoleAppender();
		 conApp.setLayout(consolePatternLayout);
		 conApp.setTarget("System.out");
		 conApp.activateOptions();		 
		 normalLogger.addAppender(conApp);
		 isInit=true;
		 }
	 }
	 public  void infoLog(Class clazz,String message){
		 init(clazz); 
		 normalLogger.info(message);		 		 	 	 
	 }
	 
	 public  void infoLog(String className,String message){
		 init(className); 
		 normalLogger.info(message);
	 }
 
	 public  void errorLog(Class clazz,String message, Throwable t){		 
		new LogUtil().init(clazz);		 
		 errorLogger.error(message,t);
		 errorLogger.error("<---------------------------------------------------------------------->");			 	 
	 }
	 
	 public  void errorLog(Class clazz,String message){
		 new LogUtil().init(clazz);		
		errorLogger.error(message);
		errorLogger.error("<----------------------------------------------------------------------->");			 	 
	 }
	 
	 public  void errorLog(String name,String message){
		 new LogUtil().init(name);	
		errorLogger.error(message);
		errorLogger.error("-----------------------------------------------------------------------");			 	 
	 }
	 public  void infoLog1(String message){
		   //init(className); 
		   normalLogger.info(message);
	 }

}
