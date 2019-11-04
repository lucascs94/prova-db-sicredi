package utils;

import org.apache.commons.io.output.WriterOutputStream;
import org.junit.jupiter.api.TestInfo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogHelper {
    public static PrintStream setLogConfiguration(TestInfo info) {
        MetodosAuxiliares.criarDiretorio(System.getProperty("user.dir") + "\\reports");
        PrintStream printStream = null;
        String filePath = System.getProperty("user.dir") + "/reports/" + info.getDisplayName().replace(" ", "_") + new SimpleDateFormat("_yyyy_MM_dd_HH_m_ss").format(new Date()) + ".txt";
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            printStream = new PrintStream(new WriterOutputStream(fileWriter, "UTF-8"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return printStream;
    }
}
