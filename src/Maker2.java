import DTO.Dummy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Maker2 {

    public static void main(String[] args) {

        List data = new ArrayList();
        data.add(new String[]{"안녕", "1,000"});
        data.add(new String[]{"안녕2","1,000"});
        data.add(new String[]{"안녕3","1,000"});
        data.add(new String[]{"안녕4","1,000"});

        Dummy dummy = new Dummy();
        dummy.setObj(data);
        dummy.setStore("안녕하세요");

        Receipt receipt = new Receipt();

        // TODO: 2023-05-05 항목이 늘어날 때 마다 사이즈가 커져야함.
        // => 이 방법은 각 영수증 고유 길이와, 각 영수증당 항목에 대한 길이 변수를 두어 구현하자.
        try {
            // HTML 소스 코드 가져오기
            String html = receipt.html();

            // 폰트 코드 가져오기 =>
            String font = receipt.font();

            // CSS 소스 코드 가져오기
            String css = receipt.css();

            // 항목 가져오기 => 추후에 반복문으로 추출 할 예정.
            String object = receipt.object(dummy);

            // HTML과 CSS 결합하여 JEditorPane에 적용
            String styledHtml =
                    "<html><head>"
                    + font + "<style>"
                    + css + "</style></head><body>"
                    + object + html + "</body></html>";



            JEditorPane editorPane = new JEditorPane();
            editorPane.setContentType("text/html");
            editorPane.setText(styledHtml);
            editorPane.setSize(new Dimension(490, 800));

            // HTML을 이미지로 렌더링
            BufferedImage image = new BufferedImage(editorPane.getWidth(), editorPane.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = image.createGraphics();
            editorPane.print(graphics);

            // 이미지 파일로 저장
            ImageIO.write(image, "png", new File("test2.png"));

            System.out.println("이미지 파일 생성 성공");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


