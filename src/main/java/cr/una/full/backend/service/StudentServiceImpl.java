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

package cr.una.full.backend.service;

import cr.una.full.backend.dao.StudentDAO;
import cr.una.full.backend.dao.StudentDAOImpl;
import cr.una.full.backend.exception.DAOException;
import cr.una.full.backend.exception.ServiceException;
import cr.una.full.backend.model.Student;

import java.util.List;

/**
 * The Student service implementation
 */
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;
    List<Student> listStudents = null;

    /**
     * Find All student
     *
     * @return a list of students
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public List<Student> findAll() throws DAOException, ServiceException {
        List<Student> listStudents = null;
        studentDAO = new StudentDAOImpl();
        listStudents = studentDAO.findAll();
        return listStudents;
    }

    /**
     * Find students by id
     *
     * @param id the identify of the student
     * @return the student found
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public Student findById(int id) throws DAOException, ServiceException {
        Student student = null;
        studentDAO = new StudentDAOImpl();
        student = studentDAO.findById(id);

        return student;
    }

    /**
     * Save student in the databse
     *
     * @param student the student entity with the information to save
     * @return the saved student entity
     * @throws DAOException DAO Exception
     * @throws ServiceException Service Exception
     */
    @Override
    public Student save(Student student) throws DAOException, ServiceException {
        Student studentSaved;
        studentDAO = new StudentDAOImpl();
        studentSaved = studentDAO.save(student);
        return studentSaved;
    }
}
