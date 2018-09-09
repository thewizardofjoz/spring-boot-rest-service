
package com.api.hr.exception;

import java.util.List;
import javax.validation.Valid;
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
 * Error
 * <p>
 * The error information.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "name",
    "message",
    "details"
})
public class Error {

    /**
     * The human-readable, unique name of the error.
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("The human-readable, unique name of the error.")
    @NotNull
    private String name;
    /**
     * The message that describes the error.
     * (Required)
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("The message that describes the error.")
    @NotNull
    private String message;
    /**
     * An array of additional details for the error.
     * 
     */
    @JsonProperty("details")
    @JsonPropertyDescription("An array of additional details for the error.")
    @Valid
    private List<Detail> details = null;

    /**
     * The human-readable, unique name of the error.
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The human-readable, unique name of the error.
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The message that describes the error.
     * (Required)
     * 
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * The message that describes the error.
     * (Required)
     * 
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * An array of additional details for the error.
     * 
     */
    @JsonProperty("details")
    public List<Detail> getDetails() {
        return details;
    }

    /**
     * An array of additional details for the error.
     * 
     */
    @JsonProperty("details")
    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("message", message).append("details", details).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(details).append(message).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Error) == false) {
            return false;
        }
        Error rhs = ((Error) other);
        return new EqualsBuilder().append(name, rhs.name).append(details, rhs.details).append(message, rhs.message).isEquals();
    }

}
