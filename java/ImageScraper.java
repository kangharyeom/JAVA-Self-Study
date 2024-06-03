import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ImageScraper {
    public static void main(String[] args) {
        String searchTerm = "레디스 마스터 슬레이브";
        int numPages = 3; // 크롤링할 페이지 수

        // 다운로드할 폴더를 지정
        String downloadFolderPath = "C:\\Users\\PC\\Downloads\\GoogleImages";

        for (int i = 0; i < numPages; i++) {
            String url = "https://www.google.com/search?q=" + searchTerm + "&tbm=isch&start=" + (i * 20);
            scrapeImages(url, downloadFolderPath);
        }
    }

    private static void scrapeImages(String url, String downloadFolderPath) {
        try {
            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36").get();
            Elements imgElements = doc.select("img[data-src]");

            for (Element imgElement : imgElements) {
                String imgUrl = imgElement.attr("data-src");
                if (imgUrl.isEmpty()) {
                    imgUrl = imgElement.attr("src");
                }

                downloadImage(imgUrl, downloadFolderPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void downloadImage(String imgUrl, String downloadFolderPath) {
        try {
            String fileName = imgUrl.substring(imgUrl.lastIndexOf("/") + 1)
                    .replaceAll("[^a-zA-Z0-9.-]", "_"); // 특수 문자를 언더스코어(_)로 대체
            URL url = new URL(imgUrl);

            // 다운로드할 폴더가 없으면 생성
            Path folderPath = Path.of(downloadFolderPath);
            if (!Files.exists(folderPath)) {
                Files.createDirectories(folderPath);
            }

            // 이미지를 다운로드하여 폴더에 저장
            Path targetPath = folderPath.resolve(fileName);
            Files.copy(url.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Downloaded: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}