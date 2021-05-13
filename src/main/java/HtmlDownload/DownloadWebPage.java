package HtmlDownload;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static GetName.GetNameFile.GetNameFileMethod;

public class DownloadWebPage {

    public static final Logger logger = Logger.getLogger(
            DownloadWebPage.class.getName());

    public static void DownloadWebPageHtml(String webpage) throws Exception {
        String str = GetNameFileMethod(webpage);
        Handler fileHandler = new FileHandler();
        logger.addHandler(fileHandler);

        try {
            File f1 = new File(GetNameFileMethod(webpage) + ".html");
            String NameFileCheck = GetNameFileMethod(webpage);

            // Create URL object
            URL url = new URL(webpage);
            BufferedReader readr =
                    new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));

            outerloop:
            while (true) {
                if (f1.exists()) {
                    NameFileCheck += 1;
                    str += 1;
                    boolean ls = f1.renameTo(new File(NameFileCheck + ".html"));
                } else {
                    break outerloop;
                }
            }

            // Enter filename in which you want to download
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(str + ".html", false));

            // read each line from stream till end
            String line;
            while ((line = readr.readLine()) != null) {
                writer.write(line);
            }

            readr.close();
            writer.close();
            System.out.print("Successfully Downloaded.\n");
        }

        // Exceptions
        catch (MalformedURLException mue) {
            logger.log(Level.WARNING, "Malformed URL Exception raised", mue);
        } catch (IOException ie) {
            logger.log(Level.WARNING, "IOException raised", ie);
        }
    }
}