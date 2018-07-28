package ar.edu.eest9.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public final class Message {

    /*Clase dedicada a la impresión de mensajes a traves de FacesMessage*/
    private static String message;

    /**
     * Imprime un mensaje en pantalla. Sirve para imprimir mensajes cortos en
     * pantalla utilizando FacesMessage.
     *
     * @param title Titulo del mensaje
     * @param msg Mensaje en cuestión
     * @see Message
     */
    public static void showMessage(String title, String msg) {
        FacesContext
                .getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(title, msg));
    }

}
