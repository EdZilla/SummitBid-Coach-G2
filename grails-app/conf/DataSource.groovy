dataSource {
//    pooled = true
//    driverClassName = "org.h2.Driver"
//    username = "sa"
//    password = ""
	
	
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
			jndiName = 'java:comp/env/jdbc/coachDBDataSource'
			pooled = false			
			driverClassName = "com.mysql.jdbc.Driver"			
			dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            //url = "jdbc:h2:mem:/opt/data/db/coachg2/devDb"
			//url = "jdbc:h2:mem:/opt/data/db/coachg2/devDb"
			
			//url = "jdbc:mysql://localhost:3306/coach?autoReconnect=true"
			//jndiName = 'java:comp/env/jdbc/coachDBDataSource'						
			
        }
    }
    test {
        dataSource {
			
			pooled = false; //it is recommended not to use connection pool unless file encryption is enabled
			username = "coach"
			password = "coach"
			dbCreate = "create-drop"
			
			driverClassName = "com.mysql.jdbc.Driver"
			dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'            

//			jndiName = 'java:comp/env/jdbc/coachDBDataSource'
			url = "jdbc:mysql://localhost:3306/coach?autoReconnect=true"
			
//			

		    //driverClassName = "org.h2.Driver"
			//username = "sa"
			//password = ""
			//url = "jdbc:h2:mem:testDb"
        }
    }
    production {
        dataSource {
            //dbCreate = "update"
			pooled = false
			dbCreate = "update"			
			driverClassName = "com.mysql.jdbc.Driver"
			dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'
			jndiName = 'java:comp/env/jdbc/coachDBDataSource'
			
			//jndiName = 'java:comp/env/jdbc/coachDBDataSource'
			//jndiName = 'java:comp/env/jdbc/coachDBDataSource'
        }
    }
}
