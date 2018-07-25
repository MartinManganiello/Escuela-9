package ar.edu.eest9.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public final class Message {

    private static String message;

    public static void showMessage(String title, String msg) {
        FacesContext
                .getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(title,msg));
    }

}
