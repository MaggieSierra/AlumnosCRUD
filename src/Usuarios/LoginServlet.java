package Usuarios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	PrintWriter out=response.getWriter();
    	Usuario user = new Usuario();
    	user.setUsername(request.getParameter("name"));
    	user.setPassword(request.getParameter("password"));
    	
    	user = UsuarioDAO.login(user);
    	
    	if(user.isValid()) {
    		Cookie ck=new Cookie("name",request.getParameter("name"));  
    		ck.setValue("");
    		ck.setMaxAge(600);
            response.addCookie(ck);
    		response.sendRedirect("index.html"); //logged-in page
    	}else {
    		out.print("Sorry, username or password error!"); 
    		response.sendRedirect("login.html");
    	}  
    	out.close();  
    }
}
