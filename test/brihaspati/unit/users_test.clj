(ns brihaspati.unit.users-test
    (:require   [clojure.test :refer :all]
                [clojure.tools.logging :as log]
                [brihaspati.config :as config]
                [brihaspati.db.users :refer [get-user-uid]]
                [brihaspati.models.users :as models]))
(def not-nil? (complement nil?))

;---
;Sucess test for users
;---

(def valid-user {:id (rand-int 1000000) :name "abc" :access 1})
(def db-spec (config/db-spec))

(deftest create-user-test
    (testing "creates a user in the database when valid data is passed"
        (let [[{:keys [id] :as result}] (models/create-user valid-user db-spec)]
            (is (= (get-user-uid id db-spec)
                result)))))