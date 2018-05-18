package com.tytarenko.services;

import com.tytarenko.dao.interfaces.CertificateDao;
import com.tytarenko.entities.Certificate;
import com.tytarenko.services.interfaces.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateDao certificateDao;

    @Override
    public List<Certificate> getCertificateOfDoctor(String passport) {
        return certificateDao.getCertificateOfDoctor(passport);
    }

    @Override
    public void addCertificate(Certificate certificate) {
        certificateDao.addCertificate(certificate);
    }
}
