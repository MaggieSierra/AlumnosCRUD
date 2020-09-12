package listaAlumnos;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        int id = Integer.parseInt(request.getParameter("id")); 
        String no_control = request.getParameter("no_control");  
        String nombre = request.getParameter("nombre");  
        String curso = request.getParameter("curso");  
        int semestre = Integer.parseInt(request.getParameter("semestre"));  
          
        Alumno a=new Alumno();  
        a.setId(id);  
        a.setNo_control(no_control);  
        a.setNombre(nombre);  
        a.setCurso(curso);  
        a.setSemestre(semestre);  
          
        int status=AlumDAO.update(a);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! No se pudo actualizar el registro!");  
        }  
          
        out.close();  
    }  
  
}  
