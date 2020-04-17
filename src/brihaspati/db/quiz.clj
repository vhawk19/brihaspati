(ns brihaspati.db.quiz
    (:require [clojure.java.jdbc :as jdbc]
              [honeysql.core :as sql]
              [honeysql.helpers :refer [select from where join]]))

(defn get-quiz-eid [eid db-spec]
    (jdbc/query db-spec (-> (select :questions.question_text :questions.id :answers.id :answers.answer)
                            (from :questions )
                            (join :answers [:= :answers.question_id :questions.id])
                            (where [:= :questions.event_id eid])
                            sql/format)))
                            