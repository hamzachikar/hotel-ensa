package ma.ensa.hotelensa.rest;

import ma.ensa.hotelensa.beans.Client;
import ma.ensa.hotelensa.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientRestController {
    @Autowired
    private IClientService clientService;

    @PostMapping("/")
    public ResponseEntity<Client> saveClient(@RequestBody Client c){
        return ResponseEntity.ok(this.clientService.saveClient(c));
    }
    @GetMapping("/")
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.ok(this.clientService.findAllClient());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> findClientById(@PathVariable int id){
        Client client=this.clientService.findClientById(id);
        if(client==null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(client);
    }
}
