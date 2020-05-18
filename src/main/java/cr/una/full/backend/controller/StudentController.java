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

package cr.una.full.backend.controller;

import cr.una.full.backend.exception.DAOException;
import cr.una.full.backend.exception.ServiceException;
import cr.una.full.backend.model.Student;
import cr.una.full.backend.service.StudentService;
import cr.una.full.backend.service.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping(value = "/api/students")
public class StudentController {

    private StudentService studentService = new StudentServiceImpl();

    @GetMapping()
    @ResponseBody
    public List<Student> findAll() {
        List<Student> studentList = null;
        try {
            studentList = studentService.findAll();
        } catch (DAOException ex) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", ex);
        } catch (ServiceException ex) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", ex);
        }
        return studentList;
    }

    @GetMapping("{id}")
    @ResponseBody
    public Student findById(@PathVariable int id) {
        Student student = null;
        try {
            student = studentService.findById(id);
        } catch (DAOException bex) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,"Error importante - Capa DAO", bex);
        } catch (ServiceException ex) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", ex);
        }

        return student;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Student save(@RequestBody Student student) {
        Student studentSaved = null;
        try {
            studentSaved = studentService.save(student);
        } catch (DAOException bex) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa DAO", bex);
        } catch (ServiceException ex) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Error importante - Capa Service", ex);
        }
        return studentSaved;
    }
}
