package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private final Link homePage;

    private final LocalDate startDate;
    private final LocalDate endDate;

    private final String title;
    private final String description;


    public Organization(String name, String utl, LocalDate startDate, LocalDate endDate, String title, String description) {


        this.homePage = new Link(name, utl);


        Objects.requireNonNull(endDate, "endDate must not be null");

        Objects.requireNonNull(endDate, "startDate must not be null");

        this.endDate = endDate;
        this.startDate = startDate;

        Objects.requireNonNull(title, "title must not be null");
        this.title = title;
        this.description = description;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        if (!startDate.equals(that.startDate)) return false;
        if (!endDate.equals(that.endDate)) return false;
        if (!title.equals(that.title)) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
