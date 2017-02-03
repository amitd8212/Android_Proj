require_relative '../spec/spec_helper'
 
#This Page will hold all site urls in a hash.

class UrlValues
	include PageObject

	def url_loc(username, pt)

		@@pages = Hash[ "HOME" => "https://app.recurly.com/login?",
					    "ACCOUNT" => "https://#{username}.recurly.com/accounts"
					  ]

		return @@pages[pt]

	end
	
end