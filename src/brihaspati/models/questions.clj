(ns brihaspati.models.questions
    (:require   [brihaspati.db.questions :as questions]
                [brihaspati.models.conversions :as convert]))



(defn create-questions [question-details db-spec]
    (questions/create-questions  question-details db-spec))

(defn get-questions-event [event-id db-spec]
    (questions/get-question-eid event-id db-spec))