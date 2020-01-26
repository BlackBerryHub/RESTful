package rest.solution;
import org.springframework.stereotype.Repository;
import rest.solution.Model;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface dbFunc extends JpaRepository<Model, Long> {
}
