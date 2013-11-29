# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20131127115710) do

  create_table "company", force: true do |t|
    t.string "location"
    t.string "name"
    t.string "site"
  end

  create_table "conference", force: true do |t|
    t.integer "date",           limit: 8
    t.integer "ordinal_number", limit: 8
    t.boolean "registration"
    t.integer "company_id",     limit: 8
  end

  add_index "conference", ["company_id"], name: "FK_3ub4p96dtvd4f21e78ig9jeos", using: :btree

  create_table "guest", force: true do |t|
    t.string  "email"
    t.string  "first_name"
    t.string  "job"
    t.string  "job_position"
    t.string  "second_name"
    t.integer "conference_id", limit: 8
  end

  add_index "guest", ["conference_id"], name: "FK_mc7l13tehohwfbtw0bvr15ews", using: :btree

  create_table "rails_admin_histories", force: true do |t|
    t.text     "message"
    t.string   "username"
    t.integer  "item"
    t.string   "table"
    t.integer  "month",      limit: 2
    t.integer  "year",       limit: 8
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  add_index "rails_admin_histories", ["item", "table", "month", "year"], name: "index_rails_admin_histories", using: :btree

  create_table "report", force: true do |t|
    t.string  "description",       limit: 1000
    t.string  "key_technologies"
    t.string  "other_conferences"
    t.string  "presentation"
    t.string  "reporter_wishes"
    t.string  "title"
    t.string  "video"
    t.integer "conference_id",     limit: 8
    t.integer "reporter_id",       limit: 8
  end

  add_index "report", ["conference_id"], name: "FK_qnjt6x5yp8961pntheemo8rh", using: :btree
  add_index "report", ["reporter_id"], name: "FK_oxy74m7bhlikdpajhcxrcesco", using: :btree

  create_table "reporter", force: true do |t|
    t.string  "email"
    t.string  "first_name"
    t.string  "job_position"
    t.string  "photo"
    t.string  "second_name"
    t.string  "self_description"
    t.string  "speech_experience"
    t.integer "company_id",        limit: 8
  end

  add_index "reporter", ["company_id"], name: "FK_h0q7t84r4k4cmonm1rbg15jgm", using: :btree

  create_table "subscription", force: true do |t|
    t.string "email", null: false
  end

  create_table "suggestion", force: true do |t|
    t.binary "favorite_theme",        limit: 255
    t.string "reporter_request"
    t.binary "sender_specialization", limit: 255
    t.string "theme_request"
  end

  create_table "users", force: true do |t|
    t.string   "email",                  default: "", null: false
    t.string   "encrypted_password",     default: "", null: false
    t.string   "reset_password_token"
    t.datetime "reset_password_sent_at"
    t.datetime "remember_created_at"
    t.integer  "sign_in_count",          default: 0,  null: false
    t.datetime "current_sign_in_at"
    t.datetime "last_sign_in_at"
    t.string   "current_sign_in_ip"
    t.string   "last_sign_in_ip"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  add_index "users", ["email"], name: "index_users_on_email", unique: true, using: :btree
  add_index "users", ["reset_password_token"], name: "index_users_on_reset_password_token", unique: true, using: :btree

end
