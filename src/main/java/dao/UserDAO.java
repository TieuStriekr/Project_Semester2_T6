package dao;




import javax.swing.JOptionPane;


import database.ConnectDB;
import entity.User;


public class UserDAO {
	public int register(User user) {
		try(
			var con = ConnectDB.getCon();
			var cs = con.prepareCall("{call registerUser(?,?,?)}")
			)
		{	
			cs.setString(1, user.getUserName());
			cs.setString(2, user.getPassword());
			cs.setInt(3, user.getPhone());
			return cs.executeUpdate();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid Register",null, JOptionPane.ERROR_MESSAGE);
			return -1;
		}
	}
		public boolean login (User user){
			try(
					var con = ConnectDB.getCon();
					var cs = con.prepareCall("{call loginUser(?,?)}");
				) {
				
					cs.setString(1,user.getUserName());
					cs.setString(2, user.getPassword());
					var rs = cs.executeQuery();
					return rs.next();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid Login",null, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				return false;
			}	
		}
		public void forgetPass(User user) {
			try (
					var con = ConnectDB.getCon();
					var cs = con.prepareCall("{call forgetPass(?,?,?)}");
				){
				cs.setString(1, user.getPassword());
				cs.setString(2, user.getUserName());
				cs.setInt(3, user.getPhone());
				JOptionPane.showMessageDialog(null, cs.executeUpdate()>0?"Change password success":"nothing change");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid Change Password",null, JOptionPane.ERROR_MESSAGE);
			}
		}
		public boolean checkUser(String username, int phone) {
			try(
					var con = ConnectDB.getCon();
					var cs = con.prepareCall("{call checkExist(?,?)}");
				)
			{
				cs.setString(1, username);
				cs.setInt(2, phone);
				var rs = cs.executeQuery();
				return rs.next();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid Check User",null, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				return false;
			}
		}
}
