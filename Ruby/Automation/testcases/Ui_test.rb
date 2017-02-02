require_relative "../spec/spec_helper"
require_relative "../lib/loginpage"
require_relative "../lib/homepage"
require_relative "../lib/accountpage"
require_relative "../lib/urls"

=begin
UI Automation Task
Log in to Web App.
Navigate to the Account Summary page 
Confirm that the page gets displayed properly and 
confirm that the number of accounts that are being displayed is actually right.
=end


describe "Account" do
  before {
  @user = "amitd"
  @email_val = "Jay8212@hotmail.com"
  @password_val = "password123"
  @url = UrlValues.new(browser)
  @login_page = LoginPage.new(browser)
  @home_page = HomePage.new(browser)
  @account_page = AccountPage.new(browser)
  @browser.goto(@url.url_loc(@user, "HOME"))
  @login_page.login(@email_val, @password_val)
}

after {

	@login_page.logout 

}


  it "logs in and then goes to the account page using link on home page" do  
    @home_page.go_to_account_page
    if (@browser.div :css => '.Pagination-left').exists?
    	puts "\nAccount Page loaded when clicking on accounts link from home page"
    else
    	puts "\nAccounts Page not loaded correctly when clicking on accounts link from home page"
    end
    @account_page.validate_accounts(2)  
  end

  it "goes directly to the account page after logging in" do
    @browser.goto(@url.url_loc(@user, "ACCOUNT"))
    if (@browser.div :css => '.Pagination-left').exists?
    	puts "\nAccount Page loaded when going directly through url"
    else
    	puts "\nAccounts Page not loaded correctly when going directly through url"
    end
    @account_page.validate_accounts(2)
  end

end
