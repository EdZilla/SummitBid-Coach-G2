package com.summitbid.coach



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Book)
class BookTests {

    void testConstraints() {

		def existingBook = new Book( title: "Misery", author: "Stephen King")

		mockForConstraintsTests(Book, [existingBook])

		// 	validation should fail if both properties are null 
		def book = new Book()

		assert !book.validate() 
		assert "nullable" == book.errors["title"] 
		assert "nullable" == book.errors["author"]

		// So let's demonstrate the unique and minSize constraints

		book = new Book(title: "Misery", author: "JK")
		assert !book.validate() 
		assert "unique" == book.errors["title"] 
		assert "minSize" == book.errors["author"]

		// 	Validation should pass! 
		book = new Book(title: "The Shining", author: "Stephen King") 
		assert book.validate() }
}
