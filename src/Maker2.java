import DTO.Dummy;
import receipts.IReceipt;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import receipts.Receipt1;
import receipts.Receipt2;
import receipts.Receipt3;
import receipts.Receipt4;

public class Maker2 {

    public static void main(String[] args) {

        List data = new ArrayList();
        data.add(new String[]{"안녕","1,000","12","12,000"});
        data.add(new String[]{"안녕2","1,000","13","13,000"});



        Dummy dummy = new Dummy();
        dummy.setObj(data);
        dummy.setStore("거인 통닭");
        dummy.setBusinessLicense("123-4526-79");
        dummy.setCardType("국민 KB 카드");
        dummy.setCardApproval("11233124");
        dummy.setPaymentDate("2023-05-07");
        dummy.setRepresentative("노홍기");
        dummy.setAddress("부산광역시 부산진구 부전 2동 000-000");

        IReceipt iReceipt = new Receipt4();

        //TODO: 2023-05-05 항목이 늘어날 때 마다 사이즈가 커져야함.
        // => 이 방법은 각 영수증 고유 길이와, 각 영수증당 항목에 대한 길이 변수를 두어 구현하자.

        //TODO: 2023-05-07 png 파일 저장할 때, 파일 이름은 무엇으로 저장할 것인가?
        // => 사원 정보 + 날짜 + 항목이름

        //TODO: 2023-05-07 가지고 와야할 더미데이터는 무엇인가?
        // => 총 구매액, 사용처, 날짜 및 시간 // 각 항목 등등

        // TODO: 2023-05-07 : 결제 데이터와 결재 데이터에 들어가야할 항목들의 차이는?
        // => 결제 클래스와, 결재 클래스를 나눈다.
        // => "결제"건에 대한 영수증은 패턴을 통해 여러가지 출력하도록.
        // => "결재"건에 대한 OCR 영수증은 하나로 통일.

        try {
            // HTML 소스 코드 가져오기
            String html = iReceipt.html(dummy);

            // 폰트 코드 가져오기 =>
            String font = iReceipt.font();

            // CSS 소스 코드 가져오기
            String css = iReceipt.css();

            // 항목 가져오기 => 추후에 반복문으로 추출 할 예정.
//            String object = receipt.object(dummy);

            // HTML과 CSS 결합하여 JEditorPane에 적용
            String styledHtml =
                    "<html><head>"
                    + font + "<style>"
                    + css + "</style></head><body>"
                    + html + "</body></html>";

            JEditorPane editorPane = new JEditorPane();
            editorPane.setContentType("text/html");
            editorPane.setText(styledHtml);
            editorPane.setSize(new Dimension(490, 560+data.size()*34));

            // HTML을 이미지로 렌더링
            BufferedImage image = new BufferedImage(editorPane.getWidth(), editorPane.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = image.createGraphics();
            editorPane.print(graphics);

            // 이미지 파일로 저장
            ImageIO.write(image, "png", new File("test4.png"));

            System.out.println("이미지 파일 생성 성공");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


