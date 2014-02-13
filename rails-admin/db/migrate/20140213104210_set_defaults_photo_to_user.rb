class SetDefaultsPhotoToUser < ActiveRecord::Migration
  def change
    change_column :user, :photo, :string, default: 'nophoto.png'
  end
end