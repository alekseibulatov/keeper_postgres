package com.bulatov.db;

import com.bulatov.entity.SpendEntity;

import java.util.List;

public interface SpendRepository {

    List<SpendEntity> getAll();
}
