package pl.kwi.chrisblog.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.micrometer.observation.annotation.Observed;
import pl.kwi.chrisblog.db.entities.TagEntity;

@Observed
public interface TagRepository extends CrudRepository<TagEntity, Long> {
	
	@Query("SELECT t FROM TagEntity t JOIN t.articles a WHERE a.category.id = (:categoryId) GROUP BY t.name, t.id ORDER BY t.name ASC")
	public List<TagEntity> findAllByCategoryId(@Param("categoryId") long categoryId);
	
}
