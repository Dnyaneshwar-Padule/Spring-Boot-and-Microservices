package com.tca.service;

import com.tca.entity.Passport;

import java.util.Optional;

public interface PassportService {

    Passport save(Passport passport);

    Optional<Passport> getById(String id);
}
