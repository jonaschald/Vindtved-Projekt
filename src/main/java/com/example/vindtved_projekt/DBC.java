package com.example.vindtved_projekt;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DBC {

    private SQLServerDataSource kilde;

    public DBC() {
        kilde = new SQLServerDataSource();
        kilde.setDatabaseName("EJM_2025_Vindmølle_DB");
        kilde.setUser("CS2025a_s_2");
        kilde.setPassword("CS2025aS2#23");
        kilde.setPortNumber(1433);
        kilde.setServerName("10.176.111.34");
        kilde.setTrustServerCertificate(true);
    }

    public void insertDataIntoDB()
    {

    }

}