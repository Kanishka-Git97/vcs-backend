package com.vcs.backend.service;

import com.vcs.backend.model.Weight;
import com.vcs.backend.repository.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeightImpl implements WeightService{

    @Autowired
    private WeightRepository weightRepository;

    @Override
    public String save(Weight weight) {
        weightRepository.save(weight);
        return "True";
    }

    @Override
    public List<Weight> getAll(Integer pet) {
        return  weightRepository.getAll(pet);
    }
}
