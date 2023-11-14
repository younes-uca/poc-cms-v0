package ma.sqli.peps.karate.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;


public class DbUtils {

    private static final Logger logger = LoggerFactory.getLogger(DbUtils.class);

    private final JdbcTemplate jdbc;

    public DbUtils(Map<String, Object> datasource) {
        String url = (String) datasource.get("url");
        String username = (String) datasource.get("username");
        String password = (String) datasource.get("password");
        String driver = (String) datasource.get("driverClassName");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        jdbc = new JdbcTemplate(dataSource);
        logger.info("init jdbc template: {}", url);
    }

    public Object readValue(String query) {
        return jdbc.queryForObject(query, Object.class);
    }

    public Map<String, Object> readRow(String query) {
        return jdbc.queryForMap(query);
    }

    public List<Map<String, Object>> readRows(String query) {
        return jdbc.queryForList(query);
    }
    public void cleanUp() {
        jdbc.update("DELETE FROM `peps-order`.order_line");
        jdbc.update("DELETE FROM `peps-order`.order_boutique");
    }

}

