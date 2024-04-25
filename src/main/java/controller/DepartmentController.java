package controller;

import model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class DepartmentController {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        try {
            // Perform CRUD operations
            addDepartment(session);  // Uncomment to add department
//            findDepartment(session, 2);
//            updateDepartment(session, 3); // Replace '3' with the actual user ID you want to update
//            deleteDepartment(session, 4); // Replace '4' with the actual user ID you want to delete
        } finally {
            session.close();
            factory.close();
        }
    }

    public static void addDepartment(Session session) {
        Transaction transaction = session.beginTransaction();
        try {
            Department dOne = new Department("one", "Colorado");
            Department dTwo = new Department("Two", "Florida");
            Department dThree = new Department("Three", "Texas");
            Department dFour = new Department("Four", "Nebraska");
            Department dFive = new Department("Five", "Utah");

            session.persist(dOne);
            session.persist(dTwo);
            session.persist(dThree);
            session.persist(dFour);
            session.persist(dFive);

            transaction.commit();
            System.out.println("Departments added successfully");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void findDepartment(Session session, int departmentId) {
        Transaction transaction = session.beginTransaction();
        try {
            Department department = session.get(Department.class, departmentId);
            if (department != null) {
                System.out.println("Department found: " + department.getName());
            } else {
                System.out.println("No department found with ID: " + departmentId);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void updateDepartment(Session session, int departmentId) {
        Transaction transaction = session.beginTransaction();
        try {
            Department department = session.get(Department.class, departmentId);
            if (department != null) {
                department.setName("Updated Name");
                department.setState("Updated State");
                session.update(department);
                transaction.commit();
                System.out.println("Department updated successfully");
            } else {
                System.out.println("No Department found to update.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void deleteDepartment(Session session, int departmentId) {
        Transaction transaction = session.beginTransaction();
        try {
            Department department = session.get(Department.class, departmentId);
            if (department != null) {
                session.delete(department);
                transaction.commit();
                System.out.println("Department deleted successfully.");
            } else {
                System.out.println("No department found to delete.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

}
