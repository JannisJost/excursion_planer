package com.bbbaden.excursion_plan;

import java.io.IOException;
import javax.faces.context.FacesContext;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Jannis
 */
public class XMLManager {

    public XMLManager() {
        try {
            String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
            path = path + "WEB-INF\\Log.xml";
            Document doc = new SAXBuilder().build(path);

        } catch (IOException | JDOMException e) {
            System.err.println("ahhhhhhhhhh" +e);
        }

    }

}
