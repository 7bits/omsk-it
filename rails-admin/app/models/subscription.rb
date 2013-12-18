# coding: utf-8
class Subscription < ActiveRecord::Base
  self.table_name = 'subscription'

  rails_admin do
    label "Подписчик"
    label_plural "Подписчики"
    object_label_method :email

    list do
      field :id
      field :email do
        label "E-mail"
      end
    end
  end
end

