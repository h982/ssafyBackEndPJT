
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileOutputStream;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class makeXML {
	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		String path = "res/addr.txt";
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        
        // 법정동 엘리먼트
        Document doc = docBuilder.newDocument();
        
        doc.setXmlStandalone(true); //standalone="no" 를 없애준다.
        
        Element items = doc.createElement("items");
        doc.appendChild(items);
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
		                        new FileInputStream(path), "euc-kr"))) {
			String line;
			// 첫 번째줄의 열의 이름을 제거
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] token = line.split("\t");
				
				if (token[2].equals("폐지")) {
					continue;
				}
				
				try
		        {// item 엘리먼트
		            Element item = doc.createElement("item");
		            items.appendChild(item);
		 
		            // code 엘리먼트
		            Element code = doc.createElement("code");
		            code.appendChild(doc.createTextNode(token[0]));
		            item.appendChild(code);
		 
		            // name 엘리먼트
//		            Element name = doc.createElement("name");
//		            name.appendChild(doc.createTextNode(token[1]));
//		            item.appendChild(name);
		            
		            String[] st = token[1].split(" ");
		            
		            String[] div = {"도", "시", "군", "구", "읍", "면", "리", "동", "로", "가"};
		            int idx = 0;
		            for (int i = 0; i < div.length; ++i) {
		            	Element val = doc.createElement(div[i]);
		            	if (idx < st.length && Character.toString(st[idx].charAt(st[idx].length() - 1)).equals(div[i])) {
		            		val.appendChild(doc.createTextNode(st[idx++]));
		            	}
		            	else {
		            		val.appendChild(doc.createTextNode(" "));
		            	}
		            	item.appendChild(val);
		            }
		        }catch (Exception e){
		            e.printStackTrace();
		        }
			}
			
			// XML 파일로 쓰기
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
 
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); //정렬 스페이스4칸
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //들여쓰기
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes"); //doc.setXmlStandalone(true); 했을때 붙어서 출력되는부분 개행
 
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileOutputStream(new File("res/addr.xml")));
 
            transformer.transform(source, result);
 
            System.out.println("=========END=========");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
