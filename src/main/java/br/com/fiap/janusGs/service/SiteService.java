package br.com.fiap.janusGs.service;

import java.sql.SQLException;

import br.com.fiap.janusGs.data.PacienteDao;
import br.com.fiap.janusGs.data.SiteDao;
import br.com.fiap.janusGs.model.Paciente;
import br.com.fiap.janusGs.model.Site;


public class SiteService {
	
	public static boolean create(Site site) {
		if(!validar(site)) {
			return false;
		}
		
		try {
			SiteDao.create(site);
		}
		catch(Exception e){	
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	private static boolean validar(Site site) {
		if(site.getMedico() == null) return false;
		try {
			// Procura se o email do paciente existe
			var clientes = PacienteDao.findAll();
			for (Paciente clienteProcurado : clientes) {
				if(clienteProcurado.getDsEmail().equals(site.getPaciente().getDsEmail())) return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
