(ns brihaspati.db.questions
    (:require   [clojure.java.jdbc :as jdbc]
                [honeysql.core :as sql]
                [honeysql.helpers :refer [select from where sset]]))

(defn create-question [question db-spec]
    (jdbc/insert! db-spec :questions question))

(defn get-question-qid [qid db-spec]
    (first(jdbc/query db-spec (-> (select :*)
                                  (from :questions)
                                  (where [:= :id qid])
                                  sql/format))))