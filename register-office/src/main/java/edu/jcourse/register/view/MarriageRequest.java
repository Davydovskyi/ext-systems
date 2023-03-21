package edu.jcourse.register.view;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

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
}
