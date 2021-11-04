package com.bbbaden.preparation_lb133;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.jdom2.JDOMException;

/**
 *
 * @author jannis
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String username, password;
    private final String correctUsername = "User1", correctPw = "1234";
    @Inject

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String doLogin() throws JDOMException{
        if (username.equals(correctUsername) && password.equals(correctPw)) {
            new Logger().createLoginLog(username, password);
            return "/loggedIn.xhtml";
        }
        return "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
