class Conference < ActiveRecord::Base
  self.table_name = 'conference'
  belongs_to :company
  has_many :report
end
