package edu.jcourse.register.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "ro_birth_certificate")
@Entity
public class BirthCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "birth_certificate_id")
    private Long birthCertificateId;
    @Column(name = "number_certificate")
    private String number;
    @Column(name = "date_issue")
    private LocalDate issueDate;
    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "mother_id")
    private PersonFemale mother;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "father_id")
    private PersonMale father;

    public Long getBirthCertificateId() {
        return birthCertificateId;
    }

    public void setBirthCertificateId(Long birthCertificateId) {
        this.birthCertificateId = birthCertificateId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonFemale getMother() {
        return mother;
    }

    public void setMother(PersonFemale mother) {
        this.mother = mother;
    }

    public PersonMale getFather() {
        return father;
    }

    public void setFather(PersonMale father) {
        this.father = father;
    }
}
