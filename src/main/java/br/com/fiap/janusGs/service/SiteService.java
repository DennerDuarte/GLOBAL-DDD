package br.com.fiap.janusGs.service;

import java.sql.SQLException;

import br.com.fiap.janusGs.data.PacienteDao;
import br.com.fiap.janusGs.data.SiteDao;
import br.com.fiap.janusGs.model.Paciente;
import br.com.fiap.janusGs.model.Site;

public class SiteService {

    public static boolean create(Site site) {
        try {
            validar(site);
            SiteDao.create(site);
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            handleException(e);
            return false;
        }
    }

    private static void validar(Site site) throws ClassNotFoundException, SQLException {
        if (site.getMedico() == null) {
            throw new IllegalArgumentException("O site deve ter um médico associado.");
        }

        var pacientes = PacienteDao.findAll();
        for (Paciente paciente : pacientes) {
            if (paciente.getDsEmail().equals(site.getPaciente().getDsEmail())) {
                return;
            }
        }

        throw new IllegalArgumentException("O paciente associado ao site não existe.");
    }

    private static void handleException(Exception e) {
        e.printStackTrace(); 
    }
}
