package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.MemberInfo;

public class MemberInfoDAO extends DAO {
	
	//registerメソッド：データの登録を行う
	public int register(MemberInfo info) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"insert into member_info (last_name, first_name, gender, "
				+ "birth_year, birth_month, birth_day, "
				+ "phone_number, email_address, job) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		st.setString(1, info.getLastName());
		st.setString(2, info.getFirstName());
		st.setString(3, info.getGender());
		st.setString(4, info.getBirthYear());
		st.setString(5, info.getBirthMonth());
		st.setString(6, info.getBirthDay());
		st.setString(7, info.getPhoneNumber());
		st.setString(8, info.getEmailAddress());
		st.setString(9, info.getJob());
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		
		return line;
		
	}
	
	//追加
	//searchメソッド：データベースの検索を行う
		public MemberInfo id_search(String email_address) throws Exception {
			MemberInfo info = null;
			
			Connection con = getConnection();
			
			PreparedStatement st = con.prepareStatement(
					"select member_id from member_info where email_address = ?");
			st.setString(1, email_address);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				info = new MemberInfo();
				info.setMemberId(rs.getString("member_id"));
			}
			
			st.close();
			con.close();
			
			return info;
			
		}
	
	//searchメソッド：データベースの検索を行う
	public MemberInfo search(String member_id) throws Exception {
		MemberInfo info = null;
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from member_info where member_id = ?");
		st.setString(1, member_id);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			info = new MemberInfo();
			info.setMemberId(rs.getString("member_id"));
			info.setLastName(rs.getString("last_name"));
			info.setFirstName(rs.getString("first_name"));
			info.setGender(rs.getString("gender"));
			info.setBirthYear(rs.getString("birth_year"));
			info.setBirthMonth(rs.getString("birth_month"));
			info.setBirthDay(rs.getString("birth_day"));
			info.setPhoneNumber(rs.getString("phone_number"));
			info.setEmailAddress(rs.getString("email_address"));
			info.setJob(rs.getString("job"));
		}
		
		st.close();
		con.close();
		
		return info;
		
	}

	
	//editメソッド：データの更新を行う
	public int edit(MemberInfo info) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"update member_info set "
				+ "last_name = ?, first_name = ?, gender = ?, "
				+ "birth_year = ?, birth_month = ?, birth_day = ?, "
				+ "phone_number = ?, email_address = ?, job = ? "
				+ "where member_id = ?;");
		st.setString(1, info.getLastName());
		st.setString(2, info.getFirstName());
		st.setString(3, info.getGender());
		st.setString(4, info.getBirthYear());
		st.setString(5, info.getBirthMonth());
		st.setString(6, info.getBirthDay());
		st.setString(7, info.getPhoneNumber());
		st.setString(8, info.getEmailAddress());
		st.setString(9, info.getJob());
		st.setString(5, info.getMemberId());
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		
		return line;
	}
	
	//deleteメソッド：データの削除を行う
	public int delete(int member_id) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"delete from member_info where member_id = ?");
		st.setInt(1, member_id);
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		
		return line;
		
	}
	
}
