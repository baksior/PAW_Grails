package trello

import grails.plugin.springsecurity.SpringSecurityService
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

	private static final long serialVersionUID = 1

	SpringSecurityService springSecurityService

	String username
	String password
	static hasMany = [boards: Board]
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	User(String username, String password) {
		this()
		this.username = username
		this.password = password
	}

	Set<Role> getAuthorities() {
		(UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		password nullable: false, blank: false, password: true
		username nullable: false, blank: false, unique: true
	}

	static mapping = {
		password column: '`password`'
	}
}
