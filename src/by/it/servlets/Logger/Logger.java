package by.it.servlets.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {
    private static Logger instanse;

    private Logger(){
        new File("tomcat\\webapps\\Log.txt");
    }

    public static Logger getInstanse(){
        Logger localInstance = instanse;
        if (null == localInstance){
            synchronized (Logger.class){
                localInstance = instanse;
                if (null == localInstance)
                    instanse = localInstance = new Logger();
            }
        }
        return localInstance;
    }

    public static void writeLog(String logText){
        try {
            getInstanse();
            PrintWriter printer = new PrintWriter(new FileWriter("tomcat\\webapps\\Log.txt", true));
            printer.println(new Date(System.currentTimeMillis()) + " : " + logText);
            printer.close();
        } catch (IOException e) {
            writeLog("Ошибка записи LogFile.");
        }
    }

}
