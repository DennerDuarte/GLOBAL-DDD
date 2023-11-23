package br.com.fiap.janusGs.model;

public class Consulta {
	
	private int idConsulta;
	private String dtConsulta;

	public Consulta(int idConsulta, String dtConsulta) {
		super();
		this.idConsulta = idConsulta;
		this.dtConsulta = dtConsulta;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public String getDtConsulta() {
		return dtConsulta;
	}
	
	public void setDtConsulta(String dtConsulta) {
		this.dtConsulta = dtConsulta;
	}

}
