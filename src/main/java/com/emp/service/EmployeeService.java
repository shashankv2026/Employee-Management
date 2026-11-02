package com.emp.service;

import com.emp.model.Employee;
import com.emp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAll() { return repo.findAll(); }

    public Employee getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public Employee save(Employee e) { return repo.save(e); }

    public Employee update(Long id, Employee updated) {
        Employee e = getById(id);
        // Basic
        e.setName(updated.getName());
        e.setDepartment(updated.getDepartment());
        e.setEmail(updated.getEmail());
        e.setSalary(updated.getSalary());
        e.setUsername(updated.getUsername());
        e.setPassword(updated.getPassword());
        e.setCreditDay(updated.getCreditDay());
        // Profile
        e.setDesignation(updated.getDesignation());
        e.setGender(updated.getGender());
        e.setDateOfBirth(updated.getDateOfBirth());
        e.setMaritalStatus(updated.getMaritalStatus());
        e.setMobileNumber(updated.getMobileNumber());
        e.setAddress(updated.getAddress());
        e.setCity(updated.getCity());
        e.setState(updated.getState());
        e.setPinCode(updated.getPinCode());
        e.setQualification(updated.getQualification());
        e.setSkills(updated.getSkills());
        e.setWorkExperience(updated.getWorkExperience());
        e.setJoiningDate(updated.getJoiningDate());
        e.setEmergencyContactName(updated.getEmergencyContactName());
        e.setEmergencyContactNumber(updated.getEmergencyContactNumber());
        if (updated.getProfilePhoto() != null && !updated.getProfilePhoto().isEmpty())
            e.setProfilePhoto(updated.getProfilePhoto());
        // Bank
        e.setAccountHolderName(updated.getAccountHolderName());
        e.setBankName(updated.getBankName());
        e.setAccountNumber(updated.getAccountNumber());
        e.setIfscCode(updated.getIfscCode());
        e.setBranchName(updated.getBranchName());
        e.setUpiId(updated.getUpiId());
        e.setBankVerified(updated.getBankVerified());
        return repo.save(e);
    }

    public void delete(Long id) { repo.deleteById(id); }

    public Optional<Employee> login(String username, String password) {
        return repo.findByUsernameAndPassword(username, password);
    }

    public List<Employee> search(String keyword) {
        return repo.searchEmployees(keyword);
    }
}