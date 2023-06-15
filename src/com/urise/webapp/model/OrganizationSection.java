package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationSection extends Section{
    private static final long serialVersionUID = 1L;

    private  List<Organization> organizations  ;


    public OrganizationSection(Organization... organizations) {

        this( Arrays.asList(organizations));
    }

    public OrganizationSection(List<Organization> organizations) {
        Objects.requireNonNull(organizations, "organization must not be null");
        this.organizations = organizations;
    }

    public OrganizationSection() {
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationSection)) return false;

        OrganizationSection that = (OrganizationSection) o;

        return getOrganizations().equals(that.getOrganizations());
    }

    @Override
    public int hashCode() {
        return getOrganizations().hashCode();
    }

    @Override
    public String toString() {
        return organizations.toString();
    }
}
