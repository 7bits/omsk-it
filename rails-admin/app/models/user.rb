# coding: utf-8
class User < ActiveRecord::Base
  self.table_name = 'user'
  #has_many :role, through: :user_roles
  has_and_belongs_to_many :role, :join_table => :user_roles

  rails_admin do
    label "Пользователь"
    label_plural "Пользователи"
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
      field :password do
        label "Пароль"
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
      field :password do
        label "Пароль"
      end
    end
  end
end
