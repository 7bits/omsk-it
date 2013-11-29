class Reporter < ActiveRecord::Base
  self.table_name = 'reporter'
  belongs_to :company
  has_many :reports
  mount_uploader :photo, PhotoUploader
  #attr_accessible :photo, :photo_cache, :remove_photo
end
