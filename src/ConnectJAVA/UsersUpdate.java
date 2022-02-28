
package ConnectJAVA;

import User.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsersUpdate {
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        Connection connection = ConnectSQL.getConnection();
        
        String sql = "SELECT * FROM NguoiDung";
        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            
            while( rs.next()) {
                User user = new User();
                
                user.setId(rs.getInt("ID"));// tên cột
                user.setTen(rs.getString("ten"));
                user.setSdt(rs.getString("sdt"));
                user.setTenTK(rs.getString("tenTK"));
                user.setMatKhau(rs.getString("matKhau"));
                user.setGioiThieu(rs.getString("gioiThieu"));
                user.setVaiTro(rs.getString("vaiTro"));
                user.setSoThich(rs.getString("soThich"));
                
                users.add(user);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }
    public void addUser(User user)
    {
            Connection connection = ConnectSQL.getConnection();
            //lay id cuoi cung
            int idcanthem=0;
            try {
                Statement smlastid = connection.createStatement();
                String sqllastiid=  "select top 1 id \n" +
                                    "from NguoiDung\n" +
                                    "order by id desc ";
                ResultSet rslastid = smlastid.executeQuery(sqllastiid);
                rslastid.next();
                idcanthem=rslastid.getInt(1)+1;
            }
            catch(Exception e)
            {
                System.out.println("loi tai lay last id");
            }
            
            
            String sql = "INSERT INTO NguoiDung(ten, sdt, tenTK, matkhau, gioiThieu, vaiTro, soThich,id)"
                    + "values(?,?,?,?,?,?,?,?)";
            
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getTen());
                preparedStatement.setString(2, user.getSdt());
                preparedStatement.setString(3, user.getTenTK());
                preparedStatement.setString(4, user.getMatKhau());
                preparedStatement.setString(5, user.getGioiThieu());
                preparedStatement.setString(6, user.getVaiTro());
                preparedStatement.setString(7, user.getSoThich());
                preparedStatement.setInt(8, idcanthem);
                
//                int rs = preparedStatement.executeUpdate();
//                System.out.println(rs);
                preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteUser(int userid)
    {
            Connection connection = ConnectSQL.getConnection();
            
            String sql = "delete NguoiDung "
                    + "where ID=?";
            
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, userid);        
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
