package com.groupeisi.companyspringmvctiles.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

public class CommandeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "panier", nullable = false)
    private PanierEntity panier;

    public CommandeEntity(long id, Date date, PanierEntity panier) {
        this.id = id;
        this.date = date;
        this.panier = panier;
    }
    public CommandeEntity() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PanierEntity getPanier() {
        return panier;
    }

    public void setPanier(PanierEntity panier) {
        this.panier = panier;
    }
}
