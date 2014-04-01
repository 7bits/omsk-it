# coding: utf-8
class VkontakteProfile < ActiveRecord::Base
  self.table_name = 'vkontakteProfile'
  belongs_to :user

  rails_admin do
    label "Профиль вконтакте"
    label_plural "Профили вконтакте"
    object_label_method :vkontakte_id

    list do
      field :id
      field :user do
        label "Пользователь"
      end
      field :vkontakte_id do
        label "Профиль вконтакте"
      end
    end

    edit do
      field :user do
        label "Пользователь"
      end
      field :vkontakte_id do
        label "Профиль вконтакте"
      end
    end
  end
end
