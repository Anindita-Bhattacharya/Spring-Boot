package firstspring;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<User, Long>{

}
