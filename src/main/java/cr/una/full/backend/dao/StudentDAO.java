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

public interface StudentDAO {
    public Student findById (int id) throws DAOException;
    public Student save(Student student) throws DAOException;
    public Student update(Student student) throws DAOException;
    public List<Student> findAll() throws DAOException;
    public boolean delete(int id) throws DAOException;
}
