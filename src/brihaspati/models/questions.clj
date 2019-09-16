(ns brihaspati.models.questions
    (:require   [brihaspati.db.questions :as questions]))

(defn create-question [question-details db-spec]
    (questions/create-question question-details db-spec))

(defn get-questions-event [event-id db-spec]
    (questions/get-question-eid event-id db-spec))