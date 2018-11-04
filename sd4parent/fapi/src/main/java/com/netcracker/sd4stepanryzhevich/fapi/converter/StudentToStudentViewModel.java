package com.netcracker.sd4stepanryzhevich.fapi.converter;


import com.netcracker.sd4stepanryzhevich.be.entity.Student;
import com.netcracker.sd4stepanryzhevich.be.entity.StudentsGroup;
import com.netcracker.sd4stepanryzhevich.fapi.models.StudentViewModel;
import org.springframework.core.convert.converter.Converter;

public class StudentToStudentViewModel implements Converter <Student, StudentViewModel>{
    @Override
    public StudentViewModel convert(Student student) {
        StudentViewModel studentViewModel = new StudentViewModel();

        studentViewModel.setId_student(student.getId_student());
        studentViewModel.setFirstname(student.getFirstname());
        studentViewModel.setSecondname(student.getSecondname());
        studentViewModel.setPatronymic(student.getPatronymic());
        studentViewModel.setTelnumber(student.getTelnumber());
        studentViewModel.setEmail(student.getEmail());
        studentViewModel.setCourse(student.getCourse());
        studentViewModel.setSubgroup(student.getSubgroup());

        StudentsGroup group = student.getStudentsGroup();
        if(group != null){
            studentViewModel.setId_group(group.getId_group());
            studentViewModel.setGroupName(group.getName());
        }
        return studentViewModel;
    }
}
