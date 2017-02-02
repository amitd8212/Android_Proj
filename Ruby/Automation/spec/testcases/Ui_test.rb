require_relative "../spec_helper"
require_relative "../../lib/loginpage"

describe "Account" do
  before {
  #@browser.goto("https://app.recurly.com/login?reason=logout")
  @login_page = LoginPage.new(@browser)

}


  it "logs in and then goes to the account page" do
    email_val = 'Jay8212@hotmail.com'
    password_val = "password123"
    @login_page.login(email_val, password_val)
  end

end
