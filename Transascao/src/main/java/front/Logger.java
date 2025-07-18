/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package front;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MIGUEL CAMPOS
 */
public class Logger {

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private void log(String level, String msg) {
        String now = LocalDateTime.now().format(FMT);
        System.out.printf("[%s]: %s - %s\n", now, level, msg);
    }

    public void debug(String msg) {
        this.log("DEBUG", msg);
    }

    public void info(String msg) {
        this.log("INFO", msg);
    }

    public void warn(String msg) {
        this.log("WARN", msg);
    }

    public void error(String msg) {
        this.log("ERROR", msg);
    }
}
