//package cu.cus.executer;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class EmployeeDAO {
//
//    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();
//
//    public EmployeeDAO() {
//    }
//
//    public List<Employee> getAllEmployees() {
//        String sql = "SELECT * FROM employees";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            return new Employee(   rs.getLong("id"),
//                                                rs.getString("name"),
//                                                rs.getInt("age"),
//                                                rs.getString("address"),
//                                                rs.getDouble("salary"));
//        });
//    }
//
//    public void addEmployee(Employee employee) {
//        String sql = "INSERT INTO employees (name, salary) VALUES (?, ?)";
//        jdbcTemplate.update(sql, employee.getName(), employee.getSalary());
//    }
//
//    public void updateEmployee(Employee employee) {
//        String sql = "UPDATE employees SET name = ?, salary = ? WHERE id = ?";
//        jdbcTemplate.update(sql, employee.getName(), employee.getSalary(), employee.getId());
//    }
//    public void deleteEmployee(Long id) {
//        String sql = "DELETE FROM employees WHERE id = ?";
//        jdbcTemplate.update(sql, id);
//    }
//    public Employee getEmployeeById(Long id) {
//        String sql = "SELECT * FROM employees WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
//            Employee employee = new Employee(   rs.getLong("id"),
//                                                rs.getString("name"),
//                                                rs.getInt("age"),
//                                                rs.getString("address"),
//                                                rs.getDouble("salary"));
//            return employee;
//        });
//    }
//    public List<Employee> getEmployeesByName(String name) {
//        String sql = "SELECT * FROM employees WHERE name = ?";
//        return jdbcTemplate.query(sql, new Object[]{name}, (rs, rowNum) -> {
//            Employee employee = new Employee(   rs.getLong("id"),
//                                                rs.getString("name"),
//                                                rs.getInt("age"),
//                                                rs.getString("address"),
//                                                rs.getDouble("salary"));
//            return employee;
//        });
//    }
//
//    public static void main(String[] args) {
//        EmployeeDAO employeeDAO = new EmployeeDAO();
//        List<Employee> employees = employeeDAO.getAllEmployees();
//        System.out.println(employees);
//        System.out.println(employeeDAO.getEmployeeById(1L));
//        System.out.println(employeeDAO.getEmployeesByName("John"));
//    }
//}