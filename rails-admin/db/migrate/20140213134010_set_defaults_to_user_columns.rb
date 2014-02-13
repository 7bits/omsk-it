class SetDefaultsToUserColumns < ActiveRecord::Migration
  def change
    change_column :user, :photo, :string, default: nil
    change_column :user, :job_position, :string, default: nil
    change_column :user, :login, :string, default: nil
  end
end