# coding: utf-8
require 'date'
class Conference < ActiveRecord::Base
  nilify_blanks
  self.table_name = 'conference'
  belongs_to :company
  has_many :report
  has_many :guest

  def title
    'Субботник №' + self.ordinal_number.to_s
  end


  rails_admin do
    label "Субботник"
    label_plural "Субботники"

    list do
      field :id
      field :ordinal_number do
        label "Номер"
      end
      field :company do
        label "Место проведения"
      end
      field :date, :timestamp do
        label "Дата проведения"
        formatted_value do # used in form views
          Time.at(value).to_datetime
        end
      end
      field :registration do
        label "Регистрация"
      end
      field :report do
        label "Доклады"
      end
      field :guest do
        label "Гость"
      end
    end

    edit do
      field :ordinal_number do
        label "Номер"
      end
      field :company do
        label "Место проведения"
      end
      field :date do
        label "Дата проведения"
      end
      field :registration do
        label "Регистрация"
      end
      field :report do
        label "Доклады"
      end
    end
  end
end
