package dao;

import java.sql.SQLException;
import java.util.List;

import dto.PhoneDto;


public interface PhoneDao {

	public void register(PhoneDto phoneDto) throws SQLException;

	public List<PhoneDto> getlist() throws SQLException;

	public List<PhoneDto> remove(String[] tmp) throws SQLException;
	
}
