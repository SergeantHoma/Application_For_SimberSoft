import ReadingPage.ReadingHtmlPage;

import java.io.File;
import java.util.Scanner;

import static GetName.GetNameFile.GetNameFileMethod;
import static HtmlDownload.DownloadWebPage.DownloadWebPageHtml;

public class Main {
    /**
     * A utility that downloads, read and output to console  a file from a URL.
     *
     * @author Vladimir Esin
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the full url of the site");
        Scanner in = new Scanner(System.in);
        String url = in.nextLine();
        DownloadWebPageHtml(url);
        String str = GetNameFileMethod(url + ".html");
        File file = new File(str);
        ReadingHtmlPage.Reading(file);
    }
}
