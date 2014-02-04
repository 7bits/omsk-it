# coding: utf-8
class Company < ActiveRecord::Base
  self.table_name = 'company'
  has_many :conference

  rails_admin do
    label "Компания"
    label_plural "Компании"
    object_label_method :name

    list do
      field :id
      field :name do
        label "Название"
      end
      field :site do
        label "Сайт"
      end
      field :location do
        label "Адрес"
      end
    end

    edit do
      field :name do
        label "Название"
      end
      field :site do
        label "Сайт"
      end
      field :location do
        label "Адрес"
      end
      field :conference do
        label "Субботники"
      end
    end


  end
end
