package com.groupeisi.companyspringmvctiles.dao;

import com.groupeisi.companyspringmvctiles.entities.ClientEntity;
import com.groupeisi.companyspringmvctiles.entities.ProductEntity;

import javax.persistence.criteria.*;
import java.util.Optional;


public class ClientDao extends RepositoryImpl<ClientEntity> implements IClientDao {

    @Override
    public Optional<ClientEntity> findByTel(String tel) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<ClientEntity> cr = cb.createQuery(ClientEntity.class);
        Root<ClientEntity> client = cr.from(ClientEntity.class);

        Predicate predicateRef = cb.equal(client.get("tel"), tel);

        cr.select(client).where(predicateRef);

        try {
            return Optional.ofNullable(session.createQuery(cr).getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean update(ClientEntity clientEntity) {
        session.getTransaction().begin();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<ClientEntity> update = cb.createCriteriaUpdate(ClientEntity.class);
        Root<ClientEntity> product = update.from(ClientEntity.class);

        update.set("firstname", clientEntity.getFirstname());
        update.set("lastname", clientEntity.getLastname());
        update.set("email", clientEntity.getEmail());
        update.set("password", clientEntity.getPassword());
        update.set("tel", clientEntity.getTel());
        update.set("address", clientEntity.getAddress());

        Predicate predicateRef = cb.equal(product.get("id"), clientEntity.getId());
        update.where(predicateRef);

        int rowsAffected = session.createQuery(update).executeUpdate();

        session.getTransaction().commit();

        return rowsAffected > 0;
    }
}
