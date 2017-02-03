require_relative '../spec/spec_helper'


#This Page will hold all objects on the Account Page.

class AccountPage
	include PageObject

	def validate_accounts
		#Validates how many subscription icons are shown on the page and validates that against how many users we have created.
		#In the future we can add a data base read to get actual count vs what is shown on the page.
		browser.element(:css => ".Card").exists?
		accounts = browser.elements(:css => '.Table-cell--status.Table-cell.u-textNoWrap')
		return accounts	
	end





end