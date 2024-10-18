package com.groupeisi.companyspringmvctiles.dao;

import com.groupeisi.companyspringmvctiles.entities.CommandeEntity;
import com.groupeisi.companyspringmvctiles.entities.ProductEntity;

import javax.persistence.criteria.*;
import java.util.Optional;


public class CommandeDao extends RepositoryImpl<CommandeEntity> implements ICommandeDao {

    @Override
    public Optional<CommandeEntity> findById(long id) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<CommandeEntity> cr = cb.createQuery(CommandeEntity.class);
        Root<CommandeEntity> commande = cr.from(CommandeEntity.class);

        Predicate predicateRef = cb.equal(commande.get("id"), id);

        cr.select(commande).where(predicateRef);

        try {
            return Optional.ofNullable(session.createQuery(cr).getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean update(CommandeEntity commandeEntity) {
        session.getTransaction().begin();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<CommandeEntity> update = cb.createCriteriaUpdate(CommandeEntity.class);
        Root<CommandeEntity> product = update.from(CommandeEntity.class);

        update.set("date", commandeEntity.getDate());
        update.set("panier", commandeEntity.getPanier());

        Predicate predicateRef = cb.equal(product.get("id"), commandeEntity.getId());
        update.where(predicateRef);

        int rowsAffected = session.createQuery(update).executeUpdate();

        session.getTransaction().commit();

        return rowsAffected > 0;
    }
}
