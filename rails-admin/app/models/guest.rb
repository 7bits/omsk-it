# coding: utf-8
class Guest < ActiveRecord::Base
  self.table_name = 'guest'
  belongs_to :conference
  belongs_to :user

  rails_admin do
    label "Гость"
    label_plural "Гости"

    list do
      field :id
      field :conference do
        label "Субботник"
      end
      field :user do
        label "Пользователь"
      end
    end

    edit do
      field :conference do
        label "Субботник"
      end
      field :user do
        label "Пользователь"
      end
    end
  end
end
