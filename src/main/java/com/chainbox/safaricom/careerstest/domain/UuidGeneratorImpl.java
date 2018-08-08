package com.chainbox.safaricom.careerstest.domain;

import java.util.UUID;

public class UuidGeneratorImpl implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
