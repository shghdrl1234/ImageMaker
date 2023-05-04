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

//        System.out.println(receipt.first());
        try {
            // HTML 소스 코드 가져오기
            String html = receipt.first();

            // Jsoup 라이브러리를 이용하여 HTML 소스 코드 파싱하기
            Document doc = Jsoup.parse(html);

//            // Select the table element
//            Elements table = doc.select("table");
//
//            // Create a BufferedImage object with the same size as the table
//            int width = table.get(0).outerWidth();
//            int height = table.get(0).outerHeight();
//            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//
//            // Draw the table onto the image using a Graphics2D object
//            Graphics2D g2d = image.createGraphics();
//            table.get(0).draw(g2d);
//            g2d.dispose();
//
//            // Save the image to a file
//            File output = new File("table.png");
//            ImageIO.write(image, "png", output);



//            // HTML 소스 코드를 이미지로 변환하기 위해 BufferedImage 생성하기
//            BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
//
//            // BufferedImage에 HTML 소스 코드를 그리기
//            Elements elements = doc.select("body").first().children();
//            for (Element element : elements) {
//                System.out.println(element);
////                element.html();
//                // 이미지에 그릴 HTML 태그 처리
//                // 예를 들어, h1 태그 처리:
//                // Font font = new Font("SansSerif", Font.BOLD, 24);
////                 image.getGraphics().drawString(element.text(), 50, 50);
//            }
//
//            // ImageIO 클래스를 이용하여 이미지 파일로 저장하기
//            File outputfile = new File("C:/Users/교육생11/Desktop/image" + "/test1.jpg");
//            ImageIO.write(image, "jpg", outputfile);


            JEditorPane editorPane = new JEditorPane();
            editorPane.setContentType("text/html");
            editorPane.setText(html);
            editorPane.setSize(new Dimension(400, 600));

            // HTML을 이미지로 렌더링
            BufferedImage image = new BufferedImage(editorPane.getWidth(), editorPane.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = image.createGraphics();
            editorPane.print(graphics);

            File outputfile = new File("C:/Users/교육생11/Desktop/image" + "/test.jpg");
            // 이미지 파일로 저장
            ImageIO.write(image, "png", new File("output3.png"));

            System.out.println("이미지 파일 생성 성공");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


