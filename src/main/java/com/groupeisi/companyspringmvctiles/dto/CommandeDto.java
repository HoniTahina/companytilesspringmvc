package com.groupeisi.companyspringmvctiles.dto;

import com.groupeisi.companyspringmvctiles.entities.PanierEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class CommandeDto {
    private long id;
    private Date date;
    private PanierDto panier;

    public CommandeDto(long id, Date date, PanierDto panier) {
        this.id = id;
        this.date = date;
        this.panier = panier;
    }
    public CommandeDto() {}

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

    public PanierDto getPanier() {
        return panier;
    }

    public void setPanier(PanierDto panier) {
        this.panier = panier;
    }
}
