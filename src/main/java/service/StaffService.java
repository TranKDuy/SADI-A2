package service;
import entity.Staff;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service

public class StaffService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Staff addStaff(Staff staff){
        sessionFactory.getCurrentSession().save(staff);
        return staff;
    }
    public Staff updateStaff(Staff staff){
        sessionFactory.getCurrentSession().update(staff);
        return staff;
    }
    public Staff getStaff(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Staff where id=:id");
        query.setInteger("id", id);

        return (Staff) query.uniqueResult();

    }
    public int deleteStaff(int id){
        Staff staff = getStaff(id);
        this.sessionFactory.getCurrentSession().delete(staff);
        return id;
    }
    public List<Staff> getAllStaff(){
        return sessionFactory.getCurrentSession().createQuery("from Staff").list();
    }
}
