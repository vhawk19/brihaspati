(ns brihaspati.db.answers
    (:require   [clojure.java.jdbc :as jdbc]
                [honeysql.core :as sql]
                [honeysql.helpers :refer [select from where sset]]))

(defn create-answer [answer db-spec]
    (jdbc/insert! db-spec :answers answer))