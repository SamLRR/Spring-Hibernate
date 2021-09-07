package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
    @Override
    public User getUserByModelAndSeries(String model, int series) {
        TypedQuery<User> query = sessionFactory
                .getCurrentSession()
                .createQuery("select u from User u join u.car cr where ( cr.model= :model and cr.series = :series)")
                .setParameter("model", model)
                .setParameter("series", series);
        return query.getResultList().stream().findAny().orElse(null);
    }
}
