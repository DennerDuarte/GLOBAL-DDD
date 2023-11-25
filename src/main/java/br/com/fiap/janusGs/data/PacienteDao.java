package br.com.fiap.janusGs.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.janusGs.model.Paciente;
public class PacienteDao {

    public static List<Paciente> findAll() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM T_HOSP_JANUS_PACIENTE")) {

            while (rs.next()) {
                pacientes.add(new Paciente(
                        rs.getInt("ID_PACIENTE"),
                        rs.getString("NM_PACIENTE"),
                        rs.getString("DT_NASCIMENTO"),
                        rs.getString("NR_CPF"),
                        rs.getString("DS_EMAIL"),
                        rs.getDouble("DS_PESO"),
                        rs.getDouble("DS_ALTURA")
                ));
            }
        }

        return pacientes;
    }



    public static Paciente findById(int id) throws SQLException {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM T_HOSP_JANUS_PACIENTE WHERE ID_PACIENTE = ?")) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Paciente(
                            rs.getInt("ID_PACIENTE"),
                            rs.getString("NM_PACIENTE"),
                            rs.getString("DT_NASCIMENTO"),
                            rs.getString("NR_CPF"),
                            rs.getString("DS_EMAIL"),
                            rs.getDouble("DS_PESO"),
                            rs.getDouble("DS_ALTURA")
                    );
                }
            }
        }

        return null;
    }

    public static void create(Paciente paciente) throws SQLException {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO T_HOSP_JANUS_PACIENTE VALUES (SEQ_PACIENTE.NEXTVAL, ?, TO_DATE(?, 'dd-mm-yyyy'), ?, ?, ?, ?)")) {

            pstmt.setString(1, paciente.getNmPaciente());
            pstmt.setString(2, paciente.getDtNascimento());
            pstmt.setString(3, paciente.getCpf());
            pstmt.setString(4, paciente.getDsEmail());
            pstmt.setDouble(5, paciente.getDsPeso());
            pstmt.setDouble(6, paciente.getDsAltura());

            pstmt.executeUpdate();
        }
    }

    public static void update(Paciente paciente) throws SQLException {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement pstmt = con.prepareStatement("UPDATE T_HOSP_JANUS_PACIENTE SET NM_PACIENTE=?, DT_NASCIMENTO=TO_DATE(?, 'dd-mm-yyyy'), NR_CPF=?, DS_EMAIL=?, DS_PESO=?, DS_ALTURA=? WHERE ID_PACIENTE=?")) {

            pstmt.setString(1, paciente.getNmPaciente());
            pstmt.setString(2, paciente.getDtNascimento());
            pstmt.setString(3, paciente.getCpf());
            pstmt.setString(4, paciente.getDsEmail());
            pstmt.setDouble(5, paciente.getDsPeso());
            pstmt.setDouble(6, paciente.getDsAltura());
            pstmt.setInt(7, paciente.getIdPaciente());

            pstmt.executeUpdate();
        }
    }

    public static void delete(Paciente paciente) throws SQLException {
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement pstmt = con.prepareStatement("DELETE FROM T_HOSP_JANUS_PACIENTE WHERE ID_PACIENTE=?")) {

            pstmt.setInt(1, paciente.getIdPaciente());
            pstmt.executeUpdate();
        }
    }
}
