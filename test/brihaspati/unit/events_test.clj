(ns brihaspati.unit.events-test
    (:require   [clojure.test :refer :all]
                [clojure.tools.logging :as log]
                [brihaspati.config :as config]
                [brihaspati.db.events :refer [get-event-eid]]
                [brihaspati.models.events :as models]))
(def not-nil? (complement nil?))

;----
;Sucess test for events
;----

(def valid-event {:id (rand-int 100000) :state (rand-int 2)})
(def db-spec (config/test-db-spec))

(deftest create-event-test
    (testing "create a event in databse when valid data is passed"
        (let [[{:keys [id] :as result}] (models/create-event valid-event db-spec)]
            (is(= (get-event-eid id db-spec) 
                result)))))