(ns brihaspati.unit.questions-test
    (:require   [clojure.test :refer :all]
                [clojure.tools.logging :as log]
                [brihaspati.config :as config]
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