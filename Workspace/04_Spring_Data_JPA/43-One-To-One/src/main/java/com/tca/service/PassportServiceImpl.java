package com.tca.service;

import com.tca.entity.Passport;
import com.tca.repository.PassportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("passportService")
public class PassportServiceImpl implements  PassportService{

    private final PassportRepository passportRepository;

    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public Passport save(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public Optional<Passport> getById(String id) {
        return passportRepository.findById(id);
    }
}
