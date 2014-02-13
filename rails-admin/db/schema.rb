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

ActiveRecord::Schema.define(version: 20140213104210) do

  create_table "admins", force: true do |t|
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

  add_index "admins", ["email"], name: "index_admins_on_email", unique: true, using: :btree
  add_index "admins", ["reset_password_token"], name: "index_admins_on_reset_password_token", unique: true, using: :btree

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
    t.integer "conference_id", limit: 8
    t.integer "user_id",       limit: 8
  end

  add_index "guest", ["conference_id"], name: "FK_mc7l13tehohwfbtw0bvr15ews", using: :btree
  add_index "guest", ["user_id"], name: "FK_chdaocwoknpkpjjcb6dyv8os8", using: :btree

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
    t.integer "user_id",           limit: 8
  end

  add_index "report", ["conference_id"], name: "FK_qnjt6x5yp8961pntheemo8rh", using: :btree
  add_index "report", ["user_id"], name: "FK_bewieeqpf679t5x8g8grd176f", using: :btree

  create_table "role", force: true do |t|
    t.string "role"
  end

  create_table "subscription", force: true do |t|
    t.string "email", null: false
  end

  create_table "suggestion", force: true do |t|
    t.string "favorite_theme"
    t.string "reporter_request"
    t.string "sender_specialization"
    t.string "theme_request"
  end

  create_table "user", force: true do |t|
    t.string  "confirmation_token"
    t.string  "email"
    t.boolean "enabled"
    t.string  "first_name"
    t.string  "job_position"
    t.string  "login"
    t.string  "password"
    t.string  "photo",                        default: "nophoto.png"
    t.string  "second_name"
    t.string  "self_description"
    t.integer "company_id",         limit: 8
  end

  add_index "user", ["company_id"], name: "FK_bteyn2vjkuydkfqefgaje2rhr", using: :btree

  create_table "user_roles", id: false, force: true do |t|
    t.integer "role_id", limit: 8, default: 0, null: false
    t.integer "user_id", limit: 8,             null: false
  end

  add_index "user_roles", ["role_id"], name: "FK_5q4rc4fh1on6567qk69uesvyf", using: :btree
  add_index "user_roles", ["user_id"], name: "FK_g1uebn6mqk9qiaw45vnacmyo2", using: :btree
  add_index "user_roles", ["user_id"], name: "UK_g1uebn6mqk9qiaw45vnacmyo2", unique: true, using: :btree

end
