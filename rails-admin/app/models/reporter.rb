class Reporter < ActiveRecord::Base
  self.table_name = 'reporter'
  belongs_to :company
  has_many :reports
  mount_uploader :photo, PhotoUploader
  #attr_accessible :photo, :photo_cache, :remove_photo

  rails_admin do
    list do
      field :id
      field :first_name
      field :second_name
      field :photo
      field :email
      field :company
      field :self_description
      field :job_position
      field :speech_experience
    end
    edit do
      field :id
      field :first_name
      field :second_name
      field :photo
      field :email
      field :company
      field :reports
      field :self_description
      field :job_position
      field :speech_experience
    end
  end

  before_save :default_value
  def default_value
    self.photo ||= "nophoto.png"
  end
end
