package br.com.fiap.janusGs.service;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.janusGs.data.PacienteDao;
import br.com.fiap.janusGs.model.Paciente;

public class PacienteService {

    private static boolean validar(Paciente paciente) {
        return paciente.getNmPaciente().length() >= 3 && paciente.getCpf().length() >= 11;
    }

    public static List<Paciente> findAll() throws SQLException {
        try {
            return PacienteDao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todos os pacientes", e);
        }
    }

    public static Paciente findById(int id) throws SQLException {
        try {
            return PacienteDao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar paciente por ID", e);
        }
    }

    public static boolean create(Paciente paciente) {
        try {
            if (!validar(paciente)) {
                return false;
            }

            List<Paciente> pacientes;
            pacientes = PacienteDao.findAll();

            for (Paciente pacienteBuscado : pacientes) {
                if (pacienteBuscado.getDsEmail().equals(paciente.getDsEmail())) {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao validar e criar paciente", e);
        }

        try {
            PacienteDao.create(paciente);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar paciente", e);
        }
        return true;
    }

    public static boolean update(Paciente paciente) {
        try {
            if (!validar(paciente)) {
                return false;
            }

            Paciente existingPaciente;
            existingPaciente = PacienteDao.findById(paciente.getIdPaciente());

            if (existingPaciente == null) {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao validar e atualizar paciente", e);
        }

        try {
            PacienteDao.update(paciente);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar paciente", e);
        }
        return true;
    }

    public static void delete(Paciente paciente) {
        try {
            PacienteDao.delete(paciente);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir paciente", e);
        }
    }

}
