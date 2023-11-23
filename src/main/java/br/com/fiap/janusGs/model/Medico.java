package br.com.fiap.janusGs.model;

public class Medico {
	private int idMedico;
	private String nmMedico;
	private int crm;
	private String unidadadeFederativa;
	
	public Medico(int idMedico, String nmMedico, int crm, String unidadeFederativa) {
		super();
		this.idMedico = idMedico;
		this.nmMedico = nmMedico;
		this.crm = crm;
		this.unidadadeFederativa = unidadeFederativa;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public String getUnidadadeFederativa() {
		return unidadadeFederativa;
	}

	public void setUnidadadeFederativa(String unidadadeFederativa) {
		this.unidadadeFederativa = unidadadeFederativa;
	}

	public String getNmMedico() {
		return nmMedico;
	}

	public void setNmMedico(String nmAcessorio) {
		this.nmMedico = nmAcessorio;
	}
	
}
