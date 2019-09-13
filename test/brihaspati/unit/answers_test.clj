(ns brihaspati.unit.answers-test
    (:require   [clojure.test :refer :all]
                [clojure.tools.logging :as log]
                [brihaspati.config :as config]
                [brihaspati.db.answers :refer [get-answer-aid]]
                [brihaspati.models.answers  :as models]
                [brihaspati.models.questions :as question-models]))
(def not-nil? (complement nil?))

;----
;Sucess test for answers
;----
(def db-spec (config/test-db-spec))
(def valid-question {:question "why did the chicken cross the road?"})
(def get-question-id (:id (first (question-models/create-question valid-question db-spec))))
(def valid-answer {:is_correct true :option_no 4 :question_id get-question-id :answer "why did the chicken cross the road?"})


(deftest create-answers-test
    (testing "create a answer in databse when valid data is passed"
        (let [[{:keys [id] :as result}] (models/create-answer valid-answer db-spec)]
            (is(= (get-answer-aid id db-spec) 
                result)))))