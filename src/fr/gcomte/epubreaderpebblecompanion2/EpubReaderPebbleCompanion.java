/**
 * 
 */
package fr.gcomte.epubreaderpebblecompanion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * @author comte_g
 *
 */
public class EpubReaderPebbleCompanion {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws TransformerException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, TransformerException {
//		Book book = new EpubReader().readEpub(new FileInputStream(new File("C:/Users/comte_g/Documents/Docs persos/Royal Assassin - Robin Hobb.epub")));
//		System.out.println(book.getTitle());
//		List<TOCReference> toc = book.getTableOfContents().getTocReferences();
//		for (TOCReference ref : toc) {
//			System.out.println(ref.getTitle() + " - " + ref.getCompleteHref() + " - " + ref.getResource().getMediaType().getName() + " - " + ref.getResource().getReader());
//			if (ref.getResource().getMediaType().getName().equalsIgnoreCase("application/xhtml+xml")) {
//				XmlStreamReader reader = (XmlStreamReader) ref.getResource().getReader();
//				reader.
//			}
//		}
		File xsltFile = new File("res/markdown.xsl");
		
		Source xmlSource = new StreamSource("res/index_split_004.html");
		Source xsltSource = new StreamSource(xsltFile);
		
		TransformerFactory transFact = TransformerFactory.newInstance();
		Transformer trans = transFact.newTransformer(xsltSource);
		
		StringWriter result = new StringWriter();
		trans.transform(xmlSource, new StreamResult(result));
		
		System.out.println(result.toString().replaceAll("\\<.*?>","").replaceAll("\\\n\\\n", "\n"));
	}

}
