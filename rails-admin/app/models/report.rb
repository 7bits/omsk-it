class Report < ActiveRecord::Base
  self.table_name = 'report'
  belongs_to :conference
  belongs_to :reporter
end
