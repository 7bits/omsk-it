# coding: utf-8
class Reporter < ActiveRecord::Base
  self.table_name = 'reporter'
  belongs_to :company
  has_many :reports
  mount_uploader :photo, PhotoUploader

  after_initialize do
    if new_record?
      self.photo ||= 'nophoto.png'
    end
  end

  rails_admin do
    label "Докладчик"
    label_plural "Докладчики"
    object_label_method :second_name

    list do
      field :id
      field :first_name do
        label "Имя"
      end
      field :second_name do
        label "Фамилия"
      end
      field :photo do
        label "Фото"
      end
      field :email do
        label "E-mail"
      end
      field :company do
        label "Компания"
      end
      field :self_description
      field :job_position
      field :speech_experience
    end

    edit do
      field :first_name do
        label "Имя"
      end
      field :second_name do
        label "Фамилия"
      end
      field :photo do
        label "Фото"
      end
      field :email do
        label "E-mail"
      end
      field :company do
        label "Компания"
      end
      field :reports do
        label "Доклад"
      end
      field :self_description
      field :job_position
      field :speech_experience
    end
  end
end
