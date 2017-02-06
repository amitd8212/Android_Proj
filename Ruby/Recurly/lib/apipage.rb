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
		@cac = File.open(account_file) {|f| Nokogiri::XML(f) }
		@new_acount_code = @cac.css('//account_code').last.text
		@cac.close
		return @new_account_code
	end


	def get_accounts(input, xml_doc)
		@account_code_value = xml_doc.css('//account_code').last.text
		puts xml_doc.css('//account').last
		return @account_code_value
	end

end