# coding: utf-8
class Report < ActiveRecord::Base
  self.table_name = 'report'
  belongs_to :conference
  belongs_to :reporter

  rails_admin do
    label "Доклад"
    label_plural "Доклады"
    object_label_method :title

    list do
      field :id
      field :title do
        label "Название"
      end
      field :conference do
        label "конференция"
      end
      field :reporter do
        label "докладчик"
      end
    end

    edit do
      field :title do
        label "Название"
      end
      field :conference do
        label "конференция"
      end
      field :reporter do
        label "докладчик"
      end
      field :description, :text do
        label "описание"
      end
      field :presentation do
        label "презентация"
      end
      field :video do
        label "видео"
      end
      field :other_conferences
      field :key_technologies
      field :reporter_wishes
    end
  end
end
