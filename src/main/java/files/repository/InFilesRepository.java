package files.repository;

import files.model.InFile;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Belush_SA on 31.01.2017.
 */
public interface InFilesRepository extends MongoRepository<InFile, String> {


}
