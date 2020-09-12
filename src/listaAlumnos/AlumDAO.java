package listaAlumnos;

import java.util.*;
import java.sql.*;

public class AlumDAO {
	
	public static int save(Alumno a) {
		int status = 0;
		try {
			Connection con = Conexion.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into alumnos(no_control,nombre,curso,semestre) values (?,?,?,?)");
			ps.setString(1, a.getNo_control());
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getCurso());
			ps.setInt(4, a.getSemestre());

			status = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Alumno a) {
		int status = 0;
		try {
			Connection con = Conexion.getConnection();
			PreparedStatement ps = con.prepareStatement("update alumnos set no_control=?,nombre=?,curso=?,semestre=? where id_alumno=?");
			ps.setString(1, a.getNo_control());
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getCurso());
			ps.setInt(4, a.getSemestre());
			ps.setInt(5, a.getId());

			status = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = Conexion.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from alumnos where id_alumno=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Alumno getAlumnoById(int id) {
		Alumno a = new Alumno();

		try {
			Connection con = Conexion.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from alumnos where id_alumno=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				a.setId(rs.getInt(1));
				a.setNo_control(rs.getString(2));
				a.setNombre(rs.getString(3));
				a.setCurso(rs.getString(4));
				a.setSemestre(rs.getInt(5));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return a;
	}

	public static List<Alumno> getAllAlumnos() {
		List<Alumno> list = new ArrayList<Alumno>();

		try {
			Connection con = Conexion.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from alumnos");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Alumno a = new Alumno();
				a.setId(rs.getInt(1));
				a.setNo_control(rs.getString(2));
				a.setNombre(rs.getString(3));
				a.setCurso(rs.getString(4));
				a.setSemestre(rs.getInt(5));
				list.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public static List<Alumno> buscarAlumno(String texto) {
		List<Alumno> list = new ArrayList<Alumno>();
		
		try {
			Connection con = Conexion.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from alumnos where no_control like ? or nombre like ? or curso like ? or semestre like ?");
			ps.setString(1, "%"+texto+"%");
			ps.setString(2, "%"+texto+"%");
			ps.setString(3, "%"+texto+"%");
			ps.setString(4, "%"+texto+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Alumno a = new Alumno();
				a.setId(rs.getInt(1));
				a.setNo_control(rs.getString(2));
				a.setNombre(rs.getString(3));
				a.setCurso(rs.getString(4));
				a.setSemestre(rs.getInt(5));
				list.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}