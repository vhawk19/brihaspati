(ns brihaspati.models.users-answers
    (:require   [brihaspati.db.users-answers :as user-answers]))

(defn create-user-answer [user-answer-details db-spec]
    (user-answers/create-user-answer user-answer-details db-spec))

(defn get-user-answer-event [event-id db-spec]
    (user-answers/get-user-answer-eid event-id db-spec))