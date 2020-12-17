package ma.ensa.hotelensa.services.impl;

import ma.ensa.hotelensa.beans.Client;
import ma.ensa.hotelensa.repo.ClientJpaRepo;
import ma.ensa.hotelensa.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return this.repo.findById(id).get();
    }
}
