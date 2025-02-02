package pl.kwi.chrisblog.db.repositories;

import org.springframework.data.repository.CrudRepository;

import io.micrometer.observation.annotation.Observed;
import pl.kwi.chrisblog.db.entities.CategoryEntity;

@Observed
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
	
}
