package PopulateBean;

public class TestBean {

    private Student student;

    public void echo() {
        System.out.println("I'm a student : " + student);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
