package myLibrary;

import libraryFXclient.to.Reader;
import libraryFXclient.to.ReaderTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.ReadersRepository;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ReadersController {

    @Autowired
    ReadersRepository readersRepository;

    @ResponseBody
    @GetMapping("/readers")
    public List<Reader> getReadersToController(){

        return readersRepository.getReadersToRepository();
    }

    @ResponseBody
    @PostMapping("/reader/add")
    public String addReader (@RequestBody ReaderTO reader, HttpServletRequest request){

        readersRepository.createNewReaderStatement(reader.getFirstName(), reader.getLastName(),
                reader.getTel(), reader.getAddress(), reader.getLogin(), reader.getPassword());
        return "200";
    }

    // getActiveReaders

}
