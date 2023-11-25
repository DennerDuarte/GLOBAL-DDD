package br.com.fiap.janusGs.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.janusGs.model.Site;

public class SiteDao {

    private static void createMedico(Site site) throws SQLException {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement medicoStmt = con.prepareStatement("SELECT * FROM T_HOSP_JANUS_MEDICO WHERE nr_crm=?")) {

            medicoStmt.setInt(1, site.getMedico().getCrm());
            try (ResultSet rs = medicoStmt.executeQuery()) {
                rs.next();

                if (rs.isAfterLast()) {
                    try (PreparedStatement ps = con.prepareStatement("INSERT INTO T_HOSP_JANUS_MEDICO VALUES (SEQ_MEDICO.NEXTVAL, ?, ?, ?)")) {
                        ps.setString(1, site.getMedico().getNmMedico());
                        ps.setInt(2, site.getMedico().getCrm());
                        ps.setString(3, site.getMedico().getUnidadadeFederativa());
                        ps.executeUpdate();
                    }
                }
            }
        }
    }

    private static void createRemedio(Site site) throws SQLException {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO T_HOSP_JANUS_REMEDIO VALUES (SEQ_REMEDIO.NEXTVAL, SEQ_PACIENTE.CURRVAL, ?)")) {

            ps.setString(1, site.getRemedio().getNmRemedio());
            ps.executeUpdate();
        }
    }

    private static void createSintomas(Site site) throws SQLException {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO T_HOSP_JANUS_SINTOMAS VALUES (SEQ_SINTOMAS.NEXTVAL, SEQ_PACIENTE.CURRVAL, ?, TO_DATE(?, 'dd-mm-yyyy'), TO_DATE(?, 'dd-mm-yyyy'))")) {

            ps.setString(1, site.getSintomas().getDsSintoma());
            ps.setString(2, site.getSintomas().getDtInicio());
            ps.setString(3, site.getSintomas().getDtFim());
            ps.executeUpdate();
        }
    }

    private static void createConsulta(Site site) throws SQLException {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO T_HOSP_JANUS_CONSULTA VALUES (SEQ_CONSULTA.NEXTVAL, SEQ_PACIENTE.CURRVAL, SEQ_MEDICO.CURRVAL, TO_DATE(?, 'dd-mm-yyyy'))")) {

            ps.setString(1, site.getConsulta().getDtConsulta());
            ps.executeUpdate();
        }
    }

    public static void create(Site site) throws SQLException {
        createMedico(site);
        createRemedio(site);
        createSintomas(site);
        createConsulta(site);
    }
}
