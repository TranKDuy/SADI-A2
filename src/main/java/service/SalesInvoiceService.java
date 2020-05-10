package service;

import entity.SalesInvoice;
import entity.Staff;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.util.List;

@Transactional
@Service
public class SalesInvoiceService {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SalesInvoice addSalesInvoices(SalesInvoice salesInvoice){
        sessionFactory.getCurrentSession().save(salesInvoice);
        return salesInvoice;
    }
    public SalesInvoice updateSalesInvoice(SalesInvoice salesInvoice){
        sessionFactory.getCurrentSession().update(salesInvoice);
        return salesInvoice;
    }
    public SalesInvoice getSalesInvoice(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from SalesInvoice where id=:id");
        query.setInteger("id", id);

        return (SalesInvoice) query.uniqueResult();

    }
    public int deleteSalesInvoices(int id){
        SalesInvoice salesInvoice = getSalesInvoice(id);
        this.sessionFactory.getCurrentSession().delete(salesInvoice);
        return id;
    }
    public List<SalesInvoice> getAllSalesInvoices(){
        return sessionFactory.getCurrentSession().createQuery("from SalesInvoice").list();
    }
}
