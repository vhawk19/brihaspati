(ns brihaspati.unit.questions-test
    (:require   [clojure.test :refer :all]
                [clojure.tools.logging :as log]
                [brihaspati.config :as config]
                [brihaspati.models.events :as event-models]
                [brihaspati.db.questions :refer [get-question-qid]]
                [brihaspati.models.questions :as models]))
(def not-nil? (complement nil?))

;----
;Sucess test for questions
;----

(def valid-question {:question "why did the chicken cross the road?"})
(def db-spec (config/test-db-spec))

(deftest create-question-test
    (testing "create a question in databse when valid data is passed"
        (let [[{:keys [id] :as result}] (models/create-question valid-question db-spec)]
            (is(= (get-question-qid id db-spec) 
                result)))))

;----
;Sucess test for get-questions-event
;----



(def valid-event {:id (rand-int 1000000) :state 1})
(def get-event-id (:id (first (event-models/create-event valid-event db-spec))))

(def valid-question {:question "why did the chicken cross the road?" :event_id get-event-id})

(deftest get-user-answers-event 
    (testing "tries fetching a user-answer of a prticualar event"
        (let [[{:keys [event_id] :as result}] (models/create-question valid-question db-spec)]
            (is (= (first (models/get-questions-event event_id db-spec))
                   result)))))
