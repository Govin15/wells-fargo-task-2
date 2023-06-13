package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity  // Annotation that tells JPA this class is an entity and should be managed by the JPA.
public class Portfolio {

    @Id // Annotation that marks this field as the primary key for the table.
    @GeneratedValue // Annotation that specifies that the value of the primary key should be automatically generated.
    private Long portfolioId; // Field to store the portfolioId. Long is a wrapper class for the primitive data type long.

    @OneToOne // Annotation that marks this as a One-to-One relationship with another entity, in this case, the Client entity.
    @JoinColumn(name = "client_id", nullable = false) // Specifies the column that will act as a foreign key.
    private Client client; // Field that represents the Client associated with this portfolio.

    @Column(nullable = false) // Annotation specifies that this field will be a column in the database and should not be null.
    private Date creationDate; // Field to store the creationDate of the portfolio. Date is a class representing date and time.

    protected Portfolio() {
        // Default constructor needed by JPA. The 'protected' keyword makes it accessible only within this class and subclasses.
    }

    public Portfolio(Client client, Date creationDate) {
        // Constructor that initializes the client and creationDate fields. It is used when creating a new Portfolio object.
        this.client = client;
        this.creationDate = creationDate;
    }

    // Below are getter and setter methods for each field.
    // These methods allow other parts of the application to access (get) or modify (set) the values of the fields.

    public Long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

