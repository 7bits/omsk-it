class Company < ActiveRecord::Base
  self.table_name = 'company'
  has_many :conference
  has_many :reporter
end
