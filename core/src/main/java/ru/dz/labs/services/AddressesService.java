package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.model.Addresses;
import ru.dz.labs.repository.AddressRepository;


@Service
public class AddressesService {
    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public void addAddresses(Addresses addresses) {
        addressRepository.add(addresses);
    }

    @Transactional
    public Addresses getAddressByString(String address) {
        return addressRepository.getAddressByString(address);
    }
}
