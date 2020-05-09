package service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class InventoryReceivingService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    public InventoryReceivingService addReceivingNote(InventoryReceivingService inventoryReceivingService){
        sessionFactory.getCurrentSession().save(inventoryReceivingService);
        return inventoryReceivingService;
    }
    public InventoryReceivingService updateReceivingNote(InventoryReceivingService inventoryReceivingService){
        sessionFactory.getCurrentSession().update(inventoryReceivingService);
        return inventoryReceivingService;
    }
    public InventoryReceivingService getReceivingNote(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from InventoryReceivingNote where id=:id");
        query.setInteger("id", id);

        return (InventoryReceivingService) query.uniqueResult();

    }
    public int deleteReceivingNote(int id){
        InventoryReceivingService inventoryReceivingService = getReceivingNote(id);
        this.sessionFactory.getCurrentSession().delete(inventoryReceivingService);
        return id;
    }
}
