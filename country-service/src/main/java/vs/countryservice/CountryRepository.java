package vs.countryservice;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class CountryRepository {

    final JdbcTemplate jdbcTemplate;

    public CountryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Country> findAll() {
        return jdbcTemplate.query("select * from country", countryRowMapper);
    }

    private RowMapper<Country> countryRowMapper = (ResultSet rs, int rowNum) -> {
        var country = new Country();
        country.code = rs.getString("code");
        country.name = rs.getString("name");
        country.continent = rs.getString("continent");
        country.region = rs.getString("region");
        country.surfaceArea = rs.getBigDecimal("surface_area");
        country.independenceYear = rs.getShort("indep_year");
        country.population = rs.getInt("population");
        country.lifeExpectancy = rs.getBigDecimal("life_expectancy");
        country.gnp = rs.getBigDecimal("gnp");
        country.gnpOld = rs.getBigDecimal("gnp_old");
        country.localName = rs.getString("local_name");
        country.governmentForm = rs.getString("government_form");
        country.headOfState = rs.getString("head_of_state");
        country.capital = rs.getInt("capital");
        country.code2 = rs.getString("code_2");

        return country;
    };

    public Country findByCountryCode(String countryCode) {
        return jdbcTemplate.queryForObject("select * from country where code like ?", countryRowMapper, new Object[] { countryCode });
    }
}
