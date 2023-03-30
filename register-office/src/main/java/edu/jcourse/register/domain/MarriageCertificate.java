package edu.jcourse.register.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Table(name = "ro_marriage_certificate")
@Entity

@NamedQueries({
        @NamedQuery(name = "MarriageCertificate.findMarriageCertificate",
                query = "SELECT mc FROM MarriageCertificate mc " +
                        "LEFT JOIN FETCH mc.husband h " +
                        "LEFT JOIN FETCH mc.wife w " +
                        "WHERE mc.number = :certificateNumber"
        ),
        @NamedQuery(name = "MarriageCertificate.findByNum",
                query = "SELECT mc FROM MarriageCertificate mc " +
                        "WHERE mc.number = :number")
})

public class MarriageCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marriage_certificate_id")
    private Long marriageCertificateId;
    @Column(name = "number_certificate")
    private String number;
    @Column(name = "date_issue")
    private LocalDate issueDate;
    @Column(name = "active")
    private boolean active;
    @Column(name = "end_date")
    private LocalDate endDate;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "wife_id")
    private PersonFemale wife;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "husband_id")
    private PersonMale husband;

    public Long getMarriageCertificateId() {
        return marriageCertificateId;
    }

    public void setMarriageCertificateId(Long marriageCertificateId) {
        this.marriageCertificateId = marriageCertificateId;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public PersonFemale getWife() {
        return wife;
    }

    public void setWife(PersonFemale wife) {
        this.wife = wife;
    }

    public PersonMale getHusband() {
        return husband;
    }

    public void setHusband(PersonMale husband) {
        this.husband = husband;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarriageCertificate that = (MarriageCertificate) o;

        if (active != that.active) return false;
        if (!Objects.equals(marriageCertificateId, that.marriageCertificateId))
            return false;
        if (!Objects.equals(number, that.number)) return false;
        if (!Objects.equals(issueDate, that.issueDate)) return false;
        if (!Objects.equals(endDate, that.endDate)) return false;
        if (!Objects.equals(wife, that.wife)) return false;
        return Objects.equals(husband, that.husband);
    }

    @Override
    public int hashCode() {
        int result = marriageCertificateId != null ? marriageCertificateId.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (issueDate != null ? issueDate.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (wife != null ? wife.hashCode() : 0);
        result = 31 * result + (husband != null ? husband.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append("{marriageCertificateId=").append(marriageCertificateId);
        sb.append(", number='").append(number).append('\'');
        sb.append(", issueDate=").append(issueDate);
        sb.append(", active=").append(active);
        sb.append(", endDate=").append(endDate);
        sb.append(", wife=").append(wife);
        sb.append(", husband=").append(husband);
        sb.append('}');
        return sb.toString();
    }
}
