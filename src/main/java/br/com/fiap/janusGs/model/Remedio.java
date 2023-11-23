package br.com.fiap.janusGs.model;

public class Remedio {
	private int idRemedio;
	private String nmRemedio;
	private String dtInicio;
	private String dtFim;
	private int intervalo;


	public Remedio(int idRemedio, String nmRemedio, String dtInicio, String dtFim, int intervalo) {
		super();
		this.idRemedio = idRemedio;
		this.nmRemedio = nmRemedio;
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
		this.intervalo = intervalo;
	}
	
	public int getIdRemedio() {
		return idRemedio;
	}

	public void setIdRemedio(int idRemedio) {
		this.idRemedio = idRemedio;
	}

	public String getNmRemedio() {
		return nmRemedio;
	}

	public void setNmRemedio(String nmRemedio) {
		this.nmRemedio = nmRemedio;
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

	public int getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}


}
