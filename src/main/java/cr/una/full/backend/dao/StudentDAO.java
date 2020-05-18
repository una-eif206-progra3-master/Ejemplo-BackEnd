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

import java.util.List;

/**
 * Student DAO
 */
public interface StudentDAO {
    /**
     * Find the student that match with the id
     * @param id the identify of the student
     * @return the Student entity
     * @throws DAOException DAO Exception
     */
    public Student findById (int id) throws DAOException;

    /**
     * Save a new student in the database
     * @param student is the entity of Student
     * @return the updated student entity with the corresponding id
     * @throws DAOException DAO Exception
     */
    public Student save(Student student) throws DAOException;

    /**
     * Update a stutent in the database
     * @param student is the entity of Student
     * @return the udpated student entity
     * @throws DAOException DAO Exception
     */
    public Student update(Student student) throws DAOException;

    /**
     * Fina all the sutudent in the database
     * @return a list of students
     * @throws DAOException DAO Exception
     */
    public List<Student> findAll() throws DAOException;

    /**
     * Delete a student in the database
     * @param id the identify of the student
     * @return true if a success delete
     * @throws DAOException DAO Exception
     */
    public boolean delete(int id) throws DAOException;
}
