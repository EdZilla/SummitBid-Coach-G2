dataSource {
//    pooled = true
//    driverClassName = "org.h2.Driver"
//    username = "sa"
//    password = ""
	
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	  username = "ejy"
	  password = "gr00vy"
	  intialSize = 10
	  maxActive = 100
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            //url = "jdbc:h2:mem:/opt/data/db/coachg2/devDb"
			//url = "jdbc:h2:mem:/opt/data/db/coachg2/devDb"
			url = "jdbc:mysql://localhost:3306/coachg2?autoReconnect=true"
			
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
            dbCreate = "update"
			//dbCreate = "create-drop"
            //url = "jdbc:h2:/opt/data/db/coachg2/prodDb"
			url = "jdbc:mysql://localhost:3306/coachg2?autoReconnect=true"
        }
    }
}
