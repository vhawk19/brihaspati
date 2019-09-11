(ns brihaspati.db.questions
    (:require   [clojure.java.jdbc :as jdbc]))

(defn create-question [question db-spec]
    (jdbc/insert! db-spec :questions question))