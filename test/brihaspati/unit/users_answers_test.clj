(ns brihaspati.unit.users-answers-test
    (:require   [clojure.test :refer :all]
                [clojure.tools.logging :as log]
                [brihaspati.config :as config]
                [brihaspati.db.users-answers :refer [get-user-answer-uaid get-user-answer-eid]]
                [brihaspati.models.users-answers  :as models]
                [brihaspati.models.users :as user-models]
                [brihaspati.models.answers :as answer-models]
                [brihaspati.models.questions :as question-models]
                [brihaspati.models.events :as event-models]))
(def not-nil? (complement nil?))

;----
;Sucess test for create user-answers
;----
(def db-spec (config/test-db-spec))

(def valid-question {:question "why did the chicken cross the road?"})
(def get-question-id (:id (first (question-models/create-question valid-question db-spec))))

(def valid-user {:id (rand-int 1000000) :name "abc" :access 1})
(def get-user-id (:id (first (user-models/create-user valid-user db-spec))))

(def valid-answer {:is_correct true :option_no 4 :question_id get-question-id :answer "why did the chicken cross the road?"})
(def get-answer-id (:id (first (answer-models/create-answer valid-answer db-spec))))

(def valid-user-answer {:question_id get-question-id :answer_id get-answer-id :user_id get-user-id})

(deftest create-users-answers-test
    (testing "create a user-answer pair in databse when valid data is passed"
        (let [[{:keys [id] :as result}] (models/create-user-answer valid-user-answer db-spec)]
           (is(= (get-user-answer-uaid id db-spec) 
                result)))))

;----
;Sucess test for get-user-answers-event-id
;----



(def valid-event {:id (rand-int 1000000) :state 1})
(def get-event-id (:id (first (event-models/create-event valid-event db-spec))))

(def valid-user {:id (rand-int 1000000) :name "abc" :access 1})
(def get-user-id (:id (first (user-models/create-user valid-user db-spec))))

(def valid-question {:question "why did the chicken cross the road?" :event_id get-event-id})
(def get-question-id (:id (first (question-models/create-question valid-question db-spec))))

(def valid-answer {:is_correct true :option_no 4 :event_id get-event-id :question_id get-question-id :answer "why did the chicken cross the road?"})
(def get-answer-id (:id (first (answer-models/create-answer valid-answer db-spec))))

(def valid-user-answer {:question_id get-question-id :answer_id get-answer-id :event_id get-event-id :user_id get-user-id})


(deftest get-user-answers-event 
    (testing "tries fetching a user-answer of a prticualar event"
        (let [[{:keys [event_id] :as result}] (models/create-user-answer valid-user-answer db-spec)]
            (is (= (first (models/get-user-answer-event event_id db-spec))
                   result)))))
