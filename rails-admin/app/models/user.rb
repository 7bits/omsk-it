# coding: utf-8
class User < ActiveRecord::Base
  nilify_blanks
  self.table_name = 'user'
  #has_many :role, through: :user_roles
  has_and_belongs_to_many :role, :join_table => :user_roles
  has_many :guest
  has_many :report
  has_one :vkontakteProfile, :dependent => :destroy
  belongs_to :company
  mount_uploader :photo, PhotoUploader

  def title
    self.second_name.to_s + ' ' + self.first_name.to_s
  end

  rails_admin do
    label "Пользователь"
    label_plural "Пользователи"

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
      field :company do
        label "Компания"
      end
      field :job_position do
        label "Должность"
      end
      field :confirmation_token do
        label "Код подтверждения"
      end
      field :enabled do
        label "Доступность"
      end
      field :login do
        label "Логин"
      end
      field :role do
        label "Роли"
      end
      field :guest do
        label "Участник конференции"
      end
      field :report do
        label "Доклад"
      end
      field :vkontakteProfile do
        label "Профиль вконтакте"
      end
      field :photo do
        label "Фото"
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
      field :company do
        label "Компания"
      end
      field :job_position do
        label "Должность"
      end
      field :confirmation_token do
        label "Код подтверждения"
      end
      field :enabled do
        label "Доступность"
      end
      field :login do
        label "Логин"
      end
      field :role do
        label "Роли"
      end
      field :guest do
        label "Участник конференции"
      end
      field :report do
        label "Доклад"
      end

      field :photo do
        label "Фото"
      end
    end
  end
end
