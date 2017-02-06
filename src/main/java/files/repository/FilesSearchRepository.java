package files.repository;

import files.model.InFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FilesSearchRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Optional<InFile> searchFiles(String id) {
		List<InFile> files =  mongoTemplate.find(Query.query(new Criteria()
				.orOperator(Criteria.where("ida").regex(id, "i"))
		), InFile.class);

		return Optional.of(files.get(0));
	}

}