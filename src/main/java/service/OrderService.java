package service;

import entity.ProviderOrder;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class OrderService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public ProviderOrder addOrder(ProviderOrder order) {
        sessionFactory.getCurrentSession().save(order);
        return order;
    }

    public ProviderOrder getOrder(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from ProviderOrder where id=:id");
        query.setInteger("id", id);

        return(ProviderOrder) query.uniqueResult();

    }

    public int deleteOrder(int id){
        ProviderOrder order = getOrder(id);
        this.sessionFactory.getCurrentSession().delete(order);
        return id;
    }
    public List<ProviderOrder> getAllOrders(){
        return sessionFactory.getCurrentSession().createQuery("from ProviderOrder").list();
    }
}
