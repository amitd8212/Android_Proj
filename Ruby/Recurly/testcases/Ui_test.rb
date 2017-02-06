require_relative "../spec/spec_helper"
require_relative "../lib/loginpage"
require_relative "../lib/homepage"
require_relative "../lib/accountpage"
require_relative "../lib/urls"
require "test/unit"

include Test::Unit::Assertions

=begin
UI Automation Task
Log in to Web App.
Navigate to the Account Summary page 
Confirm that the page gets displayed properly and 
confirm that the number of accounts that are being displayed is actually right.
=end

class UiTests < Test::Unit::TestCase 

  describe "Account" do
    before {
    @account_code = "12345"
    @user = "amitd"
    @email_val = "Jay8212@hotmail.com"
    @password_val = "password123" 
    @api_page = ApiPage.new(browser)
    @url = UrlValues.new(browser)
    @login_page = LoginPage.new(browser)
    @home_page = HomePage.new(browser)
    @account_page = AccountPage.new(browser)
    @browser.goto(@url.url_loc(@user, "HOME"))
    @login_page.login(@email_val, @password_val)
    @url = "#{@base_url}" + "/accounts"
    @headers = {Authorization: "Basic " + @api_key, content_type: 'application/xml; charset=utf-8', x_api_version: '2.4'}
    @subdomain = Recurly.subdomain  = 'amitd'
    @api_key = Recurly.api_key   = '1d0ca939e0074107a75b93051e4fc9c4'
    @base_url = "https://#{@subdomain}.recurly.com/v2"
    @input_file = RestClient::Request.execute(method: :get, url: @url, user: @api_key, headers: @headers, timeout: 10)
    @expected_account_count = @api_page.get_total_acounts(@input_file)
  }

  after {

  	@login_page.logout 

  }


    it "logs in and then goes to the account page using link on home page" do  
      @home_page.go_to_account_page
      assert (@browser.div :css => '.Pagination-left').exists?
      accounts = @account_page.validate_accounts
      assert accounts.size == @expected_account_count 
    end

    it "goes directly to the account page after logging in" do
      @browser.goto(@url.url_loc(@user, "ACCOUNT"))
      assert (@browser.div :css => '.Pagination-left').exists?
      accounts = @account_page.validate_accounts
      assert accounts.size == @expected_account_count
    end

    it 'validates last created account' do
      puts "Validating latest account created"
      @api_page.get_accounts(@account_code)
    end

  end
end
