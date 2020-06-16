import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.print.Doc;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter URL: ");
        Scanner scan = new Scanner(System.in);
        String url = scan.nextLine();

        System.setProperty("http.proxyhost", "127.0.0.1");
        System.setProperty("http.proxyport", "3128");

        Document document = Jsoup.connect(url).
                userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36")
                .ignoreContentType(true).timeout(5000).get();
        String title = document.title();
        System.out.println();
        System.out.println("Website Title: " + title);
        System.out.println();

        Elements links = document.select("a[href]");
        System.out.println("Links found -");
        for(Element link : links) {
            System.out.println("\nLink: " + link.attr("href"));
            System.out.println("Text: " + link.text());
        }

        Elements images = document.getElementsByTag("img");
        System.out.println();
        System.out.println("Images found -");
        for(Element image : images) {
            System.out.println("\nImage:" + image.attr("abs:src"));
        }

    }

}
