import DTO.Dummy;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import receipts.IReceipt;
import receipts.ReceiptFactory;
import receipts.receiptFactory.Receipt1Factory;
import receipts.receiptFactory.Receipt2Factory;
import receipts.receiptFactory.Receipt3Factory;
import receipts.receiptFactory.Receipt4Factory;
import receipts.receiptFactory.Receipt5Factory;
import receipts.receiptFactory.Receipt6Factory;

public class Maker3 {

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
        dummy.setUser("shghdrl");

        ReceiptFactory receiptFactory;
        Random rd = new Random();
        switch (rd.nextInt(6)+1) {
            case 6: receiptFactory = new Receipt6Factory(); break;
            case 5: receiptFactory = new Receipt5Factory(); break;
            case 4: receiptFactory = new Receipt4Factory(); break;
            case 3: receiptFactory = new Receipt3Factory(); break;
            case 2: receiptFactory = new Receipt2Factory(); break;
            default: receiptFactory = new Receipt1Factory();
        }
        IReceipt iReceipt = receiptFactory.newInstance(dummy);

        String font = iReceipt.font();
        String css = iReceipt.css();
        String html = iReceipt.html(dummy);

        LocalTime nowTime = LocalTime.now();
        LocalDateTime nowDateTime = LocalDateTime.now();

        String formatedNow = nowDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        // TODO: 2023-05-07 : 결제 데이터와 결재 데이터에 들어가야할 항목들의 차이는?
        // => 결제 클래스와, 결재 클래스를 나눈다.
        // => "결제"건에 대한 영수증은 패턴을 통해 여러가지 출력하도록.
        // => "결재"건에 대한 OCR 영수증은 하나로 통일.

        try {

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
            ImageIO.write(image, "png", new File(formatedNow+dummy.getUser()+"_test.png"));

            System.out.println("이미지 파일 생성 성공");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


