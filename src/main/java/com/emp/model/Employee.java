package com.emp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ── Basic Info ──
    private String name;
    private String department;
    private String email;
    private double salary;
    private String username;
    private String password;

    @Column(name = "credit_day")
    private int creditDay;

    // ── Profile Fields ──
    private String designation;
    private String gender;
    private String dateOfBirth;
    private String maritalStatus;
    private String mobileNumber;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String qualification;
    private String skills;
    private String workExperience;
    private String joiningDate;
    private String emergencyContactName;
    private String emergencyContactNumber;
    private String profilePhoto;

    // ── Bank Details ──
    private String accountHolderName;
    private String bankName;
    private String accountNumber;
    private String ifscCode;
    private String branchName;
    private String upiId;
    private String bankVerified;
}