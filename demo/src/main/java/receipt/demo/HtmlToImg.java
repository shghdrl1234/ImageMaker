package receipt.demo;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.xhtmlrenderer.simple.ImageRenderer;
import org.xhtmlrenderer.swing.Java2DRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HtmlToImg {
//    private final String templateFilePath;
//
//    public HtmlToImg(String templateFilePath) {
//        this.templateFilePath = templateFilePath;
//    }
//
//    public void convertAndSave(String message, String outputFilePath) throws IOException {
//        String renderedHtml = HtmlToStringConverter.render(templateFilePath, message);
//        BufferedImage image = HtmlToImageConverter.convertToImage(renderedHtml);
//        ImageIO.write(image, "png", new File(outputFilePath));
//    }
//}
//
//class HtmlToStringConverter {
//    public static String render(String templateFilePath, String message) throws IOException {
//        // Thymeleaf template engine 생성
//        TemplateEngine templateEngine = new TemplateEngine();
//
//        // 가져올 테플릿 경로 지정
//        File htmlFile = new File(templateFilePath);
//
//        // Thymeleaf template resolver 생성
////        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
////        templateResolver.setPrefix("/templates");
////        templateResolver.setSuffix(".html");
////        templateResolver.setTemplateMode(TemplateMode.HTML);
////        templateEngine.setTemplateResolver(templateResolver);
//
//        // 컨텍스트 생성 (키, 값) 생성
//        Context context = new Context();
//        context.setVariable("message", message);
//
//        // 템플릿 렌더링
////        String template = FileUtils.readFileToString(new File(htmlString), "UTF-8");
//
//        // 템플릿에 코드를 문자열로 변경
//        String htmlString = FileUtils.readFileToString(htmlFile, "UTF-8");
//
//
//        String hi = templateEngine.process(htmlString, context);
////        System.out.println("tlqkf skdhssk"+hi);
//
//        // 컨텍스트 변수를 템플릿 코드에 저장
//        return hi;
//
//    }
//}
//
//class HtmlToImageConverter {
//    public static BufferedImage convertToImage(String html) {
//        // JSoup 라이브러리를 사용하여 HTML 파싱
//        Document document = Jsoup.parse(html);
//        Element body = document.body();
//
////        // JSoup 결과를 Renderer로 변환하여 BufferedImage로 생성
////        Java2DRenderer renderer = new Java2DRenderer("dummy-id", 600,  800);
////
////        return renderer.getImage();
//
//        // HTML 파서 결과를 ImageRenderer로 변환하여 BufferedImage로 생성
//        ImageRenderer renderer = new ImageRenderer();
//
//        ImageRenderer.renderToImage(templateFilePath, body,10);
//
//        return renderer;
//        return renderer;
//        return renderer;
//    }
}