package br.com.fiap.janusGs.model;

public class Sintomas {
	private int idSintoma;
	private String dsSintoma;
	private String dtInicio;
	private String dtFim;

	public Sintomas(int idSintoma, String dsSintoma, String dtInicio, String dtFim) {
		super();
		this.idSintoma = idSintoma;
		this.dsSintoma = dsSintoma;
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
	}

	public int getIdSintoma() {
		return idSintoma;
	}

	public void setIdSintoma(int idSintoma) {
		this.idSintoma = idSintoma;
	}

	public String getDsSintoma() {
		return dsSintoma;
	}

	public void setDsSintoma(String dsSintoma) {
		this.dsSintoma = dsSintoma;
	}

	public String getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getDtFim() {
		return dtFim;
	}

	public void setDtFim(String dtFim) {
		this.dtFim = dtFim;
	}
	 
}
