package com.example.toursystem.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "role")
    private String role;
    @Basic
    @Column(name = "full_name")
    private String fullName;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "nationality")
    private String nationality;
    @Basic
    @Column(name = "bank_account_number")
    private String bankAccountNumber;
    @Basic
    @Column(name = "home_address")
    private String homeAddress;
    @Basic
    @Column(name = "doc_id")
    private String docId;
    @Basic
    @Column(name = "doc_home")
    private String docHome;
    @Basic
    @Column(name = "doc_bank")
    private String docBank;
    @Basic
    @Column(name = "host_approve_status")
    @Enumerated(EnumType.STRING)
    private ApproveStatus hostApproveStatus;
    //0=Approved, 1=WaitForReview, 2=WaitForResubmission, 3=Resubmitted, 4=Rejected

    public User() {
    }

    public User(String username, String password, String role, String fullName, String email, String nationality, String bankAccountNumber, String homeAddress, String docId, String docHome, String docBank, ApproveStatus hostApproveStatus) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
        this.email = email;
        this.nationality = nationality;
        this.bankAccountNumber = bankAccountNumber;
        this.homeAddress = homeAddress;
        this.docId = docId;
        this.docHome = docHome;
        this.docBank = docBank;
        this.hostApproveStatus = hostApproveStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocHome() {
        return docHome;
    }

    public void setDocHome(String docHome) {
        this.docHome = docHome;
    }

    public String getDocBank() {
        return docBank;
    }

    public void setDocBank(String docBank) {
        this.docBank = docBank;
    }

    public ApproveStatus getHostApproveStatus() {
        return hostApproveStatus;
    }

    public void setHostApproveStatus(ApproveStatus hostApproveStatus) {
        this.hostApproveStatus = hostApproveStatus;
    }
}
