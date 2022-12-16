package janggu_bug.janggu_bug.service;

import org.hibernate.procedure.ParameterMisuseException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import janggu_bug.janggu_bug.domain.JangGu;
import janggu_bug.janggu_bug.repository.JangGuRepository;

public class JangGuService {

    private JangGuRepository jangguRepository;

    public JangGuService(JangGuRepository jangGuRepository) {
        this.jangguRepository = jangGuRepository;
    }

    public JangGu findOnebyId(Long Id) {
        JangGu result = jangguRepository.findById(Id).orElseThrow(() ->new ParameterMisuseException("wrong shit given"));
        return result;
    }

    public Page<JangGu> pageLoad(PageRequest pageRequest) {
        return jangguRepository.findAll(pageRequest);
    }
}
