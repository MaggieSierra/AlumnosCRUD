package listaAlumnos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter(); 
        Cookie ck[]=request.getCookies();  
	    if(ck!=null){  
	    	String name=ck[0].getValue();  
	        if(!name.equals("")||name!=null){
	        	out.print("<html><head><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\"></head>");
	            out.print("<ul class='nav nav-tabs'><li class='nav-item'>"
	    	    +"<a class='nav-link' href='index.html'>Agregar alumno</a></li>"
	    	    +"<li class='nav-item'><a class='nav-link' href='ViewServlet'>Ver lista de alumnos</a></li><li class=\"nav-item\">\r\n" + 
	    	    "	    <a class=\"nav-link\" href=\"LogoutServlet\">Cerrar Sesion</a>\r\n" + 
	    	    "	  </li></ul>");
	            
	            out.println("<body><div class=\"container\" style=\"padding-top: 20px;\"><h2>Editar Alumno</h2>");
	            
	            String sid=request.getParameter("id");  
	            int id=Integer.parseInt(sid);  
	              
	            Alumno a= AlumDAO.getAlumnoById(id); 
	            
	            out.print("<form action='EditServlet2' method='post'>");  
	            out.print("<table>");  
	            out.print("<tr><td></td><td><input type='hidden' name='id' class='form-control' required value='"+a.getId()+"'/></td></tr>");  
	            out.print("<tr><td>No. Control:</td><td><input type='text' name='no_control' required class='form-control' value='"+a.getNo_control()+"'/></td></tr>");  
	            out.print("<tr><td>Nombre:</td><td><input type='text' name='nombre' class='form-control' required value='"+a.getNombre()+"'/></td></tr>");     
	            out.print("<tr><td>Curso: </td><td><select name='curso' class='form-control'>");  
	            out.print("<option value='CO'>Ordinario</option>");  
	            out.print("<option value='CR'>Repetición</option>");  
	            out.print("<option value='CE'>Especial</option>");  
	            out.print("</select>");  
	            out.print("</td></tr>");  
	            out.print("<tr><td>Semestre:</td><td><input type='number' name='semestre' class='form-control' required value='"+a.getSemestre()+"'/></td></tr>");
	            out.print("<tr><td colspan='2' style='text-align:center;'><input type='submit' class=\"btn btn-success\" value='Actualizar'/></td></tr>");  
	            out.print("</table>");  
	            out.print("</form></div></body></html>");
	        }
	    }else {
            request.getRequestDispatcher("login.html").include(request, response);  
	    } 
          
        out.close();  
    }  
}  