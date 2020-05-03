package service;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import entity.Product;

import java.util.List;

@Transactional
@Service
public class ProductService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Product addProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
        return product;
    }
    //Update exist Product in the database
    public Product updateProduct(Product product){
        sessionFactory.getCurrentSession().update(product);
        return product;
    }
    //Get the product by their id
    public Product getProduct(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Product where id=:id");
        query.setInteger("id", id);

        return (Product) query.uniqueResult();

    }
    //Delete Product by their Id
    public int deleteProduct(int id){
        Product product = getProduct(id);
        this.sessionFactory.getCurrentSession().delete(product);
        return id;
    }
    //Get teacher by their name
    public List<Product> findProduct(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("from Product s where s.name like :name");
        query.setString("name", "%"+name+"%");
        return query.list();
    }

}
