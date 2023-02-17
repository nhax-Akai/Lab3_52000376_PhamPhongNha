package dao;

import java.util.List;

import domain.Phone;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

public class PhoneDAO {
    public boolean add(Phone p) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(p);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Phone get(String id) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            return session.get(Phone.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Phone> getAll() {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            return session.createQuery("from Phone", Phone.class).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean update(Phone p) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(p);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean remove(Phone p) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(p);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean removeById(String id) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Phone p = session.get(Phone.class, id);
            session.remove(p);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Phone highestPrice() {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            return session.createQuery("from Phone order by price desc", Phone.class).setMaxResults(1).uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // A method to get a list of phones sorted by country name, if two phones have
    // the same country, sort descending by price.
    public List<Phone> sortPhoneByCountry() {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            return session.createQuery("from Phone order by country desc, price desc", Phone.class).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // A method to check if there is a phone priced above 50 million VND.
    public boolean checkPhonePrice(String id) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            return session.createQuery("from Phone where price > 50000000", Phone.class).setMaxResults(1)
                    .uniqueResult() != null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;

    }

    // A method to get the first phone in the list that meets the criteria: has the
    // color 'Pink' and costs over 15 million. If there are no matching phones,
    // return null.
    public Phone getPhoneByColorAndPrice() {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            return session.createQuery("from Phone where color = 'Pink' and price > 15000000", Phone.class)
                    .setMaxResults(1).uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
