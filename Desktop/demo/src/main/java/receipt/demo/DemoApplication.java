package receipt.demo;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.styledxmlparser.css.media.MediaDeviceDescription;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.ldap.LdapProperties.Template;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


//		TemplateEngine 생성
		TemplateEngine templateEngine = new TemplateEngine();
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("/templates/"); // 템플릿 파일이 위치하는 디렉토리 경로
		templateResolver.setSuffix(".html"); // 템플릿 파일의 확장자
		templateEngine.setTemplateResolver(templateResolver);

		// Thymeleaf 템플릿 내용을 처리할 컨텍스트 생성
		Context thymeleafContext = new Context();
		// 필요한 경우에 변수와 값을 설정 (예: thymeleafContext.setVariable("name", "John");)

		// 템플릿 처리 결과를 문자열로 얻기
		String processedTemplate = templateEngine.process("test1.html", thymeleafContext);


		try {

			ConverterProperties converterProperties = new ConverterProperties();
			converterProperties.setBaseUri("file:///path/to/your/html/files/"); // 기본 URI 설정

			PageSize pageSize = new PageSize(PageSize.A4);
			converterProperties.setMediaDeviceDescription()setLimitOfLayouts(pageSize);

			String htmlContent = processedTemplate;
			String modifiedHtmlContent = modifyHtmlContent(htmlContent);

			// HTML을 로드하여 PDF로 변환
			File outputFile = new File("output2.pdf");
			FileOutputStream outputStream = new FileOutputStream(outputFile);
			HtmlConverter.convertToPdf(modifiedHtmlContent, outputStream, converterProperties);
			outputStream.close();

			System.out.println("HTML을 PDF로 변환 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String modifyHtmlContent(String htmlContent) {
		// HTML 내용을 수정하여 원하는 페이지 크기에 맞게 조정하는 로직을 구현
		// 예시로는 HTML의 <body> 태그에 width와 height 속성을 추가하는 방법을 사용
		// 실제로는 원하는 방식으로 HTML 내용을 수정해야 함
		return htmlContent.replace("<body>", "<body style=\"width: 11800px; height: 11600px;\">");
	}
}

//	public TemplateEngine templateEngine() {
//		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//		templateEngine.addTemplateResolver(htmlTemplateResolver());
//		return templateEngine;
//	}
//
//	@Bean
//	public ClassLoaderTemplateResolver htmlTemplateResolver() {
//		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//		templateResolver.setPrefix("/templates/");
//		templateResolver.setSuffix(".html");
//		templateResolver.setTemplateMode("HTML");
//		templateResolver.setCharacterEncoding("UTF-8");
//		return templateResolver;
//	}
//
//	@Bean
//	public ITextRenderer textRenderer() throws DocumentException, IOException {
//		ITextRenderer textRenderer = new ITextRenderer();
//		textRenderer.getFontResolver().addFont("/bahnschrift.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED); // 폰트 파일 경로와 설정 추가
//		return textRenderer;
//	}
//
//
//
//	// REST endpoint to generate image from HTML
//	@RestController
//	public class HtmlToImageController {
//
//		private final TemplateEngine templateEngine;
//		private final ITextRenderer textRenderer;
//
//		public HtmlToImageController(TemplateEngine templateEngine, ITextRenderer textRenderer) {
//			this.templateEngine = templateEngine;
//			this.textRenderer = textRenderer;
//		}
//
//		@PostMapping("/convert")
//		public void convertHtmlToImage(@RequestBody Map<String, Object> data, HttpServletResponse response) throws IOException, DocumentException {
//			Context context = new Context();
//			context.setVariables(data);
//
//			String processedHtml = templateEngine.process("test1.html", context); // Replace "your_template_name" with the actual name of your HTML template
//
//			String outputFile = "C:\\Users\\교육생11\\Desktop\\aaaa\\d1d.pdf"; // Replace "path_to_output_image.png" with the desired output file path
//
//			Document document = new Document(PageSize.A4); // Replace PageSize.A4 with the desired page size
//
//			// Create a PdfWriter to write the document to the output file
//			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));
//
//			// Open the document for writing
//			document.open();
//
//			// Set the HTML content as the document's content
//			XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(processedHtml.getBytes()));
//
//			// Close the document
//			document.close();
//
//			textRenderer.setDocumentFromString(processedHtml);
//			textRenderer.layout();
//			try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
//				textRenderer.createPDF(outputStream);
//			}
//
//			// Optionally, you can return the image file path or other response as needed
//			response.setStatus(HttpServletResponse.SC_OK);
//			response.setContentType("text/plain");
//			response.getWriter().write("Image generated successfully!");
//
//			String outputFile2 = "C:\\Users\\교육생11\\Desktop\\aaaa\\d1d.png"; // Replace with the desired output image path
//			String pdfFile = outputFile; // Replace with the input PDF file path
//
//			try (PDDocument document = PDDocument.load(new File(pdfFile))) {
//				PDFRenderer pdfRenderer = new PDFRenderer(document);
//				BufferedImage image = pdfRenderer.renderImageWithDPI(0, 300); // Render the first page at 300 DPI
//				ImageIOUtil.writeImage(image, outputFile2, 300); // Save the image at 300 DPI
//			} catch (IOException e) {
//				// Handle exception
//			}
//		}
//	}
