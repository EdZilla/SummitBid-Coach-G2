dataSource {
//    pooled = true
//    driverClassName = "org.h2.Driver"
//    username = "sa"
//    password = ""
	
	pooled = true
	driverClassName = 'org.h2.Driver'
	
}
hibernate {
  cache.use_second_level_cache = true
	cache.use_query_cache = false
	cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
	format_sql = true
	use_sql_comments = true
}
// environment specific settings
environments {
    development {
        dataSource {
			pooled = false			
			driverClassName = "com.mysql.jdbc.Driver"			
			dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            //url = "jdbc:h2:mem:/opt/data/db/coachg2/devDb"
			//url = "jdbc:h2:mem:/opt/data/db/coachg2/devDb"
			
			//url = "jdbc:mysql://localhost:3306/coach?autoReconnect=true"
			//jndiName = 'java:comp/env/jdbc/coachDBDataSource'						
			jndiName = 'java:comp/env/jdbc/coach'
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb"
        }
    }
    production {
        dataSource {
            //dbCreate = "update"
			pooled = false
			driverClassName = "com.mysql.jdbc.Driver"
			dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'			
			dbCreate = "create-drop"
			//jndiName = 'java:comp/env/jdbc/coachDBDataSource'
			jndiName = 'java:comp/env/jdbc/coach'
        }
    }
}
