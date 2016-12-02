package edu.stevens.XDF.importPDF;

/*
 * @author: Xiaolu Wang
 * Instructions:
 * 1.Library needed:
 *   pdfbox-1.3.1:http://www.java2s.com/Code/Jar/p/Downloadpdfbox131jar.htm
 *   pdfbox 1.8.12: https://pdfbox.apache.org/download.cgi
 *   
 */
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
public class PDFtoImage {
    public static void main(String[] args) {
        try {
            String sourceDir = "C:/Users/Xiaolu/Desktop/Java 810/Project/image";// Paste pdf files in PDFCopy folder to read
            String destinationDir = "C:/Users/Xiaolu/Desktop/Java 810/Project";
            File oldFile = new File(sourceDir);
            if (oldFile.exists()) {
            PDDocument document = PDDocument.load(oldFile);

            List<PDPage> list = document.getDocumentCatalog().getAllPages();

            String fileName = oldFile.getName().replace(".pdf", "_cover");
            int totalImages = 1;
            for (PDPage page : list) {
                PDResources pdResources = page.getResources();

                Map pageImages = pdResources.getXObjects();
                if (pageImages != null) {

                    Iterator imageIter = pageImages.keySet().iterator();
                    while (imageIter.hasNext()) {
                        String key = (String) imageIter.next();
                        PDXObjectImage pdxObjectImage = (PDXObjectImage) pageImages.get(key);
                        pdxObjectImage.write2file(destinationDir + fileName+ "_" + totalImages);
                        totalImages++;
                    }
                }
            }
        } else {
            System.err.println("File not exists");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}