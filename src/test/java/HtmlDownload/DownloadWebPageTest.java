package HtmlDownload;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static HtmlDownload.DownloadWebPage.DownloadWebPageHtml;
import static org.junit.Assert.assertEquals;

public class DownloadWebPageTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void downloadWebPageHtml() throws Exception {
        DownloadWebPageHtml("https://ru.wikipedia.org/wiki/Текст");

        assertEquals("Successfully Downloaded.\n", systemOutRule.getLog());
    }

}