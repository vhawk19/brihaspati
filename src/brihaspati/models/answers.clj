(ns brihaspati.models.answers
    (:require   [brihaspati.db.answers :as answers]))

(defn create-answer [answer-details db-spec]
    (answers/create-answer answer-details db-spec))