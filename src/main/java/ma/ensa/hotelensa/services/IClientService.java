package ma.ensa.hotelensa.services;

import ma.ensa.hotelensa.beans.Client;

import java.util.List;

public interface IClientService {
    public Client saveClient(Client client);
    public List<Client> findAllClient();
    public Client findClientById(int id);
}
