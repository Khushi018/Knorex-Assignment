package com.vastParser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/vastDB";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; 

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void saveVastTag(VastTag vastTag) throws Exception {
        String sql = "INSERT INTO vast_data (id, version, title, description, impression_id, impression_url, creative_json) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, vastTag.getId());
            stmt.setString(2, vastTag.getVersion());
            stmt.setString(3, vastTag.getTitle());
            stmt.setString(4, vastTag.getDescription());
            stmt.setString(5, vastTag.getImpression().getId());
            stmt.setString(6, vastTag.getImpression().getUrl());
            stmt.setString(7, new VastTagParser().convertToJson(vastTag));
            stmt.executeUpdate();
        }
    }

    public VastTag getVastTagById(String id) throws Exception {
        String sql = "SELECT creative_json FROM vast_data WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String json = rs.getString("creative_json");
                    return new VastTagParser().parseXmlToVastTag(json);
                }
            }
        }
        return null;
    }
}
