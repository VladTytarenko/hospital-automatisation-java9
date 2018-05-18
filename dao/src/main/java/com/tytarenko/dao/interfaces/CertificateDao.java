package com.tytarenko.dao.interfaces;

import com.tytarenko.entities.Certificate;

import java.util.List;

public interface CertificateDao {

    List<Certificate> getCertificateOfDoctor(String passport);
    void addCertificate(Certificate certificate);

}
