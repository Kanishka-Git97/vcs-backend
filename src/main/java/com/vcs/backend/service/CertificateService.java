package com.vcs.backend.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vcs.backend.model.Certificate;

import java.util.List;

public interface CertificateService {
   public String apply(Certificate certificate);
   public List<Certificate> all(Integer doctor);
}
