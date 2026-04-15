package com.apitest.common;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {

    private static final String URL = "";
    private static final String USER = "test";
    private static final String PWD = "test123";

    public static String queryPolicyStatus(String policyNo) {
        try (Connection conn = DriverManager.getConnection(URL,USER,PWD)){
            String sql = "SELECT status FROM policy WHERE policy_no=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, policyNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getString("status");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

    public static List<String> qeuryPolicyList(String userId) {
        List<String> list = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL,USER,PWD)){
            String sql = "SELECT policy_no FROM policy WHERE userId=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(rs.getString("plicy_no"));
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static int updatePolicyStatus(String policyNo, String status){
        String sql = "UPDATE policy SET status = ? WHERE policy_no = ?";
        try (Connection conn = DriverManager.getConnection(URL,USER,PWD)){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,status);
            ps.setString(2,policyNo);
            return ps.executeUpdate();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
