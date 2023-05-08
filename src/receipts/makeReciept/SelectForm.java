package receipts.makeReciept;

import DTO.Dummy;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import org.w3c.dom.ls.LSOutput;
import receipts.IReceipt;
import receipts.ReceiptFactory;
import receipts.receiptFactory.Receipt1Factory;
import receipts.receiptFactory.Receipt2Factory;
import receipts.receiptFactory.Receipt3Factory;
import receipts.receiptFactory.Receipt4Factory;
import receipts.receiptFactory.Receipt5Factory;
import receipts.receiptFactory.Receipt6Factory;

public class SelectForm {


    public boolean SelectForm() {

        ReceiptFactory receiptFactory = null;

        Dummy data = makingDummy.dummyData();

        Random rd = new Random();
        int i = rd.nextInt(6);
        System.out.println(i);
        switch ( i + 1) {
            case 6:
                receiptFactory = new Receipt6Factory();
                break;
            case 5:
                receiptFactory = new Receipt5Factory();
                break;
            case 4:
                receiptFactory = new Receipt4Factory();
                break;
            case 3:
                receiptFactory = new Receipt3Factory();
                break;
            case 2:
                receiptFactory = new Receipt2Factory();
                break;
            default:
                receiptFactory = new Receipt1Factory();
        }

        IReceipt iReceipt = receiptFactory.newInstance(data);

//    if() {
//        System.out.println("success");
//    } else {
//        System.out.println("fail");
//    }

        String font = iReceipt.font();
        String css = iReceipt.css();
        String html = iReceipt.html(makingDummy.dummyData());

        LocalDateTime nowDateTime = LocalDateTime.now();

        String formatedNow = nowDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

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
            editorPane.setSize(new Dimension(585, 580 + data.getObj().size() * 34));

            // HTML을 이미지로 렌더링
            BufferedImage image = new BufferedImage(editorPane.getWidth(), editorPane.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = image.createGraphics();
            editorPane.print(graphics);

            // 이미지 파일로 저장
            ImageIO.write(image, "png", new File(formatedNow + data.getUser() + "_test.png"));

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
