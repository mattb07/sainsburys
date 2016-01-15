import com.sainsburys.app.engine.Scraper;
import com.sainsburys.app.engine.impl.ScraperImpl;

/**
 * Created by matthew.bateup on 14/01/2016.
 */
public class App {

    private static final String WEB_LINK = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";

    public static void main(String[] args) {

        Scraper scraper = new ScraperImpl();
        scraper.scraper(WEB_LINK);
    }
}