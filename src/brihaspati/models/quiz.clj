(ns brihaspati.models.quiz
    (:require   [brihaspati.db.answers :as answers]
                [brihaspati.db.questions :as questions]
                [brihaspati.db.quiz :as quiz]
                [brihaspati.models.conversions :as convert]))


(defn get-quiz-event [db-spec eid]
    (quiz/get-quiz-eid eid db-spec))