class CreateSubscriptions < ActiveRecord::Migration
  def change
    create_table :subscription do |t|
      t.string :email
    end
  end
end
