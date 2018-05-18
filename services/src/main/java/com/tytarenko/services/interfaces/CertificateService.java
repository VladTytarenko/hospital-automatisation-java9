package com.tytarenko.services.interfaces;

import com.tytarenko.entities.Certificate;

import java.util.List;

public interface CertificateService {

    List<Certificate> getCertificateOfDoctor(String passport);
    void addCertificate(Certificate certificate);

}
