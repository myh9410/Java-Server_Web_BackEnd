package service;

import java.util.List;

import dao.PhoneDao;
import dao.PhoneDaoImpl;
import dto.PhoneDto;

public class PhoneServiceImpl implements PhoneService {

	PhoneDao phoneDao;
	
	public PhoneServiceImpl() {
		phoneDao = new PhoneDaoImpl();
	}

	@Override
	public void register(PhoneDto phoneDto) throws Exception {
		if (phoneDto.getNum() == "" || phoneDto.getModel() == "" || phoneDto.getVcode() == "") throw new Exception();
		phoneDao.register(phoneDto);
	}

	@Override
	public List<PhoneDto> getlist() throws Exception {
		return phoneDao.getlist();
	}

	@Override
	public List<PhoneDto> remove(String[] tmp) throws Exception {
		return phoneDao.remove(tmp);
	}
	
}
