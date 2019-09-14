(ns brihaspati.unit.users-events-test
    (:require   [clojure.test :refer :all]
                [clojure.tools.logging :as log]
                [brihaspati.config :as config]
                [brihaspati.db.users-events :refer [get-user-event-ueid]]
                [brihaspati.models.users-events  :as models]
                [brihaspati.models.users :as user-models]
                [brihaspati.models.events :as event-models]
                [brihaspati.models.questions :as question-models]))
(def not-nil? (complement nil?))

;----
;Sucess test for answers
;----
(def db-spec (config/test-db-spec))


(def valid-user {:id (rand-int 1000000) :name "abc" :access 1})
(def get-user-id (:id (first (user-models/create-user valid-user db-spec))))

(def valid-event {:id (rand-int 100000) :state (rand-int 2)})
(def get-event-id (:id (event-models/create-event valid-event db-spec)))

(def valid-user-event {:user_id get-user-id :event_id get-event-id})

(deftest create-users-events-test
    (testing "create a events-users pair in databse when valid data is passed"
        (let [[{:keys [id] :as result}] (models/create-user-event valid-user-event db-spec)]
           (is(= (get-user-event-ueid id db-spec) 
                result)))))