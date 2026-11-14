package ma.app.util;

import jakarta.servlet.http.HttpSession;

public class FlashMessage {
	public static void set(HttpSession session, String message) {
        session.setAttribute("message", message);
    }

    public static String consume(HttpSession session) {
        String message = (String) session.getAttribute("message");
        session.removeAttribute("message");
        return message;
    }
}
