package listaAlumnos;

public class Alumno {
	private int id;
	private String no_control;
	private String nombre;
	private String curso;
	private int semestre;
	
	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNo_control() {
		return no_control;
	}
	public void setNo_control(String no_control) {
		this.no_control = no_control;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
}
