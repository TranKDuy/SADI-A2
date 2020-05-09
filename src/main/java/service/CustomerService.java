package service;

import entity.Customer;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service

public class CustomerService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Customer addCustomer(Customer customer){
        sessionFactory.getCurrentSession().save(customer);
        return customer;
    }
    public Customer updateCustomer(Customer customer){
        sessionFactory.getCurrentSession().update(customer);
        return customer;
    }
    public Customer getCustomer(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Customer where id=:id");
        query.setInteger("id", id);

        return (Customer) query.uniqueResult();

    }
    public int deleteCustomer(int id){
        Customer customer = getCustomer(id);
        this.sessionFactory.getCurrentSession().delete(customer);
        return id;
    }
    public List<Customer> getAllCustomer(){
        return sessionFactory.getCurrentSession().createQuery("from Customer").list();
    }
}
