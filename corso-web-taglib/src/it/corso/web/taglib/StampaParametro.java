package it.corso.web.taglib;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class StampaParametro extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int doEndTag() throws JspException {

		//prendiamo la request, con pageContext e la mettiamo nella variabile req
		HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
		try {
			// dentro l'oggetto pageContext, abbiamo il metodo getOut() che ritorna il jsp writer, l'oggetto che si occuperà x noi di scrivere nell'html
			JspWriter writer = pageContext.getOut();
			// supponiamo che il nome del parametro si chiama utente
			if(req.getParameter("utente") != null) {	
				//stampiamo col writer nell'html il valore del parameter "utente", analogamente come facciamo all'interno di una jsp
				writer.println("Ciao "+ req.getParameter("utente"));
			} else {
				writer.print("Ciao, clicca per registrarti!");// potremmo mettere un link x registrarsi
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return super.doEndTag();
	}
}
