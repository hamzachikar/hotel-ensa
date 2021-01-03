package ma.ensa.hotelensa.services.impl;

import ma.ensa.hotelensa.beans.Client;
import ma.ensa.hotelensa.repo.ClientJpaRepo;
import ma.ensa.hotelensa.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceController implements IClientService {
    @Autowired
    private ClientJpaRepo repo;
    @Override
    public Client saveClient(Client client) {
        return this.repo.save(client);
    }

    @Override
    public List<Client> findAllClient() {
        return this.repo.findAll();
    }

    @Override
    public Client findClientById(int id) {
        Optional<Client> client=this.repo.findById(id);
        if(client.isPresent()){
            return client.get();
        }
        return null;
    }
}
