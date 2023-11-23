package br.com.fiap.janusGs.model;

public class Site {
	private Medico medico;
	private Remedio remedio;
	private Paciente paciente;
	private Sintomas sintomas;
	private Consulta consulta;
	

	public Site(Medico medico, Remedio remedio, Paciente cliente, Sintomas marca, Consulta modelo) {
		super();
		this.medico = medico;
		this.remedio = remedio;
		this.paciente = cliente;
		this.sintomas = marca;
		this.consulta = modelo;
	}

	@Override
	public String toString() {
		return "Site [medico=" + medico + ", remedio=" + remedio + ", paciente=" + paciente + ", sintomas=" + sintomas
				+ ", consulta=" + consulta + "]";
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Remedio getRemedio() {
		return remedio;
	}

	public void setRemedio(Remedio remedio) {
		this.remedio = remedio;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Sintomas getSintomas() {
		return sintomas;
	}

	public void setSintomas(Sintomas sintoma) {
		this.sintomas = sintoma;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	
}
