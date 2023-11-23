package br.com.fiap.janusGs.model;

public class Paciente {
	private int idPaciente;
	private String nmPaciente;
	private String dtNascimento;
	private String cpf;
	private String dsEmail;
	private int dsPeso;
	private int dsAltura;

	public Paciente(int idPaciente, String nmPaciente, String dtNascimento, String cpf, String dsEmail, int dsPeso, int dsAltura) {
		super();
		this.idPaciente = idPaciente;
		this.nmPaciente = nmPaciente;
		this.dtNascimento = dtNascimento;
		this.cpf = cpf;
		this.dsEmail = dsEmail;
		this.dsPeso = dsPeso;
		this.dsAltura = dsAltura;
	}
	
	public int getDsPeso() {
		return dsPeso;
	}

	public void setDsPeso(int dsPeso) {
		this.dsPeso = dsPeso;
	}

	public int getDsAltura() {
		return dsAltura;
	}

	public void setDsAltura(int dsAltura) {
		this.dsAltura = dsAltura;
	}
	
	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int cdCliente) {
		this.idPaciente = cdCliente;
	}

	public String getNmPaciente() {
		return nmPaciente;
	}

	public void setNmPaciente(String nmCliente) {
		this.nmPaciente = nmCliente;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}
	
	public Paciente(String dsEmail) {
		super();
		this.dsEmail = dsEmail;
	}
	
	public Paciente() {
		super();
	}
	
}
