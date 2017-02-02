require 'spec_helper'

$home_page_url = "https://app.recurly.com/login?"

#This Page will hold all objects on the Home Page.

class HomePage
	include PageObject

	def go_to_account_page

		#Click on Account page link from side bar menu
		account_link = @browser.link(text: 'Accounts')
		account_link.click

	end

end
