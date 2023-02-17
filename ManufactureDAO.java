package dao;

import java.util.List;

import domain.Manufacture;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

public class ManufactureDAO {
    public boolean add(Manufacture m) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(m);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static Manufacture get(String id) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            return session.get(Manufacture.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Manufacture> getAll() {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            return session.createQuery("from manufacture", Manufacture.class).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean update(Manufacture m) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(m);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean remove(Manufacture m) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(m);
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
            Manufacture m = session.get(Manufacture.class, id);
            session.remove(m);
            tx.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // A method to check whether all manufacturers have more than 100 employees.
    public boolean checkManufacturers() {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            List<Manufacture> manufactures = session.createQuery("from Manufacture", Manufacture.class).list();
            for (Manufacture m : manufactures) {
                if (m.getEmployee() < 100) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // A method that returns the sum of all employees of the manufactures.
    public int sumOfEmployees() {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            List<Manufacture> manufactures = session.createQuery("from Manufacture", Manufacture.class).list();
            int sum = 0;
            for (Manufacture m : manufactures) {
                sum += m.getEmployee();
            }
            return sum;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    // A method that returns the last manufacturer in the list of manufacturers that
    // meet the criteria: based in the US. If there is no producer that meets the
    // above criteria, throw an InvalidOperationException.
    public Manufacture lastUSManufacture() {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            List<Manufacture> manufactures = session.createQuery("from Manufacture", Manufacture.class).list();
            for (int i = manufactures.size() - 1; i >= 0; i--) {
                if (manufactures.get(i).getLocation().equals("US")) {
                    return manufactures.get(i);
                }
            }
            throw new IllegalStateException("No manufacturer in the US");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
