package com.app.serviceimpl;


import org.mockito.InjectMocks;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.entity.ContactDtlsEntity;
import com.app.model.Contact;
import com.app.repo.ContatcRepository;
@WebMvcTest(value = ContactServiceImpl.class)
public class ContactServiceImplTest {
	@MockBean
	private ContatcRepository dao;

	
	
	
	//@Test
	public void test_saveContact(Contact contact) {
		ContactDtlsEntity entity=new ContactDtlsEntity();
		entity.setCntctmail("fridnanoosha@gmail.com");
		entity.setCntctname("anusha");;
		entity.setCntctnum("9832478423");
		BeanUtils.copyProperties(contact, entity);
		
		//return save.getCntctid()!=null; 
	}
//	UserDao userDaoMock = PowerMockito.mock(UserDao.class);
//	when(userDaoMock.findNameById(101)).thenReturn("anusha");
//	
//	UserService service = new UserService();
//	service.setUserDao(userDaoMock);
//
//	String name = service.getName(101);
//	assertNotNull(name);

}
