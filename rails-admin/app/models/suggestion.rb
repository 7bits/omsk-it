# coding: utf-8
class Suggestion < ActiveRecord::Base
  self.table_name = 'suggestion'

  rails_admin do
    label "Предложение"
    label_plural "Предложения"
    object_label_method :title

    list do
      field :id
      field :sender_specialization do
        label "Специализация"
      end
      field :favorite_theme do
        label "Любимая тема"
      end
      field :theme_request do
        label "желаемая тема"
      end
      field :reporter_request do
        label "желаемый докладчик"
      end
    end

    edit do
      field :sender_specialization do
        label "Специализация"
      end
      field :favorite_theme do
        label "Любимая тема"
      end
      field :theme_request do
        label "Желаемая тема"
      end
      field :reporter_request do
        label "Желаемый докладчик"
      end
    end
  end
end
