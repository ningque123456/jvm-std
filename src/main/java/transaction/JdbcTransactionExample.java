package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @program: jvm-std
 * @description:
 * @author: ningque
 * @create: 2023-10-09 20:08
 **/
public class JdbcTransactionExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // 1. 创建数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            // 2. 开启事务
            conn.setAutoCommit(false);

            // 3. 执行数据库操作
            updateData(conn);
            insertData(conn);

            // 4. 提交事务
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            // 5. 回滚事务
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // 6. 关闭数据库连接
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void updateData(Connection conn) throws SQLException {
        String sql = "UPDATE table_name SET column_name = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "new value");
            stmt.setInt(2, 1);
            stmt.executeUpdate();
        }
    }

    private static void insertData(Connection conn) throws SQLException {
        String sql = "INSERT INTO table_name (column1, column2) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "value1");
            stmt.setString(2, "value2");
            stmt.executeUpdate();
        }
    }
}
