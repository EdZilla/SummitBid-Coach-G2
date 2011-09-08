import org.apache.shiro.crypto.hash.Sha256Hash

class BootStrap {

def init = { servletContext -> 
		def user = new ShiroUser(username: "ed", passwordHash: new Sha256Hash("gr00vy").toHex()) 
		user.addToPermissions("*:*") 
		user.save() 
	}

def destroy = { 
	} 
}