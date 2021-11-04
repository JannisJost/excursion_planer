package com.bbbaden.preparation_lb133;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Jannis
 */
@ApplicationScoped
@Named(value = "logger")
public class Logger {

    private Element rootElement;
    private File entriesXML;
    private String usedName, usedPassword;

    public Logger() throws JDOMException {
        String contextPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
        File webINFPath = new File(contextPath, "WEB-INF");
        entriesXML = new File(webINFPath, "Log.xml");
        SAXBuilder entriesBuilder = new SAXBuilder();

        try {
            Document document = (Document) entriesBuilder.build(entriesXML);
            this.rootElement = document.getRootElement();
        } catch (IOException ex) {
        }
    }

    public void createLoginLog(String usedName, String usedPassword) {
        try {
            Element user = new Element("user");
            Element name = new Element("name");
            Element password = new Element("password");
            name.setText(usedName);
            password.setText(usedPassword);
            user.addContent(name);
            user.addContent(password);
            rootElement.addContent(user);
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(this.rootElement, new FileWriter(entriesXML));
        } catch (IOException e) {
            System.err.println("TEST" + e);
        }
    }
}
