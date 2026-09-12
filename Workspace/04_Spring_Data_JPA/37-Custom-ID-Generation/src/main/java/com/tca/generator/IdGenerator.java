package com.tca.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.util.Random;

public class IdGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        Random random = new Random();
        return "TCA"
                + random.nextInt(9)
                + random.nextInt(9)
                + random.nextInt(9)
                + random.nextInt(9);
    }
}
