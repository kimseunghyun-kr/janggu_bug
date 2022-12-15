package janggu_bug.janggu_bug.service;

import janggu_bug.janggu_bug.repository.JangGuRepository;

public class JangGuService {

    private JangGuRepository jangguRepository;

    public JangGuService(JangGuRepository jangGuRepository) {
        this.jangguRepository = jangGuRepository;
    }
}
