package cu.cus.executer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ExeCuterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExeCuterApplication.class, args);
    }

}
