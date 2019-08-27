package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {

	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private BuyItemDTO buyItemDTO=new BuyItemDTO();

	public BuyItemDTO getBuyItemInfo(){

			String sql="SELECT id,item_name,item_price FROM item_info_transaction";
//			selectでSQLから結果を取得
			try{
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				ResultSet resultSet=preparedStatement.executeQuery();
				/*	表からデータを取得する場合は、Statement.executeQuery メソッドを使用できる。
				 *	結果表をResultSet オブジェクトとして返す。
				 *  結果表を取得したら、ResultSet メソッドを使用して結果表の中を移動し、
				 *  各行の個々の列値を取得する必要がある。*/

				if(resultSet.next()){
						buyItemDTO.setId(resultSet.getInt("id"));
						buyItemDTO.setItemName(resultSet.getString("item_name"));
						buyItemDTO.setItemPrice(resultSet.getString("item_price"));
				}//DBから取得した情報をDTOに格納
			}catch(Exception e){
					e.printStackTrace();
			}
			return buyItemDTO;
			//ActionにDTOを返す
	}

}
