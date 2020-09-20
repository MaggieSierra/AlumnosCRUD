package listaAlumnos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 

@WebServlet("/DeleteServlet")  
public class DeleteServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		//Cookie ck[]=request.getCookies();  
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(false);  
	    if(session!=null){  
	    	//String name=ck[0].getValue();  
	    	String name=(String)session.getAttribute("name");
	        if(!name.equals("")||name!=null){ 
	        	int id = Integer.parseInt(request.getParameter("id"));  
	            AlumDAO.delete(id);  
	            out.print("<p style='color: red; font-weight: bold;'>¡Registro eliminado correctamente!</p>");  
                request.getRequestDispatcher("ViewServlet").include(request, response);  
	        }
	    }else {
            request.getRequestDispatcher("login.html").include(request, response);  
	    }
         
    }  
}  