import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class SeleniumCrawling {
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; //드라이버 ID
    public static final String WEB_DRIVER_PATH = "C:\\Users\\PC\\Downloads\\chromedriver\\chromedriver.exe"; //드라이버 경로
    public static final String DOWNLOAD_FOLDER_NAME = "GoogleImages"; // 다운로드 폴더 이름
    public static final String DOWNLOAD_FOLDER_PATH = "C:\\Users\\PC\\Downloads\\"+ DOWNLOAD_FOLDER_NAME; //다운로드 폴더 경로

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색어를 입력하시오 : ");
        String search = sc.nextLine();
        // ChromeDriver의 위치를 지정
        try {
            System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // headless mode로 ChromeDriver를 실행
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        // 사용할 url
        String url = "https://www.google.com/search?q=" + search + "&tbm=isch";

        driver.get(url);

        //브라우저 이동시 생기는 로드시간을 기다린다.
        //HTTP응답속도보다 자바의 컴파일 속도가 더 빠르기 때문에 임의적으로 1초를 대기한다.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        // 이미지 요소를 선택
        List<WebElement> imgElements = driver.findElements(By.cssSelector("img.rg_i"));

        for (WebElement imgElement : imgElements) {
            String imgUrl = imgElement.getAttribute("src");
            downloadImage(imgUrl, DOWNLOAD_FOLDER_PATH);
        }

        driver.quit();
    }


    private static void downloadImage(String imgUrl, String downloadFolderPath) {
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
                fileName = imgUrl.substring(imgUrl.lastIndexOf("/") + 1).replaceAll("[^a-zA-Z0-9.-]", "_");
            }

            Path folderPath = Path.of(downloadFolderPath);
            if (!Files.exists(folderPath)) {
                Files.createDirectories(folderPath);
            }

            Path targetPath = folderPath.resolve(fileName);
            Files.copy(in, targetPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Downloaded: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}