package myLibrary;

import libraryFXclient.to.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import repository.LibrariansRepository;

import java.util.List;

@RestController
public class LibrariansController {

    @Autowired
    LibrariansRepository librariansRepository;

    @ResponseBody
    @GetMapping("/librarians")
    public List<Librarian> getLibrariansToController(){

        return librariansRepository.getLibrariansToRepository();
    }
}
