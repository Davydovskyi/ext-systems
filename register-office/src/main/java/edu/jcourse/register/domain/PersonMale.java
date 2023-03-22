package edu.jcourse.register.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class PersonMale extends Person {

//    private List<MarriageCertificate> marriageCertificates;
//    private List<BirthCertificate> birthCertificates;
//
//    public List<MarriageCertificate> getMarriageCertificates() {
//        return marriageCertificates;
//    }
//
//    public void setMarriageCertificates(List<MarriageCertificate> marriageCertificates) {
//        this.marriageCertificates = marriageCertificates;
//    }
//
//    public List<BirthCertificate> getBirthCertificates() {
//        return birthCertificates;
//    }
//
//    public void setBirthCertificates(List<BirthCertificate> birthCertificates) {
//        this.birthCertificates = birthCertificates;
//    }
}
