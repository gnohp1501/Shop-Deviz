package com.example.data.data

interface IDataSource {
    interface Local {
        fun getAll()
        fun getByID()
    }

    interface Remote {
        fun getAll()
        fun getByID()
    }
}