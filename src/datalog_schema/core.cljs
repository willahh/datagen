(ns datalog-schema.core
  (:require [reagent.core :as reagent :refer [atom]]))

(defonce app-state
  (atom
   {:text "Hello world!"
    :schema-type :schema-type/datomic
    :db/cardinality [:db.cardinality/one :db.cardinality/many]
    :db/doc :db/doc
    :db/ident :db/ident
    :db/isComponent [true false]
    :db/noHistory [true false]
    :db/unique [:db.unique/identity :db.unique/value]
    :db/valueType [:db.type/bigdec
                   :db.type/bigint
                   :db.type/boolean
                   :db.type/double
                   :db.type/float
                   :db.type/instant
                   :db.type/keyword
                   :db.type/long
                   :db.type/ref
                   :db.type/string
                   :db.type/uuid]
    :schema/fields [{:db/ident :user/name
                     :db/valueType :db.type/string
                     :db/unique :db.unique/identity
                     :db/cardinality :db.cardinality/one}]}))

(defn hello-world []
  [:div {:style {:fontSize "0.7em"}}
   [:link {:rel "stylesheet" :href "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
           :intgrity "sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
           :crossorigin "anonymous"}]
   [:script {:src "https://code.jquery.com/jquery-3.2.1.slim.min.js"
             :integrity "sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
             :crossorigin "anonymous"}]
   [:script {:src "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
             :integrity "sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
             :crossorigin "anonymous"}]
   [:script {:src "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
             :integrity "sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
             :crossorigin "anonymous"}]
   [:h3 "Create a schema"]
   [:div
    [:label
     [:input {:type "radio" :name :schema-type :value :schema-type/datomic :checked true}]
     "Datomic"]
    [:label
     [:input {:type "radio" :name :schema-type :value :schema-type/datascript}]
     "Datascript"]]
   [:table.table
    [:thead
     [:tr
      [:th :db/cardinality]
      [:th :db/ident]
      [:th :db/isComponent]
      [:th :db/noHistory]
      [:th :db/unique]
      [:th :db/valueType]
      [:th :db/doc]]]
    [:tbody
     [:tr
      [:td [:select {:name :db/cardinality}
            [:option {:value ""} "-"]
            [:option {:value :db.cardinality/one} :db.cardinality/one]
            [:option {:value :db.cardinality/many} :db.cardinality/many]]]
      [:td [:input {:name :db/ident}]] 
      [:td [:select {:name :db/isComponent}
            [:option {:value ""} "-"]
            [:option {:value true} "true"]
            [:option {:value false} "false"]]]
      [:td :db/noHistory]
      [:td :db/unique]
      [:td :db/valueType]
      [:td [:input {:name :db/doc} ]]]
     ]]
   [:p "Schema preview"]
   [:textarea]
   [:h3 "Define some rules"]
   [:p "Here we can define some logic rules"]
   [:h3 "Generate some helper methods"]
   [:p "Here we can define some common helper methods for the domain."]
   [:p "-----> Graph preview on side (graphiz)"]
   [:p "----> Repl"]
   [:p "----> clojure.spec gen"]
   [:table.table
    [:tbody
     [:tr
      [:td [:select {:name "a"}
            [:option {:value ""} "namespace"]]]
      [:td "find-by"
       "(find-by db :db/ident)"]]]]])


(defn start []
  (reagent/render-component [hello-world]
                            (. js/document (getElementById "app"))))

(defn ^:export init []
  (start))

(defn stop []
  (js/console.log "stop"))
