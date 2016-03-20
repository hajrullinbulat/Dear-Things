package ru.dz.labs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.labs.model.Telephones;
import ru.dz.labs.repository.TelephonesRepository;


@Service
public class TelephoneService {
    @Autowired
    private TelephonesRepository telephonesRepository;

    @Transactional
    public void addTelephone(Telephones telephones) {
        telephonesRepository.add(telephones);
    }

}
