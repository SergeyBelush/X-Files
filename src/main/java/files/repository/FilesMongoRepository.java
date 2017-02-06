package files.repository;

import files.model.InFile;
import org.springframework.data.repository.CrudRepository;

public interface FilesMongoRepository extends CrudRepository<InFile, String>{
}