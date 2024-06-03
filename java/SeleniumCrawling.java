import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class SeleniumCrawling {
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; //드라이버 ID
    public static final String WEB_DRIVER_PATH = "C:\\Users\\PC\\Downloads\\chromedriver\\chromedriver.exe"; //드라이버 경로
    public static final String DOWNLOAD_FOLDER_NAME = "GoogleImages"; // 다운로드 폴더 이름
    public static final String DOWNLOAD_FOLDER_PATH = "C:\\Users\\PC\\Downloads\\" + DOWNLOAD_FOLDER_NAME; //다운로드 폴더 경로

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("검색어를 입력하시오 : ");
            String search = sc.nextLine();

            System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            WebDriver driver = new ChromeDriver(options);

            String url = "https://www.google.com/search?q=" + search + "&tbm=isch";

            driver.get(url);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            List<WebElement> imgElements = driver.findElements(By.tagName("img"));

            for (WebElement imgElement : imgElements) {
                String imgUrl = imgElement.getAttribute("src");
                downloadImage(imgUrl);
            }

            driver.quit();
        } catch (Exception e) {
            System.err.println("An error occurred:");
            e.printStackTrace();
        }
    }


    private static void downloadImage(String imgUrl) {
        try {
            String fileName;
            InputStream in;
            if (imgUrl.startsWith("data:")) {
                String mimeType = imgUrl.substring(5, imgUrl.indexOf(';'));
                String fileExtension;
                switch (mimeType) {
                    case "image/jpeg":
                        fileExtension = ".jpg";
                        break;
                    case "image/png":
                        fileExtension = ".png";
                        break;
                    // 필요한 만큼 case를 추가할 수 있습니다.
                    default:
                        throw new IOException("Unsupported MIME type: " + mimeType);
                }

                String base64Image = imgUrl.split(",")[1];
                byte[] imageBytes = Base64.getDecoder().decode(base64Image);
                in = new ByteArrayInputStream(imageBytes);
                fileName = UUID.randomUUID().toString() + fileExtension; // 확장자를 포함한 임의의 파일 이름을 생성합니다.
            } else {
                URL url = new URL(imgUrl);
                in = url.openStream();
                fileName = URLEncoder.encode(imgUrl.substring(imgUrl.lastIndexOf("/") + 1), StandardCharsets.UTF_8.toString());
            }

            Path folderPath = Path.of(DOWNLOAD_FOLDER_PATH);
            if (!Files.exists(folderPath)) {
                Files.createDirectories(folderPath);
            }

            Path targetPath = folderPath.resolve(fileName);
            try (InputStream finalIn = in) {
                Files.copy(finalIn, targetPath, StandardCopyOption.REPLACE_EXISTING);
            }

            System.out.println("Downloaded: " + fileName);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}