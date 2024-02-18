package cu.cus.executer;

import org.apache.camel.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;

@Configuration
@ConditionalOnClass(ExampleService.class)
public class ExampleAutoConfiguration {
    public ExampleService exampleService() {
        return new ExampleServiceImpl();
    }
}
