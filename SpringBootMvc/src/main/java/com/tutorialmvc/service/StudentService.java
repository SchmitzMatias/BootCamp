package com.tutorialmvc.service;

import java.util.Collection;

import com.tutorialmvc.dao.StudentDao;
import com.tutorialmvc.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	@Qualifier("fakeData")
	private StudentDao studentDao;
	
	public Collection<Student> getAllStudents(){
		return studentDao.getAllStudents();
	}

	public Student getStudentById(int id){
		return this.studentDao.getStudentById(id);
	}

	public void removeStudentById(int id) {
		this.studentDao.removeStudentById(id);
	}	

	public void updateStudent(Student student){
		this.studentDao.updateStudent(student);
	}

	public void insertStudent(Student student) {
		studentDao.insertStudentToDb(student);
	}
}
