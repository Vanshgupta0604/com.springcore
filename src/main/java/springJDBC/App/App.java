package springJDBC.App;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import springJDBC.dao.Studentdao;
import springJDBC.entities.Student;

public class App {
    public static void main(String[] args) {
        System.out.println("My program started");
        // spring jdbc => JdbcTemplate
        ApplicationContext context = new ClassPathXmlApplicationContext("springjdbc/config.xml");
        /*JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        //insert query
        String query = "insert into student(id,name,city) values(?,?,?)";
        //fire query
        int result = template.update(query,459,"Vansh","ptk");
        System.out.println("number of record inserted.."+result);
         */
        Studentdao studentdao = context.getBean("studentdao", Studentdao.class);
        Student student = new Student();
        student.setId(666);
        student.setName("John");
        student.setCity("Lucknow");

        int result = studentdao.insert(student);
        System.out.println("student added" + result);
    }
}
