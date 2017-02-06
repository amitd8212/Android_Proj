require_relative "../spec/spec_helper"
require_relative "../lib/apipage"
require 'active_support/all'
require "test/unit"



include Test::Unit::Assertions

class ApiTests < Test::Unit::TestCase 
	describe "API Testing" do

		before {
			@api_page = ApiPage.new(browser)
			@input_path = "C:\/Projects\/Ruby\/Recurly\/resources"
			@account_file = "#{@input_path}\/account_info.xml"			
			@subdomain = Recurly.subdomain  = 'amitd'
			@api_key = Recurly.api_key   = '1d0ca939e0074107a75b93051e4fc9c4'
			@base_url = "https://#{@subdomain}.recurly.com/v2"

			# To set a default currency for your API requests:
			@dc = Recurly.default_currency = 'USD'
		}


		it 'creates a new account and then validates creation' do
			#Read in xml file and add it to payload store the account code.
			#Get last account created and then validate against stored account code.
			@read_file = File.read(@account_file)
			@url = "#{@base_url}" + "/accounts"
			@headers = {Authorization: "Basic " + @api_key, content_type: 'application/xml; charset=utf-8', x_api_version: '2.4'}
			@payload = @read_file
			@account_creation = RestClient::Request.execute(method: :post, url: @url, user: @api_key, headers: @headers, timeout: 10, payload: @payload)
			@input_file = RestClient::Request.execute(method: :get, url: @url, user: @api_key, headers: @headers, timeout: 10)
			@expected_account_code = @api_page.create_account(@read_file)
			@created_account_code = @api_page.get_accounts(@input_file)
			@api_page.validate_accounts(@created_account_code, @expected_account_code)
		end

	end
end
