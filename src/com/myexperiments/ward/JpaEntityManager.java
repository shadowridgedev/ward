package com.myexperiments.ward;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
/*
import lombok.experimental.Wither;
import no.obos.util.servicebuilder.JerseyConfig;
import no.obos.util.servicebuilder.ServiceConfig;
import no.obos.util.servicebuilder.model.Addon;
import no.obos.util.servicebuilder.util.GuavaHelper;
import org.h2.jdbcx.JdbcConnectionPool;
*/

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static com.google.common.base.Strings.isNullOrEmpty;

public class JpaEntityManager {
	private EntityManagerFactory emFactoryObj;
	private final String PERSISTENCE_UNIT_NAME = "JPATest";
	private final Map<String, String> properties = new HashMap<String, String>();

// This Method Is Used To Retrieve The 'EntityManager' Object
	public EntityManager getEntityManager() {
		return null;
		/*
		 * String url = String.format("%s/%s", DBConstants.DB_HOST,
		 * DBConstants.DB_NAME); properties.put("javax.persistence.jdbc.driver",
		 * DBConstants.DB_DRIVER); properties.put("javax.persistence.jdbc.url", url);
		 * properties.put("javax.persistence.jdbc.user", DBConstants.DB_USER);
		 * properties.put("javax.persistence.jdbc.password", DBConstants.DB_PASSWORD);
		 * properties.put("useSSL", DBConstants.DB_USE_SSL);
		 * properties.put("requireSSL", DBConstants.DB_REQUIRED_SSL);
		 * properties.put("serverTimezone", DBConstants.DB_SERVER_TIMEZONE);
		 * emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME,
		 * properties); return emFactoryObj.createEntityManager(); }
		 */
	}
}