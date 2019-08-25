package org.myproject.repository.dao.hibernateConfig;

import com.zaxxer.hikari.HikariDataSource;
import lombok.experimental.UtilityClass;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

@UtilityClass
//@NoArgsConstructor(access = AccessLevel.PRIVATE) //ERROR
// If any constructors are declared in @UtilityClass, an error is generated.
public class DataBaseUtil {

    private static final String URL_KEY = "postgresql.jdbcUrl";
    private static final String USER_KEY = "postgresql.username";
    private static final String PASSWORD_KEY = "postgresql.password";
        private static final String CLASS_DRIVER = "postgresql.driver";

    private static Properties properties = null;
    private static HikariDataSource hikariDataSource;

    static {
        try {
            properties = new Properties();
            //FileInputStream fileInputStream = new FileInputStream("application.properties")

            try (InputStream application = DataBaseUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
                properties.load(application);
                hikariDataSource = new HikariDataSource();
                hikariDataSource.setDriverClassName(properties.getProperty(CLASS_DRIVER));
                hikariDataSource.setJdbcUrl(properties.getProperty(URL_KEY));
                hikariDataSource.setUsername(properties.getProperty(USER_KEY));
                hikariDataSource.setPassword(properties.getProperty(PASSWORD_KEY));

                hikariDataSource.setMinimumIdle(100);
                hikariDataSource.setMaximumPoolSize(10000);
               // hikariDataSource.setAutoCommit(true);
                hikariDataSource.setLoginTimeout(3);

            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return hikariDataSource;
    }


}
