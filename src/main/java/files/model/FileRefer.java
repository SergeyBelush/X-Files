package files.model;

/**
 * Created by Сергей on 28.01.2017.
 */
public class FileRefer {

    private String fileName;

    private String id;

    ////////////////////////////////////

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileRefer() {

    }

    @Override
    public String toString() {
        return "FileRefer{" +
                "fileName='" + fileName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}