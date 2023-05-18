package receipt.demo;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
	}


	public TemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.addTemplateResolver(htmlTemplateResolver());
		return templateEngine;
	}

	@Bean
	public ClassLoaderTemplateResolver htmlTemplateResolver() {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML");
		templateResolver.setCharacterEncoding("UTF-8");
		return templateResolver;
	}

	@Bean
	public ITextRenderer textRenderer() throws DocumentException, IOException {
		ITextRenderer textRenderer = new ITextRenderer();
		textRenderer.getFontResolver().addFont("/bahnschrift.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED); // 폰트 파일 경로와 설정 추가
		return textRenderer;
	}



	// REST endpoint to generate image from HTML
	@RestController
	public class HtmlToImageController {

		private final TemplateEngine templateEngine;
		private final ITextRenderer textRenderer;

		public HtmlToImageController(TemplateEngine templateEngine, ITextRenderer textRenderer) {
			this.templateEngine = templateEngine;
			this.textRenderer = textRenderer;
		}

		@PostMapping("/convert")
		public void convertHtmlToImage(@RequestBody Map<String, Object> data, HttpServletResponse response) throws IOException, DocumentException {
			Context context = new Context();
			context.setVariables(data);

			String processedHtml = templateEngine.process("test1.html", context); // Replace "your_template_name" with the actual name of your HTML template

			String outputFile = "C:\\Users\\교육생11\\Desktop\\aaaa\\d1d.pdf"; // Replace "path_to_output_image.png" with the desired output file path


			textRenderer.setDocumentFromString(processedHtml);
			textRenderer.layout();
			try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
				textRenderer.createPDF(outputStream);
			}

			// Optionally, you can return the image file path or other response as needed
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("text/plain");
			response.getWriter().write("Image generated successfully!");

			String outputFile2 = "C:\\Users\\교육생11\\Desktop\\aaaa\\d1d.png"; // Replace with the desired output image path
			String pdfFile = outputFile; // Replace with the input PDF file path

			try (PDDocument document = PDDocument.load(new File(pdfFile))) {
				PDFRenderer pdfRenderer = new PDFRenderer(document);
				BufferedImage image = pdfRenderer.renderImageWithDPI(0, 300); // Render the first page at 300 DPI
				ImageIOUtil.writeImage(image, outputFile2, 300); // Save the image at 300 DPI
			} catch (IOException e) {
				// Handle exception
			}
		}
	}
}