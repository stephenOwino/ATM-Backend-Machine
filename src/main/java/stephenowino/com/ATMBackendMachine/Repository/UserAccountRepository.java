package stephenowino.com.ATMBackendMachine.Repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stephenowino.com.ATMBackendMachine.Model.UserAccount;

@Repository
@Configuration
public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
}
