/*
 *
 * Copyright (C)  2020  mike.education
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Universidad Nacional de Costa Rica, Prof: Maikol Guzman Alan.
 */

package cr.una.full.backend.dao;

import cr.una.full.backend.exception.DAOException;
import cr.una.full.backend.model.Student;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The DAO implementation of Student
 */
public class StudentDAOImpl implements StudentDAO {
    private final Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Default constructor
     * @throws DAOException
     */
    public StudentDAOImpl() throws DAOException {
    }


    /**
     * Find the student that match with the id
     *
     * @param id the identify of the student
     * @return the Student entity
     * @throws DAOException
     */
    @Override
    public Student findById(int id) throws DAOException {
        Student student;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query q=session.createQuery(query);
        student= (Student) q.getSingleResult();

        return student;
    }

    /**
     * Save a new student in the database
     *
     * @param student is the entity of Student
     * @return the updated student entity with the corresponding id
     * @throws DAOException
     */
    @Override
    public Student save(Student student) throws DAOException {
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();

        return student;
    }

    /**
     * Update a stutent in the database
     *
     * @param student is the entity of Student
     * @return the udpated student entity
     * @throws DAOException
     */
    @Override
    public Student update(Student student) throws DAOException {
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();

        return student;
    }

    /**
     * Fina all the sutudent in the database
     *
     * @return a list of students
     * @throws DAOException
     */
    @Override
    public List<Student> findAll() throws DAOException {
        List<Student> studentList;

        studentList = session.createQuery("from Student", Student.class).list();

        return studentList;
    }

    /**
     * Delete a student in the database
     *
     * @param id the identify of the student
     * @return true if a success delete
     * @throws DAOException
     */
    @Override
    public boolean delete(int id) throws DAOException {
        boolean isDeleted;
        Student student;

        session.beginTransaction();
        student = session.get(Student.class, id);
        session.delete(student);
        isDeleted = true;
        session.getTransaction().commit();

        return isDeleted;
    }
}