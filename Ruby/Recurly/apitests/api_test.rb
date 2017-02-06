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
			@input = RestClient::Request.execute(method: :get, url: "#{@base_url}" + "/accounts", 
						 						 user: @api_key, Authorization: "Basic " + @api_key ,timeout: 10)
			@xml_doc = Nokogiri::HTML(@input)

			# To set a default currency for your API requests:
			@dc = Recurly.default_currency = 'USD'
		}


		it 'creates a new account and then validates creation' do
			#read in xml file and add it to payload.  Then validate the account codes.
			@read_file = File.read(@account_file)
			@url = "#{@base_url}" + "/accounts"
			@headers = {Authorization: "Basic " + @api_key, content_type: 'application/xml; charset=utf-8', x_api_version: '2.4'}
			@payload = @read_file
			@account_creation = RestClient::Request.execute(method: :post, url: @url, user: @api_key, headers: @headers, timeout: 10, payload: @payload)
			@account_code = @api_page.create_account(@account_creation)
			@created_account_code = @api_page.get_accounts(@input, @xml_doc)			
			assert @created_account_code == @account_code
		end

	end
end
