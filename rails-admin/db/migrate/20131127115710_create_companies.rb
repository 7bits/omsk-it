class CreateCompanies < ActiveRecord::Migration
  def down
    create_table :company do |t|
      t.string :name
      t.string :site
      t.string :location
    end
  end
end
