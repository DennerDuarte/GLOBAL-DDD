package br.com.fiap.janusGs.service;

import java.sql.SQLException;

import br.com.fiap.janusGs.data.PacienteDao;
import br.com.fiap.janusGs.model.Paciente;

public class PacienteService {

	private static boolean validar(Paciente paciente) throws SQLException {
		if(paciente.getNmPaciente().length() < 3) return false;
		if(paciente.getCpf().length() < 11) return false;
		
		return true;
	}

	public static Object findAll() throws SQLException {
		return PacienteDao.findAll();
	}
	
	public static Object findById(int id) throws SQLException {
		return PacienteDao.findById(id);
	}

	public static boolean create(Paciente paciente){
				
		try {
			if(!validar(paciente)) {
				return false;
			}
			var pacientes = PacienteDao.findAll();
			for (Paciente pacienteBuscado : pacientes) {
				if(pacienteBuscado.getDsEmail().equals(paciente.getDsEmail())) return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			PacienteDao.create(paciente);
		}
		catch(Exception e){			
			return false;
		}
		return true;
	}
	
	public static boolean update(Paciente paciente) {
		try {
			if(!validar(paciente)) {
				return false;
			}
			if(PacienteDao.findById(paciente.getIdPaciente()) == null) return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			PacienteDao.update(paciente);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static void delete (Paciente id) throws SQLException {
		PacienteDao.delete(id);
	}

	public static void delete(int id) {
	}

}
