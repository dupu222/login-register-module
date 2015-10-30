package cn.dp.utils;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by pu on 2015/10/30 0030.
 */
public class Dom4jUtils {
    private static String path;

    static {
        path = Dom4jUtils.class.getClassLoader().getResource("users.xml").getPath();
    }

    public static Document getDocument() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(path);
        return document;
    }

    public static void write2xml(Document document) throws Exception {
        OutputStream outputStream = new FileOutputStream(path);
        XMLWriter writer = new XMLWriter(outputStream);
        writer.write(document);
        writer.close();
    }

}
