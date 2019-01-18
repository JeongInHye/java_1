package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class test 
{
	public void main(String[] args) 
	{
		String url ="jdbc:mysql://192.168.3.133:3306/test";
		String user="root";
		String password ="1234";
		
		try 
		{
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			
			Statement cmd = conn.createStatement();	// open
			ResultSet rs = cmd.executeQuery("SELECT * FROM Member");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			ArrayList list = new ArrayList();
			
			while(rs.next())
			{
				HashMap<String, Object> map = new HashMap<String,Object>();
				
//				int mNo = rs.getInt("mNo");
//				String mId = rs.getString("mId");
//				String mName = rs.getString("mName");
				
//				System.out.println(mNo + mId + mName);
				for (int i = 1; i <= rsmd.getColumnCount(); i++) 
				{
//					System.out.print(rsmd.getColumnName(i) + " , " + rs.getObject(i)+ "\t");
					map.put(rsmd.getColumnName(i), rs.getObject(i));
				}
				list.add(map);
//				System.out.println();
			}
			
			for (int i = 0; i < list.size(); i++) 
			{
				HashMap<String, Object> map = (HashMap<String, Object>)list.get(i);
				Set set = map.keySet();
				Iterator it = set.iterator();
				
				while(it.hasNext())
				{
					String key = it.next().toString();
					map.get(key);
					System.out.print(key + " , " + map.get(key) + "\t");
				}
				System.out.println();
			}
			
			System.out.println("DB접속 성공");
		}
		catch (Exception e)
		{
			System.out.println("DB접속 실패 ");
			e.printStackTrace();
		}
	}
}
