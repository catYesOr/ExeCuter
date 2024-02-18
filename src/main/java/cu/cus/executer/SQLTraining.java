package cu.cus.executer;

// Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLTraining {
    public static void main(String[] args) {
        // Load the PostgreSQL JDBC driver
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL JDBC Driver загружен успешно.");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке PostgreSQL JDBC Driver!");
            e.printStackTrace();
            return;
        }

        // Connect to PostgreSQL
        String url = "jdbc:postgresql://localhost:5432/mycustomdb";
        String user = "mycustomuser";
        String password = "mycustompassword";

        System.out.println("Попытка соединения с базой данных...");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Успешное соединение с базой данных!");
            System.out.println("Connection: " + connection);

            // Create a table
            String sql = "CREATE TABLE IF NOT EXISTS employees ("
                    + "id serial PRIMARY KEY,"
                    + "first_name VARCHAR (50) NOT NULL,"
                    + "last_name VARCHAR (50) NOT NULL,"
                    + "email VARCHAR (50) NOT NULL UNIQUE,"
                    + "phone VARCHAR (50) NOT NULL UNIQUE"
                    + ")";

            // Execute statement
            connection.createStatement().execute(sql);

            // Create employees
            String sql2 = "INSERT INTO employees (first_name, last_name, email, phone) VALUES ('John', 'Doe', 'john.doe@example.com', '555-1234'), ('Jane', 'Doe', 'jane.doe@example.com', '555-5678')";

        } catch (SQLException e) {
            System.out.println("Ошибка при соединении с базой данных:");
            e.printStackTrace();
        }
    }
}
