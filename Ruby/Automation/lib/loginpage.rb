require 'spec_helper'

#This Page will hold all objects on the Login Page.

class LoginPage
	include PageObject

		def login(email_value, password_value)
			#Login method
			email = browser.text_field(id: 'user_email')
    	password = browser.text_field(id: 'user_password')
    	submit = browser.button(id: 'submit_button')
    	email.set email_value
    	password.set password_value
    	submit.click
		end

		def logout
			#Logout method
			logout = browser.link(text: 'Log Out')
			logout.click
		end
 

 
end