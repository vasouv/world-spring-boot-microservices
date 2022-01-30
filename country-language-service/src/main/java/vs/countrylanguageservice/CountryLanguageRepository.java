package vs.countrylanguageservice;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class CountryLanguageRepository {

    final JdbcTemplate jdbcTemplate;

    public CountryLanguageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CountryLanguage> findAll() {
        return jdbcTemplate.query("select * from country_language", countryLanguageRowMapper);
    }

    public CountryLanguage findByCountryCodeAndLanguage(String countryCode, String language) {
        return jdbcTemplate.queryForObject("select * from country_language where country_code like ? and language like ?", countryLanguageRowMapper, new Object[]{countryCode, language});
    }

    private RowMapper<CountryLanguage> countryLanguageRowMapper = (ResultSet rs, int rowNum) -> {
        var countryLanguage = new CountryLanguage();
        countryLanguage.countryCode = rs.getString("country_code");
        countryLanguage.language = rs.getString("language");
        countryLanguage.isOfficial = rs.getString("is_official");
        countryLanguage.percentage = rs.getBigDecimal("percentage");

        return countryLanguage;
    };

}
