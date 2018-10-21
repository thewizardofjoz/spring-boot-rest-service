
package com.api.hr.domain;

import com.api.hr.domain.common.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Employee
 * <p>
 * An Employee
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "employee-id",
    "first-name",
    "middle-name",
    "last-name",
    "gender",
    "work-email",
    "date-of-birth"
})
public class Employee {

    /**
     * The unique identifier for an employee
     * 
     */
    @JsonProperty("employee-id")
    @ApiModelProperty("The unique identifier for an employee")
    private String employeeId;
    /**
     * Employee's first name.
     * 
     */
    @JsonProperty("first-name")
    @ApiModelProperty("Employee's first name.")
    @Size(min = 2, max = 150)
    private String firstName;
    /**
     * Employee's middle name.
     * 
     */
    @JsonProperty("middle-name")
    @ApiModelProperty("Employee's middle name.")
    @Size(max = 100)
    private String middleName;
    /**
     * Employee's last name.
     * 
     */
    @JsonProperty("last-name")
    @ApiModelProperty("Employee's last name.")
    @Size(max = 150)
    private String lastName;
    /**
     * The gender type.
     * 
     */
    @JsonProperty("gender")
    @ApiModelProperty("The gender type.")
    private Gender gender;
    /**
     * The email address.
     * 
     */
    @JsonProperty("work-email")
    @ApiModelProperty("The email address.")
    @Pattern(regexp = "^.+@[^\"\\-].+$")
    @Size(min = 3, max = 254)
    private String workEmail;
    /**
     * Date and Time in Internet date and time format. For example, yyyy-MM-ddTHH:mm:ss.SSSZ
     * 
     */
    @JsonProperty("date-of-birth")
    @ApiModelProperty("Date and Time in Internet date and time format. For example, yyyy-MM-ddTHH:mm:ss.SSSZ")
    @Pattern(regexp = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])[T,t]([0-1][0-9]|2[0-3]):[0-5][0-9]:([0-5][0-9]|60)([.][0-9]+)?([Zz]|[+-][0-9]{2}:[0-9]{2})$")
    @Size(min = 20, max = 64)
    private String dateOfBirth;

    /**
     * The unique identifier for an employee
     * 
     */
    @JsonProperty("employee-id")
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * The unique identifier for an employee
     * 
     */
    @JsonProperty("employee-id")
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Employee's first name.
     * 
     */
    @JsonProperty("first-name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * Employee's first name.
     * 
     */
    @JsonProperty("first-name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Employee's middle name.
     * 
     */
    @JsonProperty("middle-name")
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Employee's middle name.
     * 
     */
    @JsonProperty("middle-name")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Employee's last name.
     * 
     */
    @JsonProperty("last-name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Employee's last name.
     * 
     */
    @JsonProperty("last-name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * The gender type.
     * 
     */
    @JsonProperty("gender")
    public Gender getGender() {
        return gender;
    }

    /**
     * The gender type.
     * 
     */
    @JsonProperty("gender")
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * The email address.
     * 
     */
    @JsonProperty("work-email")
    public String getWorkEmail() {
        return workEmail;
    }

    /**
     * The email address.
     * 
     */
    @JsonProperty("work-email")
    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    /**
     * Date and Time in Internet date and time format. For example, yyyy-MM-ddTHH:mm:ss.SSSZ
     * 
     */
    @JsonProperty("date-of-birth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Date and Time in Internet date and time format. For example, yyyy-MM-ddTHH:mm:ss.SSSZ
     * 
     */
    @JsonProperty("date-of-birth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("employeeId", employeeId).append("firstName", firstName).append("middleName", middleName).append("lastName", lastName).append("gender", gender).append("workEmail", workEmail).append("dateOfBirth", dateOfBirth).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(firstName).append(lastName).append(gender).append(workEmail).append(employeeId).append(middleName).append(dateOfBirth).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Employee) == false) {
            return false;
        }
        Employee rhs = ((Employee) other);
        return new EqualsBuilder().append(firstName, rhs.firstName).append(lastName, rhs.lastName).append(gender, rhs.gender).append(workEmail, rhs.workEmail).append(employeeId, rhs.employeeId).append(middleName, rhs.middleName).append(dateOfBirth, rhs.dateOfBirth).isEquals();
    }

}
