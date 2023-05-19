package make.aibot.controller;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.styledxmlparser.jsoup.Jsoup;
import com.itextpdf.styledxmlparser.jsoup.nodes.Element;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
@RequestMapping("/make")
@RequiredArgsConstructor
public class HtmlToImg {

    private final TemplateEngine templateEngine;

    @PostMapping
    public String makeImg(@RequestBody Map map) throws IOException, URISyntaxException {

        Context context = new Context();
        context.setVariables(map);

        String processedHtml = templateEngine.process("test1.html", context);

//        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//        templateResolver.setPrefix("/templates/"); // 템플릿 파일이 위치하는 디렉토리 경로
//        templateResolver.setSuffix(".html"); // 템플릿 파일의 확장자
//        System.out.println(processedHtml);

        URL resourceUrl = getClass().getResource("/templates/test1.html");
        File templateFile = new File(resourceUrl.toURI());
        com.itextpdf.styledxmlparser.jsoup.nodes.Document doc = Jsoup.parse(templateFile, "UTF-8");


//        Element divElement = doc.select("div.container").first();
//        //// <div> 요소의 크기 정보 추출
//        String width = divElement.attr("width");
//        String height = divElement.attr("height");
//        System.out.println("gd" + width + height);

//        templateEngine.setTemplateResolver(templateResolver);

        String html = processedHtml;
//        String font = "C:\\Users\\교육생11\\Desktop\\arial.ttf";
        ConverterProperties properties = new ConverterProperties();
//        FontProvider fontProvider = new DefaultFontProvider(false, false, false);
//        FontProgram fontProgram = FontProgramFactory.createFont(font);
//        fontProvider.addFont(fontProgram);
//        properties.setFontProvider(fontProvider);

        //pdf 페이지 크기를 조정
        List<IElement> elements = HtmlConverter.convertToElements(html, properties);
        PdfDocument pdf = new PdfDocument(new PdfWriter("output5.pdf"));

        PageSize customPageSize = new PageSize(281.25f, 375);
        pdf.setDefaultPageSize(customPageSize);


        Document document = new Document(pdf);

        //setMargins 매개변수순서 : 상, 우, 하, 좌
        document.setMargins(0, 0, 0, 0);
        for (IElement element : elements) {
            document.add((IBlockElement) element);
        }
        document.close();

        return "성공";
    }

}
