require 'spec_helper'



class LoginPage
	include PageObject

		def login(email_val, password_val)
			email = @browser.text_field(id: 'user_email')
    	password = @browser.text_field(id: 'user_password')
    	submit = @browser.button(id: 'submit_button')
    	email.set email_val
    	password.set password_val
    	submit.click
		end
  	

 
end