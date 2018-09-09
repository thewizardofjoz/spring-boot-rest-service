
package com.api.hr.exception;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Error Details
 * <p>
 * The error details. Required for client-side `4XX` errors.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "field",
    "issue",
    "location",
    "value"
})
public class Detail {

    /**
     * The name of the field that caused the error.
     * (Required)
     * 
     */
    @JsonProperty("field")
    @JsonPropertyDescription("The name of the field that caused the error.")
    @NotNull
    private String field;
    /**
     * The reason for the error.
     * (Required)
     * 
     */
    @JsonProperty("issue")
    @JsonPropertyDescription("The reason for the error.")
    @NotNull
    private String issue;
    /**
     * InputLocation of the field that caused the error. Possible values are body (default), path and query.
     * 
     */
    @JsonProperty("location")
    @JsonPropertyDescription("InputLocation of the field that caused the error. Possible values are body (default), path and query.")
    private String location;
    /**
     * Value of the field that caused the error.
     * 
     */
    @JsonProperty("value")
    @JsonPropertyDescription("Value of the field that caused the error.")
    private String value;

    /**
     * The name of the field that caused the error.
     * (Required)
     * 
     */
    @JsonProperty("field")
    public String getField() {
        return field;
    }

    /**
     * The name of the field that caused the error.
     * (Required)
     * 
     */
    @JsonProperty("field")
    public void setField(String field) {
        this.field = field;
    }

    /**
     * The reason for the error.
     * (Required)
     * 
     */
    @JsonProperty("issue")
    public String getIssue() {
        return issue;
    }

    /**
     * The reason for the error.
     * (Required)
     * 
     */
    @JsonProperty("issue")
    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
     * InputLocation of the field that caused the error. Possible values are body (default), path and query.
     * 
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * InputLocation of the field that caused the error. Possible values are body (default), path and query.
     * 
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Value of the field that caused the error.
     * 
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Value of the field that caused the error.
     * 
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("field", field).append("issue", issue).append("location", location).append("value", value).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(location).append(field).append(issue).append(value).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Detail) == false) {
            return false;
        }
        Detail rhs = ((Detail) other);
        return new EqualsBuilder().append(location, rhs.location).append(field, rhs.field).append(issue, rhs.issue).append(value, rhs.value).isEquals();
    }

}
