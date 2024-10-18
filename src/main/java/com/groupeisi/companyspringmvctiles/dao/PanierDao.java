package com.groupeisi.companyspringmvctiles.dao;

import com.groupeisi.companyspringmvctiles.entities.PanierEntity;
import com.groupeisi.companyspringmvctiles.entities.ProductEntity;

import javax.persistence.criteria.*;
import java.util.Optional;


public class PanierDao extends RepositoryImpl<PanierEntity> implements IPanierDao {

    @Override
    public Optional<PanierEntity> findById(long id) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<PanierEntity> cr = cb.createQuery(PanierEntity.class);
        Root<PanierEntity> panier = cr.from(PanierEntity.class);

        Predicate predicateRef = cb.equal(panier.get("id"), id);

        cr.select(panier).where(predicateRef);

        try {
            return Optional.ofNullable(session.createQuery(cr).getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean update(PanierEntity panierEntity) {
        session.getTransaction().begin();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<PanierEntity> update = cb.createCriteriaUpdate(PanierEntity.class);
        Root<PanierEntity> panier = update.from(PanierEntity.class);

        update.set("products", panierEntity.getProducts());
        update.set("date", panierEntity.getDate());
        update.set("client", panierEntity.getClient());

        Predicate predicateRef = cb.equal(panier.get("id"), panierEntity.getId());
        update.where(predicateRef);

        int rowsAffected = session.createQuery(update).executeUpdate();

        session.getTransaction().commit();

        return rowsAffected > 0;
    }
}
