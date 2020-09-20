package Usuarios;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		/*
		 * Cookie ck[] = request.getCookies(); if (ck != null) { String name =
		 * ck[0].getValue(); if (!name.equals("") || name != null) {
		 */
		HttpSession session = request.getSession(false);
		if (session != null) {
			out.print("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "	<meta charset=\"ISO-8859-1\">\r\n"
					+ "	<title>Aplicación CRUD utilizando servlets</title>\r\n"
					+ "	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n"
					+ "</head>\r\n" + "<body>\r\n" + "	<ul class=\"nav nav-tabs\">\r\n"
					+ "	  <li class=\"nav-item\">\r\n"
					+ "	    <a class=\"nav-link active\" href=\"#\">Agregar alumno</a>\r\n" + "	  </li>\r\n"
					+ "	  <li class=\"nav-item\">\r\n"
					+ "	    <a class=\"nav-link\" href=\"ViewServlet\">Ver lista de alumnos</a>\r\n" + "	  </li>\r\n"
					+ "	  <li class=\"nav-item\">\r\n"
					+ "	    <a class=\"nav-link\" href=\"LogoutServlet\">Cerrar Sesion</a>\r\n" + "	  </li>\r\n"
					+ "	</ul>\r\n" + "	<div class=\"container\" style=\"padding-top: 20px;\">\r\n"
					+ "	<h2>Agregar nuevo alumno</h2>\r\n"
					+ "	<form action=\"SaveServlet\" method=\"post\" style=\"margin-top:20px;\">\r\n"
					+ "		<table>\r\n" + "			<tr>\r\n" + "				<td>No. Control:</td>\r\n"
					+ "				<td><input type=\"text\" name=\"no_control\" class=\"form-control\" required /></td>\r\n"
					+ "			</tr>\r\n" + "			<tr>\r\n" + "				<td>Nombre:</td>\r\n"
					+ "				<td><input type=\"text\" name=\"nombre\" class=\"form-control\" required/></td>\r\n"
					+ "			</tr>\r\n" + "			<tr>\r\n" + "				<td>Curso:</td>\r\n"
					+ "				<td>\r\n" + "					<select name=\"curso\" class=\"form-control\">\r\n"
					+ "						<option value=\"CO\">Ordinario</option>\r\n"
					+ "						<option value=\"CR\">Repetición</option>\r\n"
					+ "						<option value=\"CE\">Especial</option>\r\n"
					+ "					</select>\r\n" + "				</td>\r\n" + "			</tr>\r\n"
					+ "			<tr>\r\n" + "				<td>Semestre:</td>\r\n"
					+ "				<td><input type=\"number\" name=\"semestre\" class=\"form-control\" required/></td>\r\n"
					+ "			</tr>\r\n"
					+ "			<tr><td colspan=\"2\" style=\"text-align: center;\"><input type=\"submit\" class=\"btn btn-success\" value=\"Guardar\"/></td></tr>\r\n"
					+ "		</table>\r\n" + "	</form>\r\n" + "	<br/>  \r\n" + "	\r\n" + "	</div>\r\n"
					+ "	\r\n" + "</body>\r\n" + "</html>");

		} else {
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
