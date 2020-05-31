package com.wypok.dao;

import com.wypok.models.Discovery;

import java.util.List;

public interface DiscoveryDAO extends GenericDAO<Discovery, Long>{

    List<Discovery> getAll();

}
