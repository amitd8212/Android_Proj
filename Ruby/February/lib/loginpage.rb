require 'spec_helper'



class LoginPage
	include PageObject

		def login(email_value, password_value)
			email = @browser.text_field(id: 'user_email')
    	password = @browser.text_field(id: 'user_password')
    	submit = @browser.button(id: 'submit_button')
    	email.set email_value
    	password.set password_value
    	submit.click
		end

		def logout

		end
  	

 
end