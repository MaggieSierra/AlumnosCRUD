package Usuarios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	     PrintWriter out=response.getWriter();   
	     
		 Cookie cks[] = request.getCookies();
			if (cks != null) {
				String name = cks[0].getValue();
				if (!name.equals("") || name != null) {
			        Cookie ck=new Cookie("name","");  
			        ck.setMaxAge(0); 
			        response.addCookie(ck);  
			        out.print("Has cerrado sesión exitosamente!");
			        response.sendRedirect("login.html");
				}
			} else {
				request.getRequestDispatcher("login.html").include(request, response);
			}
			out.close();
	}

	

}
