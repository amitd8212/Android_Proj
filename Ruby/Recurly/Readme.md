#Instructions on how to run Automation:
  1. Pull code to local repo.
  2. Run the following command from the \Projects\Ruby\Recurly directory
  3. __rspec "***/**_test.rb"__
  4. A run will finish looking like what is below:
 
  __Account created correctly__

 __Finished in 30.13 seconds (files took 6.23 seconds to load)__
 __2 examples, 0 failures__

#Automation Layout:
  1. UI test located in testcases directory.
  2. Spec_helper located in spec directory.
  3. Apit test located in apitests directory.
  4. Page objects located in pages directory.
  5. XML input for api test located in resources directory.
  
#NOTES:
  1. To run the API Tests and avoid failures make sure to update the account_code, account_code portion of the account node, and the vat_number.  Those values need to be updated for each run.
     
     A. "\<account href="https://amitd.recurly.com/v2/accounts/333111"> could be changed to "\<account    href="https://amitd.recurly.com/v2/accounts/333112"> for a second run."
     
     B. "\<account_code>333111"\</account_code> should then also be changed to "\<account_code>333112"\</account_code> for a second run.
     
     C. "\<vat_number>1223343567487"\</vat_number> can be changed to any other value for a second run, such as                "\<vat_number>12343421487"\</vat_number>
