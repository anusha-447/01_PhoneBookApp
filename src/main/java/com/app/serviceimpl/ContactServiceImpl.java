package com.app.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.ContactDtlsEntity;
import com.app.model.Contact;
import com.app.repo.ContatcRepository;
import com.app.service.IContactService;
@Service
public class ContactServiceImpl implements IContactService {
   
	@Autowired
	private ContatcRepository crepo;
	@Override
	public Boolean saveContact(Contact contact) {
		ContactDtlsEntity entity=new ContactDtlsEntity(); 
		BeanUtils.copyProperties(contact, entity);
		ContactDtlsEntity save = crepo.save(entity);
		return save.getCntctid()!=null; 
	}

	public List<Contact> getAllContacts() {
		
	 List<Contact> contactList =new ArrayList<Contact>();
	 List<ContactDtlsEntity> contactEntities=crepo.findAll();
	 //BeanUtils supports for objects copy not collectio object
	 contactEntities.forEach(entity->{
		 Contact contact=new Contact();
		
		 BeanUtils.copyProperties(entity,contact);
		 contactList.add(contact);
	 });
	
	 
	return contactList;
}

	@Override
	public Boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		ContactDtlsEntity entity=new ContactDtlsEntity(); 
		BeanUtils.copyProperties(contact, entity);
		ContactDtlsEntity save = crepo.save(entity);
		return save.getCntctid()!=null;
	}

	@Override
	public Boolean deleteContact(Integer id) {
		// TODO Auto-generated method stub
		crepo.deleteById(id);
		return id==null;
	}

	@Override
	public Contact getOneContact(Integer id) {
		// TODO Auto-generated method stub
		Contact contact=new Contact();
		Optional<ContactDtlsEntity> ce=crepo.findById(id);
		if(ce.isPresent()) {
		// Contact contact=new Contact();
		 ContactDtlsEntity entity=ce.get();
		 
		BeanUtils.copyProperties(entity,contact);
		System.out.println("hello");
		System.out.println("service"+contact);
		
		 
		}
		else {
			
		}
		
		return contact;
		
	}

}
