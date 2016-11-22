package kr.ac.hansung.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Offer;


@Repository
public class OfferDAO {

	// 일반적인 코드
	private JdbcTemplate jdbcTemplateObject;

	// 외부에서 받아서 넣어줌 / Dependency Injection 이루어짐
	// Aonnotation 기능 켜기 위해서 beans.xml -> context ->insert <context :
	// annotation-config> eleement 클랙
	// <context:annotation-config></context:annotation-config>
	@Autowired // 해당타입에 맞는 bean이 주입
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from offers";
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
		// 실제 지정해준 sql 문을 실행시켜서 하나의 Object 를 넘겨줌
		// 넘겨주는 Object 타입이 Integer
	}

	// querying and returning a single object
	public Offer getOffer(String name) {// 이름에 해당되는 레코드 조회
		String sqlStatement = "select * from offers where name=?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { name }, new OfferMapper());
	}

	// querying and returning a multiple object
	public List<Offer> getOffers() {// 이름에 해당되는 레코드 조회
		String sqlStatement = "select * from offers";
		return jdbcTemplateObject.query(sqlStatement, new OfferMapper());
	}

	public boolean insert(Offer offer) {

		String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();

		String sqlStatement = "insert into offers (name, email, text) values (?,?,?)";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { name, email, text }) == 1);

	}

	public boolean update(Offer offer) {

		int id = offer.getId();
		String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();

		String sqlStatement = "update offers set name=?, email=?, text=? where id=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { name, email, text, id }) == 1);

	}

	public boolean delete(int id) {

		String sqlStatement = "delete from offers where id=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { id }) == 1);
	}

}
