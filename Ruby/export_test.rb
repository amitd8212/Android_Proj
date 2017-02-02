require capybara
require_relative 'pages/storypage.rb'
class export_validation
	module export
		@data_set_1 = "test data set"

		begin
			@storypage.new
			user_login('test_user_1')
		end

		after do
			@storypage.delete_story
		end

		def export_story(viz_type, format)
			@storypage.create_story
			@storypage.add_data_set(@data_set_1)
			@storypage.save_as_default_view
			viz.visible?.must_equal true
			@storypage.select_viz(viz_type)
			@storypage.export_format(format)
			@storypage.validate_export
		end

		it "exports a timeline visualization in pdf format" do

			export_story("timeline", "pdf")

		end

		it "exports a bar chart visualization in pdf format" do
			
			export_story("bar", "pdf")

		end



	end
end