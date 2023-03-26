package edu.jcourse.register.view;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class MarriageRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = -1686708095828117909L;

    private String husbandSurName;
    private String husbandGivenName;
    private String husbandPatronymic;
    private LocalDate husbandDateOfBirth;
    private String husbandPassportSeries;
    private String husbandPassportNumber;
    private LocalDate husbandPassportIssueDate;

    private String wifeSurName;
    private String wifeGivenName;
    private String wifePatronymic;
    private LocalDate wifeDateOfBirth;
    private String wifePassportSeries;
    private String wifePassportNumber;
    private LocalDate wifePassportIssueDate;

    private String marriageCertificateNumber;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MarriageRequest that = (MarriageRequest) o;

        if (!Objects.equals(husbandSurName, that.husbandSurName))
            return false;
        if (!Objects.equals(husbandGivenName, that.husbandGivenName))
            return false;
        if (!Objects.equals(husbandPatronymic, that.husbandPatronymic))
            return false;
        if (!Objects.equals(husbandDateOfBirth, that.husbandDateOfBirth))
            return false;
        if (!Objects.equals(husbandPassportSeries, that.husbandPassportSeries))
            return false;
        if (!Objects.equals(husbandPassportNumber, that.husbandPassportNumber))
            return false;
        if (!Objects.equals(husbandPassportIssueDate, that.husbandPassportIssueDate))
            return false;
        if (!Objects.equals(wifeSurName, that.wifeSurName)) return false;
        if (!Objects.equals(wifeGivenName, that.wifeGivenName))
            return false;
        if (!Objects.equals(wifePatronymic, that.wifePatronymic))
            return false;
        if (!Objects.equals(wifeDateOfBirth, that.wifeDateOfBirth))
            return false;
        if (!Objects.equals(wifePassportSeries, that.wifePassportSeries))
            return false;
        if (!Objects.equals(wifePassportNumber, that.wifePassportNumber))
            return false;
        if (!Objects.equals(wifePassportIssueDate, that.wifePassportIssueDate))
            return false;
        if (!Objects.equals(marriageCertificateNumber, that.marriageCertificateNumber))
            return false;
        return Objects.equals(marriageCertificateDate, that.marriageCertificateDate);
    }

    @Override
    public int hashCode() {
        int result = husbandSurName != null ? husbandSurName.hashCode() : 0;
        result = 31 * result + (husbandGivenName != null ? husbandGivenName.hashCode() : 0);
        result = 31 * result + (husbandPatronymic != null ? husbandPatronymic.hashCode() : 0);
        result = 31 * result + (husbandDateOfBirth != null ? husbandDateOfBirth.hashCode() : 0);
        result = 31 * result + (husbandPassportSeries != null ? husbandPassportSeries.hashCode() : 0);
        result = 31 * result + (husbandPassportNumber != null ? husbandPassportNumber.hashCode() : 0);
        result = 31 * result + (husbandPassportIssueDate != null ? husbandPassportIssueDate.hashCode() : 0);
        result = 31 * result + (wifeSurName != null ? wifeSurName.hashCode() : 0);
        result = 31 * result + (wifeGivenName != null ? wifeGivenName.hashCode() : 0);
        result = 31 * result + (wifePatronymic != null ? wifePatronymic.hashCode() : 0);
        result = 31 * result + (wifeDateOfBirth != null ? wifeDateOfBirth.hashCode() : 0);
        result = 31 * result + (wifePassportSeries != null ? wifePassportSeries.hashCode() : 0);
        result = 31 * result + (wifePassportNumber != null ? wifePassportNumber.hashCode() : 0);
        result = 31 * result + (wifePassportIssueDate != null ? wifePassportIssueDate.hashCode() : 0);
        result = 31 * result + (marriageCertificateNumber != null ? marriageCertificateNumber.hashCode() : 0);
        result = 31 * result + (marriageCertificateDate != null ? marriageCertificateDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append("{husbandSurName='").append(husbandSurName).append('\'');
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
