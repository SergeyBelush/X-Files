package files.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inFile")
public class InFile {
	
	private String name;

	private String file;

	@Id
	private String ida;

/////////////////////////////////////////

	public String getFile() {

		return file;
	}

	public void setFile(String file) {

		this.file = file;
	}


	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getIda() {
		return ida;
	}

	public void setIda(String id) {
		this.ida = id;
	}

	public InFile() {

	}


	@Override
	public String toString() {
		return "InFile{" +
				"name='" + name + '\'' +
				", file='" + file + '\'' +
				", id='" + ida + '\'' +
				'}';
	}
}
