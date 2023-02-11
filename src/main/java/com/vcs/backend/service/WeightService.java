package com.vcs.backend.service;

import com.vcs.backend.model.Weight;

import java.util.List;

public interface WeightService {
    public String save(Weight weight);
    public List<Weight> getAll(Integer pet);
}
