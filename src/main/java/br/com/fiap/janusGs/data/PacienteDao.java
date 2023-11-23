package br.com.fiap.janusGs.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.janusGs.model.Paciente;

public class PacienteDao {

	
	
	public static List<Paciente> findAll() throws SQLException {
		List<Paciente> Clientes = new ArrayList<>();	
		
	var con = ConnectionFactory.getConnection();
	var rs = con.createStatement().executeQuery("SELECT * FROM T_HOSP_JANUS_PACIENTE");
	
	while(rs.next()) {
		Clientes.add(new Paciente(
				    rs.getInt("ID_PACIENTE"),
				    rs.getString("NM_CLIENTE"),
				    rs.getString("DT_NASCIMENTO"),
				    rs.getString("NR_CPF"),
				    rs.getString("DS_EMAIL"),
					rs.getInt("DS_PESO"),
					rs.getInt("DS_ALTURA")
				));
	}
	
	con.close();
		
		return Clientes;
	}

	public static Paciente findById(int id) throws SQLException {
		
		var con = ConnectionFactory.getConnection();
		var rss = con.prepareStatement("SELECT * FROM T_HOSP_JANUS_PACIENTE WHERE ID_PACIENTE = ?");
		rss.setInt(1, id);
		var rs = rss.executeQuery();
		rs.next();
		if (rs.isAfterLast()) {
		    return null;
		}
		System.out.println(rs);
		var paciente = new Paciente(
						rs.getInt("ID_PACIENTE"),
				    	rs.getString("NM_CLIENTE"),
				    	rs.getString("DT_NASCIMENTO"),
				    	rs.getString("NR_CPF"),
				    	rs.getString("DS_EMAIL"),
						rs.getInt("DS_PESO"),
						rs.getInt("DS_ALTURA")
					);
		
		con.close();
		return paciente;
			
		}

	public static void create(Paciente paciente)  throws SQLException {
		var con = ConnectionFactory.getConnection();
		var ps = con.prepareStatement("INSERT INTO FROM T_HOSP_JANUS_PACIENTE VALUES (SEQ_PACIENTE.NEXTVAL, ?, to_date(?, 'dd-mm-yyyy'), ?, ?, ?, ?)");
		ps.setString(1, paciente.getNmPaciente());
		ps.setString(2, paciente.getDtNascimento());
		ps.setString(3, paciente.getCpf());
		ps.setString(4, paciente.getDsEmail());
		ps.setInt(5, paciente.getDsPeso());
		ps.setInt(6, paciente.getDsAltura());

		ps.executeUpdate();
			
		con.close();
		}
	
	public static void update(Paciente paciente) throws SQLException {
		var con = ConnectionFactory.getConnection();
		var ps = con.prepareStatement("UPDATE T_HOSP_JANUS_PACIENTE SET NM_CLIENTE=?, DT_NASCIMENTO= to_date(?, 'dd-mm-yyyy'), NR_CPF=?, DS_EMAIL=?, DS_PESO=?, DS_ALTURA=? WHERE ID_PACIENTE=?");
		ps.setString(1, paciente.getNmPaciente());
		ps.setString(2, paciente.getDtNascimento());
		ps.setString(3, paciente.getCpf());
		ps.setString(4, paciente.getDsEmail());
		ps.setInt(5, paciente.getDsPeso());
		ps.setInt(6, paciente.getDsAltura());
		ps.setInt(7, paciente.getIdPaciente());
		
		ps.executeUpdate();
		con.close();		
	}
	
	 public static void delete(Paciente id) throws SQLException {
	        var con = ConnectionFactory.getConnection();
	        var ps = con.prepareStatement("DELETE FROM T_HOSP_JANUS_PACIENTE WHERE ID_PACIENTE=?");
	        ps.setInt(1, id.getIdPaciente());
	        ps.executeUpdate();
	        con.close();
	    }
	

}
