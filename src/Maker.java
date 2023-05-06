import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Maker {

    public static void main(String[] args) {
        Receipt receipt = new Receipt();

        try {
            // HTML 소스 코드 가져오기
            String html = receipt.html();

            // Jsoup 라이브러리를 이용하여 HTML 소스 코드 파싱하기
            Document doc = Jsoup.parse(html);

            JEditorPane editorPane = new JEditorPane();
            editorPane.setContentType("text/html");
            editorPane.setText(html);
            editorPane.setSize(new Dimension(400, 600));

            // HTML을 이미지로 렌더링
            BufferedImage image = new BufferedImage(editorPane.getWidth(), editorPane.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = image.createGraphics();
            editorPane.print(graphics);

            // 이미지 파일로 저장
            ImageIO.write(image, "png", new File("output1.png"));

            System.out.println("이미지 파일 생성 성공");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


