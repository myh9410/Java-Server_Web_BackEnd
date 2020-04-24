package service;

import java.util.List;

import dto.PhoneDto;

public interface PhoneService {
	public void register(PhoneDto phoneDto) throws Exception;

	public List<PhoneDto> getlist() throws Exception;

	public List<PhoneDto> remove(String[] tmp) throws Exception;
}
