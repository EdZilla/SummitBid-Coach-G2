package coach

import org.bson.types.ObjectId

class AuditEntry {

	static mapWith = "mongo"
	
	ObjectId id
	String message
	String userId
	
    static constraints = {
		message blank: false
		userId blank: false
    }
	
	static mapping = {
		collection "logs"
		database "audit"
		userId index:true
		version false
	}
}
