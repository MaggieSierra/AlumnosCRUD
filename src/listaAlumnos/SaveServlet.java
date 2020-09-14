package listaAlumnos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();  
		Cookie ck[]=request.getCookies();  
	    if(ck!=null){  
	    	String name=ck[0].getValue();  
	        if(!name.equals("")||name!=null){ 
	        	String no_control = request.getParameter("no_control");  
	    	    String nombre = request.getParameter("nombre");
	            String curso = request.getParameter("curso");
	            String semestre = request.getParameter("semestre");
	    			
	            Alumno a = new Alumno();  
	            a.setNo_control(no_control);  
	            a.setNombre(nombre);  
	            a.setCurso(curso);  
	            a.setSemestre(Integer.parseInt(semestre));
	            
	            int status = AlumDAO.save(a);  
	            if(status>0){  
	                out.print("<p style='color: green; font-weight: bold;'>¡Registro guardado con éxito!</p>");  
	                request.getRequestDispatcher("index.html").include(request, response);  
	            }else{  
	                out.println("p style='color: red; font-weight: bold;'>Sorry! Registro no guardado!</p>"); 
	                request.getRequestDispatcher("index.html").include(request, response); 
	            }  
	        }
	    }else {
            request.getRequestDispatcher("login.html").include(request, response);  
	    }
	    
          
        out.close();
	}

}
