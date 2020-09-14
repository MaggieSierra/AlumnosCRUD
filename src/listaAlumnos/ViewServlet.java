package listaAlumnos;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;    

@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
		Cookie ck[]=request.getCookies();  
	    if(ck!=null){  
	    	String name=ck[0].getValue();
	        if(!name.equals("")||name!=null){  
	        	out.print("<html><head><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\"></head>");
	            out.print("<ul class='nav nav-tabs'><li class='nav-item'><a class='nav-link' href='index.html'>Agregar alumno</a></li>");
	            out.print("<li class='nav-item'><a class='nav-link active' href='#'>Ver lista de alumnos</a></li><li class=\"nav-item\">\r\n" + 
	            		"	    <a class=\"nav-link\" href=\"LogoutServlet\">Cerrar Sesion</a>\r\n" + 
	            		"	  </li></ul>");
	            out.println("<body><div class='container' style='padding-top: 20px;'><div class='navbar'><h2>Lista de Alumnos</h2>\r\n" + 
	            		"		<form class='form-inline' action='ViewServlet' method='post'>\r\n" + 
	            		"			<input type='search' name='txtBuscar' class='form-control' style='margin-right:15px;'>\r\n" + 
	            		"			<input type='submit' name='buscar' class='btn btn-outline-success' value='Buscar'>\r\n" + 
	            		"		</form>\r\n" + 
	            		"	</div>");  
	              
	            List<Alumno> list=AlumDAO.getAllAlumnos();  
	            
	            out.print("<table border='1' width='100%' class='table'>");  
	            out.print("<thead class='thead-dark'><tr><th>No.</th><th>No. Control</th><th>Nombre</th><th>Curso</th><th>Semestre</th>"
	            		+ "<th>Opciones</th></tr></thead><tbody>");  
	            for(Alumno a:list){  
	             out.print("<tr><td>"+a.getId()+"</td><td>"+a.getNo_control()+"</td><td>"+a.getNombre()+"</td>  "
	             		+ "<td>"+a.getCurso()+"</td><td>"+a.getSemestre()+"</td><td>"
	             		+ "<button class='btn btn-warning' style='margin-right:10px;'><a style='text-decoration: none; color:white;' href='EditServlet?id="+a.getId()+"'>Editar</a></button>"
	             		+ "<button class='btn btn-danger'><a style='text-decoration: none; color:white;' href='DeleteServlet?id="+a.getId()+"'>Eliminar</a></button></td></tr>");  
	            }  
	            
	            out.print("<tbody></table></div></body></html>");
	        }  
	    }else{   
            request.getRequestDispatcher("login.html").include(request, response);  
	    }  
          
        out.close();  
    }  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();  
		Cookie ck[]=request.getCookies();  
	    if(ck!=null){  
	    	String name=ck[0].getValue();
	        if(!name.equals("")||name!=null){
	        	String textBuscar = request.getParameter("txtBuscar");
				
	    		List<Alumno> list=AlumDAO.buscarAlumno(textBuscar); 
	    		out.print("<html><head><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\"></head>");
	            out.print("<ul class='nav nav-tabs'><li class='nav-item'><a class='nav-link' href='index.html'>Agregar alumno</a></li>");
	            out.print("<li class='nav-item'><a class='nav-link active' href='#'>Ver lista de alumnos</a></li><li class=\"nav-item\">\r\n" + 
	            		"	    <a class=\"nav-link\" href=\"LogoutServlet\">Cerrar Sesion</a>\r\n" + 
	            		"	  </li></ul>");
	            out.println("<body><div class='container' style='padding-top: 20px;'><div class='navbar'><h2>Lista de Alumnos</h2>\r\n" + 
	            		"		<form class='form-inline' action='ViewServlet' method='post'>\r\n" + 
	            		"			<input type='search' name='txtBuscar' class='form-control' style='margin-right:15px;'>\r\n" + 
	            		"			<input type='submit' name='buscar' class='btn btn-outline-success' value='Buscar'>\r\n" + 
	            		"		</form>\r\n" + 
	            		"	</div>"); 
	            
	    		 out.print("<table border='1' width='100%' class=\"table\">");  
	    	        out.print("<thead class='thead-dark'><tr><th>No.</th><th>No. Control</th><th>Nombre</th><th>Curso</th><th>Semestre</th><th>Opciones</th></tr></thead><tbody>");  
	    	        for(Alumno a:list){  
	    	         out.print("<tr><td>"+a.getId()+"</td><td>"+a.getNo_control()+"</td><td>"+a.getNombre()+"</td>  "
	    	         		+ "<td>"+a.getCurso()+"</td><td>"+a.getSemestre()+"</td><td>"
	    	         		+ "<button class='btn btn-warning' style='margin-right:10px;'><a style='text-decoration: none; color:white;' href='EditServlet?id="+a.getId()+"'>Editar</a></button>"
	    	         		+ "<button class='btn btn-danger'><a style='text-decoration: none; color:white;' href='DeleteServlet?id="+a.getId()+"'>Eliminar</a></button></td></tr>");  
	    	        }  
	    	        
	    	        if(list.size() == 0) {
	    	        	out.print("<tr><td colspan='6'  align='center'>No se encontraron resultado de <b>"+textBuscar+"</b></td></tr>");
	    	        }
	    	        
	    	        out.print("<tbody></table></div></body></html>");
	        }
	    }else {
            request.getRequestDispatcher("login.html").include(request, response);  
	    }
		
        out.close();
	}
}  
