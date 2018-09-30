package com.api.hr.domain;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.api.hr.controllers.EmployeeController;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

@Getter
public class EmployeeResource extends ResourceSupport {
    private final Employee employee;
    public EmployeeResource(final Employee employee) {
        this.employee = employee;
        final String id = employee.getEmployeeId();
        add(linkTo(methodOn(EmployeeController.class).get(id)).withSelfRel());
    }
}
