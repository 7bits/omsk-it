# coding: utf-8
class Role < ActiveRecord::Base
  self.table_name = 'role'
  #has_one :user_roles
  #has_one :user, through: :user_roles
  has_and_belongs_to_many :user, :join_table => :user_roles

  rails_admin do
    label "Роль"
    label_plural "Роли"
    object_label_method :role

    list do
      field :id
      field :role do
        label "Роль"
      end

    end

    edit do
      field :role do
        label "Роль"
      end
    end
  end
end
