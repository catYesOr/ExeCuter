package cu.cus.executer;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EmployeeRepository<T extends AbstractPersistable> extends ListCrudRepository<T, PK> {
}