package com.example.data.repository

import com.example.data.data.local.DataSourceLocal
import com.example.domain.repository.IDataSourceRepository

class DataSourceRepository(
    private val localDataSourceLocal: DataSourceLocal
) : IDataSourceRepository {

    override fun getAll() {
        localDataSourceLocal.getAll()
    }

    override fun getByID() {
        localDataSourceLocal.getByID()
    }
}