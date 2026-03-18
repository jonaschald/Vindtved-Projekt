package com.example.vindtved_projekt;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class DBC {

    private SQLServerDataSource kilde;
    private ExecutorService executor = Executors.newFixedThreadPool(10);

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
        try (Connection forbindelse = kilde.getConnection())
        {
            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean save() {
        AtomicBoolean ok = new AtomicBoolean(false);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                PreparedStatement sql;

                try (Connection forbindelse = kilde.getConnection()) {
                    // TODO
                    sql = forbindelse.prepareStatement("INSERT INTO");

                    sql.executeUpdate();
                    ok.set(true);
                } catch (SQLException ignored) {
                    ok.set(false);
                }
            }
        };

        Future<?> future = executor.submit(runnable);
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());

            return false;
        }

        return ok.get();
    }

    public boolean delete() {
        AtomicBoolean ok = new AtomicBoolean(false);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                PreparedStatement sql;

                try (Connection forbindelse = kilde.getConnection()) {
                    // TODO
                    sql = forbindelse.prepareStatement("DELETE FROM");

                    sql.executeUpdate();
                    ok.set(true);
                } catch (SQLException ignored) {
                    ok.set(false);
                }
            }
        };

        Future<?> future = executor.submit(runnable);
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());

            return false;
        }

        return ok.get();
    }

    public void update() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                PreparedStatement sql;

                try (Connection forbindelse = kilde.getConnection()) {
                    // TODO
                    sql = forbindelse.prepareStatement("UPDATE");

                    sql.executeQuery();
                } catch (SQLException ignored) {}
            }
        };

        Future<?> future = executor.submit(runnable);
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }
}