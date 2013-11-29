class Guest < ActiveRecord::Base
  self.table_name = 'guest'
  belongs_to :conference
end
