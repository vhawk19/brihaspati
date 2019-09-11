(ns brihaspati.models.questions
    (:require   [brihaspati.db.questions :as questions]))

(defn create-question [question-details db-spec]
    (questions/create-question question-details db-spec))