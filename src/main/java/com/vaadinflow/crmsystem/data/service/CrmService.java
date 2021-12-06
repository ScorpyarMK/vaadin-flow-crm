package com.vaadinflow.crmsystem.data.service;

import com.vaadinflow.crmsystem.data.entity.Company;
import com.vaadinflow.crmsystem.data.entity.Contact;
import com.vaadinflow.crmsystem.data.entity.Status;
import com.vaadinflow.crmsystem.data.repository.CompanyRepository;
import com.vaadinflow.crmsystem.data.repository.ContactRepository;
import com.vaadinflow.crmsystem.data.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrmService {


    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;
    private final StatusRepository statusRepository;

    public CrmService(ContactRepository contactRepository,
                      CompanyRepository companyRepository,
                      StatusRepository statusRepository) {
        this.contactRepository = contactRepository;
        this.companyRepository = companyRepository;
        this.statusRepository = statusRepository;
    }

    public List<Contact> findAllContacts(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return contactRepository.findAll();
        } else {
            return contactRepository.search(filterText);
        }
    }

    public long countContacts() {
        return contactRepository.count();
    }

    public void deleteContact(Contact contact) {
        contactRepository.delete(contact);
    }

    public void saveContact(Contact contact) {
        if (contact == null) {
            System.err.println("Contact is null");
            return;
        }

        contactRepository.save(contact);
    }

    public List<Company> findAllCompanies(){
        return companyRepository.findAll();
    }

    public List<Status> findAllStatuses(){
        return statusRepository.findAll();
    }

}
