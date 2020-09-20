package Usuarios;

import java.sql.*;

import listaAlumnos.Conexion;

public class UsuarioDAO {
	static ResultSet rs = null;

	public static Usuario login(Usuario bean) {

		String username = bean.getUsername();
		String password = bean.getPassword();
		try {
			Connection con = Conexion.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from usuarios where usuario=? and contraseña=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
			if (!more) {
				System.out.println("Sorry, you are not a registered user! Please sign up first");
				bean.setValid(false);
			} else if (more) {// if user exists set the isValid variable to true
				System.out.println("Welcome " + username);
				bean.setValid(true);
			}
		} catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		}

		return bean;

	}
}
