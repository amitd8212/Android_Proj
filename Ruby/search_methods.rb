require 'capybara'
session = Capybara::Session.new(:selenium)
session.visit "http://www.google.com"

if session.has_content?("Feeling Lucky")
  puts "I'm feeling Lucky Today"
else
  puts "Could not find Lucky Button you may not be on google.com"
  exit(-1)
end
