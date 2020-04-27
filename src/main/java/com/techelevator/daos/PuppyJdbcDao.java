package com.techelevator.daos;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.exceptions.PuppyNotFoundException;
import com.techelevator.models.Puppy;

/**
 * PuppyJdbcDao
 */
@Component
public class PuppyJdbcDao implements PuppyDao {

	private JdbcTemplate template;
	private Logger logger = Logger.getLogger(this.getClass());

	public PuppyJdbcDao(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return template;
	}

	@Override
	public List<Puppy> getPuppies() {
		return template.query("SELECT * FROM puppies;", new BeanPropertyRowMapper<Puppy>(Puppy.class));
	}

	@Override
	public Puppy getPuppy(int id) throws PuppyNotFoundException {
		try {
			return template.queryForObject("SELECT * FROM puppies WHERE id=?;", new Object[] { id },
					new BeanPropertyRowMapper<Puppy>(Puppy.class));
		} catch (EmptyResultDataAccessException e) {
			String message = "Error getting puppy by id: " + id;
			logger.error(message);
			throw new PuppyNotFoundException(message);
		}
	}

	@Override
	public void savePuppy(Puppy puppyToSave) {
		template.update("INSERT INTO puppies (name, weight, gender, paper_trained) VALUES (?, ?, ?, ?)",
				new Object[] { puppyToSave.getName(), puppyToSave.getWeight(), puppyToSave.getGender(),
						puppyToSave.isPaperTrained() });
	}
}