require 'spec_helper'


#This Page will hold all objects on the Account Page.

class AccountPage
	include PageObject

	def validate_accounts(expected_account_count)

		browser.element(:css => ".Card").exists?
		accounts = browser.elements(:css => '.Table-cell--status.Table-cell.u-textNoWrap')
		puts accounts.length
		puts expected_account_count

		if accounts.size == expected_account_count
			puts "Account validation complete"
		else
			puts "Check validation again expected count did not match number of accounts on the page"
		end

	end





end