package edu.jcourse.register.view;

import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;

public class MarriageRequest {

    private String husbandSurName;
    private String husbandGivenName;
    private String husbandPatronymic;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate husbandDateOfBirth;
    private String husbandPassportSeries;
    private String husbandPassportNumber;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate husbandPassportIssueDate;

    private String wifeSurName;
    private String wifeGivenName;
    private String wifePatronymic;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate wifeDateOfBirth;
    private String wifePassportSeries;
    private String wifePassportNumber;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate wifePassportIssueDate;

    private String marriageCertificateNumber;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate marriageCertificateDate;

    public String getHusbandSurName() {
        return husbandSurName;
    }

    public void setHusbandSurName(String husbandSurName) {
        this.husbandSurName = husbandSurName;
    }

    public String getHusbandGivenName() {
        return husbandGivenName;
    }

    public void setHusbandGivenName(String husbandGivenName) {
        this.husbandGivenName = husbandGivenName;
    }

    public String getHusbandPatronymic() {
        return husbandPatronymic;
    }

    public void setHusbandPatronymic(String husbandPatronymic) {
        this.husbandPatronymic = husbandPatronymic;
    }

    public LocalDate getHusbandDateOfBirth() {
        return husbandDateOfBirth;
    }

    public void setHusbandDateOfBirth(LocalDate husbandDateOfBirth) {
        this.husbandDateOfBirth = husbandDateOfBirth;
    }

    public String getHusbandPassportSeries() {
        return husbandPassportSeries;
    }

    public void setHusbandPassportSeries(String husbandPassportSeries) {
        this.husbandPassportSeries = husbandPassportSeries;
    }

    public String getHusbandPassportNumber() {
        return husbandPassportNumber;
    }

    public void setHusbandPassportNumber(String husbandPassportNumber) {
        this.husbandPassportNumber = husbandPassportNumber;
    }

    public LocalDate getHusbandPassportIssueDate() {
        return husbandPassportIssueDate;
    }

    public void setHusbandPassportIssueDate(LocalDate husbandPassportIssueDate) {
        this.husbandPassportIssueDate = husbandPassportIssueDate;
    }

    public String getWifeSurName() {
        return wifeSurName;
    }

    public void setWifeSurName(String wifeSurName) {
        this.wifeSurName = wifeSurName;
    }

    public String getWifeGivenName() {
        return wifeGivenName;
    }

    public void setWifeGivenName(String wifeGivenName) {
        this.wifeGivenName = wifeGivenName;
    }

    public String getWifePatronymic() {
        return wifePatronymic;
    }

    public void setWifePatronymic(String wifePatronymic) {
        this.wifePatronymic = wifePatronymic;
    }

    public LocalDate getWifeDateOfBirth() {
        return wifeDateOfBirth;
    }

    public void setWifeDateOfBirth(LocalDate wifeDateOfBirth) {
        this.wifeDateOfBirth = wifeDateOfBirth;
    }

    public String getWifePassportSeries() {
        return wifePassportSeries;
    }

    public void setWifePassportSeries(String wifePassportSeries) {
        this.wifePassportSeries = wifePassportSeries;
    }

    public String getWifePassportNumber() {
        return wifePassportNumber;
    }

    public void setWifePassportNumber(String wifePassportNumber) {
        this.wifePassportNumber = wifePassportNumber;
    }

    public LocalDate getWifePassportIssueDate() {
        return wifePassportIssueDate;
    }

    public void setWifePassportIssueDate(LocalDate wifePassportIssueDate) {
        this.wifePassportIssueDate = wifePassportIssueDate;
    }

    public String getMarriageCertificateNumber() {
        return marriageCertificateNumber;
    }

    public void setMarriageCertificateNumber(String marriageCertificateNumber) {
        this.marriageCertificateNumber = marriageCertificateNumber;
    }

    public LocalDate getMarriageCertificateDate() {
        return marriageCertificateDate;
    }

    public void setMarriageCertificateDate(LocalDate marriageCertificateDate) {
        this.marriageCertificateDate = marriageCertificateDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MarriageRequest{");
        sb.append("husbandSurName='").append(husbandSurName).append('\'');
        sb.append(", husbandGivenName='").append(husbandGivenName).append('\'');
        sb.append(", husbandPatronymic='").append(husbandPatronymic).append('\'');
        sb.append(", husbandDateOfBirth=").append(husbandDateOfBirth);
        sb.append(", husbandPassportSeries='").append(husbandPassportSeries).append('\'');
        sb.append(", husbandPassportNumber='").append(husbandPassportNumber).append('\'');
        sb.append(", husbandPassportIssueDate=").append(husbandPassportIssueDate);
        sb.append(", wifeSurName='").append(wifeSurName).append('\'');
        sb.append(", wifeGivenName='").append(wifeGivenName).append('\'');
        sb.append(", wifePatronymic='").append(wifePatronymic).append('\'');
        sb.append(", wifeDateOfBirth=").append(wifeDateOfBirth);
        sb.append(", wifePassportSeries='").append(wifePassportSeries).append('\'');
        sb.append(", wifePassportNumber='").append(wifePassportNumber).append('\'');
        sb.append(", wifePassportIssueDate=").append(wifePassportIssueDate);
        sb.append(", marriageCertificateNumber='").append(marriageCertificateNumber).append('\'');
        sb.append(", marriageCertificateDate=").append(marriageCertificateDate);
        sb.append('}');
        return sb.toString();
    }
}
