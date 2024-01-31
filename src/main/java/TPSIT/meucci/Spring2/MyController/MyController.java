package TPSIT.meucci.Spring2.MyController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TPSIT.meucci.Spring2.model.Persona;
import TPSIT.meucci.Spring2.repository.PersonaRepository;


@RestController
@RequestMapping("/persona")
public class MyController {

    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/list")
    public List<Persona> list() {
        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Persona readOne(@PathVariable("id") long id){
        return personaRepository.findById(id).get();
    }

    @PostMapping()
    public Persona insert(@RequestBody Persona p) {
        return personaRepository.save(p);
    }
  
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        personaRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Persona update(@PathVariable long id, @RequestBody Persona p) {
        Persona pUpdated = personaRepository.findById(id).get();

        pUpdated.setName(p.getName());
        pUpdated.setSurname(p.getSurname());
        pUpdated.setAge(p.getAge());

        return personaRepository.save(pUpdated);
    }

    /*
    @PutMapping("/{id}")
    public Persona update(@PathVariable long id, @RequestBody Persona p) {
        p.setId(id);
        return personaRepository.save(p);
    }
    */
}
