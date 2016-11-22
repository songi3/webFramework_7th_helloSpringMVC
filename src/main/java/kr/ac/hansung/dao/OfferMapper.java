package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.model.Offer;

public class OfferMapper implements RowMapper<Offer> {

	public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// rs = 데이터베이스에서 읽어서 결과가 저장
		Offer offer = new Offer();

		offer.setId(rs.getInt("id"));// id 필드 읽어서 셋팅
		offer.setName(rs.getString("name"));// name 필드 읽어서 셋팅
		offer.setEmail(rs.getString("email"));// email 필드 읽어서 셋팅
		offer.setText(rs.getString("text"));// text 필드 읽어서 셋팅

		return offer;
	}

}
