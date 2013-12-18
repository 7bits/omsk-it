# coding: utf-8
class Conference < ActiveRecord::Base
  self.table_name = 'conference'
  belongs_to :company
  has_many :report

  rails_admin do
    label "Субботник"
    label_plural "СУбботники"

    list do
      field :id
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
