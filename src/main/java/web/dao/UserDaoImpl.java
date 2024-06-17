package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() {
    }

    @Override
    public List<User> allUsers() {
        Session session =sessionFactory.getCurrentSession();
        CriteriaBuilder builder =session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        criteria.from(User.class);
        List<User> users = session.createQuery(criteria).getResultList();
        return users;
    }

    @Override
    public User showUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where id=:id");
        User user = (User) query.setParameter("id", id).getSingleResult();
        return user;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(new User(user.getName(), user.getSurname(), user.getAge()));
    }

    @Override
    public void updateUser(User editedUser) {
        Session session = sessionFactory.getCurrentSession();
        session.update(editedUser);
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.find(User.class, id));
    }
}
