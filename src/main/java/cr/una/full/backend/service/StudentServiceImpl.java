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
import cr.una.full.backend.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;
    List<Student> listStudents = null;

    @Override
    public List<Student> findAll() {
        List<Student> listStudents = null;
        studentDAO = new StudentDAOImpl();
        listStudents = studentDAO.findAll();
        return listStudents;
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        studentDAO = new StudentDAOImpl();
        student = studentDAO.findById(id);

        return student;
    }

    @Override
    public Student save(Student student) {
        Student studentSaved;
        studentDAO = new StudentDAOImpl();
        studentSaved = studentDAO.save(student);
        return studentSaved;
    }

}
