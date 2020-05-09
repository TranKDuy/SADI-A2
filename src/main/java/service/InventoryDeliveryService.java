package service;

import entity.InventoryDeliveryNote;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service

public class InventoryDeliveryService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public InventoryDeliveryService addDeliveryNote(InventoryDeliveryService inventoryDeliveryService) {
        sessionFactory.getCurrentSession().save(inventoryDeliveryService);
        return inventoryDeliveryService;
    }

    public InventoryDeliveryService updateDeliveryNote(InventoryDeliveryService inventoryDeliveryService) {
        sessionFactory.getCurrentSession().update(inventoryDeliveryService);
        return inventoryDeliveryService;
    }

    public InventoryDeliveryService getDeliveryNote(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from InventoryDeliveryNote where id=:id");
        query.setInteger("id", id);

        return (InventoryDeliveryService) query.uniqueResult();

    }

    public int deleteDeliveryNote(int id) {
        InventoryDeliveryService inventoryDeliveryService = getDeliveryNote(id);
        this.sessionFactory.getCurrentSession().delete(inventoryDeliveryService);
        return id;
    }

    public List<InventoryDeliveryNote> findDeliveryNote(String date) {
        Query query = sessionFactory.getCurrentSession().createQuery("from InventoryDeliveryNote s where s.date like :date");

        query.setString("date", "%" + date + "%");

        return query.list();
    }
}
