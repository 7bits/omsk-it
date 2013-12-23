# coding: utf-8
class Guest < ActiveRecord::Base
  self.table_name = 'guest'
  belongs_to :conference

  rails_admin do
    label "Гость"
    label_plural "Гости"
    object_label_method :second_name

    list do
      field :id
      field :first_name do
        label "Имя"
      end
      field :second_name do
        label "Фамилия"
      end
      field :email do
        label "E-mail"
      end
      field :job do
        label "Место работы"
      end
      field :job_position do
        label "Должность"
      end
      field :conference do
        label "Субботник"
      end
    end

    edit do
      field :first_name do
        label "Имя"
      end
      field :second_name do
        label "Фамилия"
      end
      field :email do
        label "E-mail"
      end
      field :job do
        label "Место работы"
      end
      field :job_position do
        label "Должность"
      end
      field :conference do
        label "Субботник"
      end
    end
  end
end
