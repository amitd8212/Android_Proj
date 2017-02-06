require_relative '../spec/spec_helper'
require 'rest-client'
require 'recurly'
require 'base64'
require 'test/unit'
require 'json'
require 'xmlsimple'
require 'nokogiri'


#This Page will hold all objects on the Home Page.

class ApiPage
	include PageObject

	def create_account(account_file)
		#Return account code from last created account.	
		@xml_doc_1 = Nokogiri::HTML(account_file)	
		return @xml_doc_1.css('//account_code').first.text
	end

	def get_total_acounts(input_file)
		@xml_doc = Nokogiri::HTML(input_file)
		@doc = @xml_doc.css('//account_code')
		return @doc.count
	end



	def get_accounts(input_file)
		#Return account code from xml file.
		@xml_doc = Nokogiri::HTML(input_file)
		return @xml_doc.css('//account_code').first.text
	end

	def validate_accounts(created_account_code, expected_account_code)
		assert created_account_code == expected_account_code
		if created_account_code == expected_account_code
			puts "\nAccount created correctly"
		else
			puts "\nAccount was not created correctly"
		end
	end

end