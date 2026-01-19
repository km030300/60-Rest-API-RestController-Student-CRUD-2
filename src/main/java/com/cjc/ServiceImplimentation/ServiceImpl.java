package com.cjc.ServiceImplimentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.Repository.StudentRepository;
import com.cjc.Service.StudentService;
import com.cjc.exception.InvalidCredentialsException;
import com.cjc.exception.StudentException;
import com.cjc.model.Student;

@Service
public class ServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentrepository;

	@Override
	public Student saveStudnts(Student stu) {
		Student save = studentrepository.save(stu);
		return save;
	}

	@Override
	public Student getStudent(int id) {

		if (studentrepository.existsById(id)) {
			Student getstudent = studentrepository.findById(id).get();
			return getstudent;
		}
		throw new StudentException("Student ID is not in Database: " + id);
	}

	@Override
	public List<Student> getallStudent() {

		return studentrepository.findAll();
	}

	@Override
	public String deletestudent(int id) {
		String msg = "";
		if (studentrepository.existsById(id)) {
			studentrepository.deleteById(id);
			msg = "Student Delete Successfully";
			return msg;
		}
		msg = "ID Doesn't Exist";
		return msg;
	}

	@Override
	public Student updatestudent(int id, Student stu) {
		if (studentrepository.existsById(id)) {
			Student student = studentrepository.findById(id).get();

			student.setName(stu.getName());
			student.setMarks(stu.getMarks());

			Student updatesave = studentrepository.save(student);
			return updatesave;

		}
		return null;
	}

	@Override
	public Student editfield(int id, Student stu) {
		if (studentrepository.existsById(id)) {
			Student dbstudent = studentrepository.findById(id).get();

			if (stu.getName() != null) {
				dbstudent.setName(stu.getName());

			}
			// When we use Wrapper Class For numerical value (before:-double=0.0,After:-
			// Double=null )
			if (stu.getMarks() != 0.0) {
				dbstudent.setMarks(stu.getMarks());
			}
			Student editsave = studentrepository.save(dbstudent);
			return editsave;
		}
		return null;
	}

	@Override
	public String logincheck(String username, String password) {
		Student student = studentrepository.findByUsernameAndPassword(username, password);

		if (student != null) {
			return "Login SuccessFull";
		}

		throw new InvalidCredentialsException("Invalid Credentials");// Also USe (StudentExceptionClass)
	}

}
