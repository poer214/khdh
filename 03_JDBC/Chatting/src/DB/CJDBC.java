package DB;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class CJDBC {
   private Connection con;
   public CJDBC() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         InetAddress local = InetAddress.getLocalHost();
         String ip = local.getHostAddress();
         String url = "jdbc:oracle:thin:@"+ip+":1521:xe";
         String user = "increpas";
         String password = "increpas";
         con = DriverManager.getConnection(url, user, password);
      } catch(Exception e) {
         System.out.println("************ [DB 접속 오류] ************");
      }
   }
   
   public Statement getSTMT() {
      Statement stmt = null;
      try {
         stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      } catch(Exception e) {
         e.printStackTrace();
      }
      return stmt;
   }
   
   public PreparedStatement getPSTMT(String sql) {
      PreparedStatement pstmt = null;
      try {
         pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      } catch(Exception e) {
         e.printStackTrace();
      }
      return pstmt;
   }
   
   public void close(Object o) {
      try {
         if(o instanceof Connection) {
            ((Connection)o).close();
         } else if(o instanceof Statement) {
            ((Statement)o).close();
         } else if(o instanceof PreparedStatement) {
            ((PreparedStatement)o).close();
         } else if(o instanceof ResultSet) {
            ((ResultSet)o).close();
         }
      } catch(Exception e) {}
   }

   public Connection getCon() {
      return con;
   }

   
}