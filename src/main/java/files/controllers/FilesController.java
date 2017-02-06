package files.controllers;

import files.model.FileRefer;
import files.model.InFile;
import files.repository.FilesMongoRepository;
import files.repository.FilesSearchRepository;
import files.repository.InFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FilesController {

    @Autowired
    private FilesMongoRepository fileRepository;

    @Autowired
    private FilesSearchRepository fileSearchRepository;

    @Autowired
    private InFilesRepository inFilesRepository;

    ////////////////////////////////////////////////////////////////////////////upload

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FileRefer upload(@RequestBody InFile inFile) {

        InFile storedFile = fileRepository.save(inFile);

        FileRefer refer = new FileRefer();
        refer.setFileName(storedFile.getName());
        refer.setId(storedFile.getIda());

        System.out.println("id: " + storedFile.getIda());
        System.out.println("name: " + storedFile.getName());
        System.out.println("content: " + storedFile.getFile());

        return refer;
    }


    @RequestMapping(value = "/listFiles", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable home() {

        return fileRepository.findAll();
    }


    @RequestMapping(value = "/download", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String search(@RequestParam String id) {

       System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx  " + id);

       return inFilesRepository.findOne(id).getFile();

//       ResponseEntity<String> entity = new ResponseEntity<String>(
//               inFilesRepository.findOne(id).getFile()
//               , HttpStatus.OK);

    }


}