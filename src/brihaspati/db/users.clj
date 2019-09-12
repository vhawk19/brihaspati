(ns brihaspati.db.users
    (:require   [clojure.java.jdbc :as jdbc]
                [honeysql.core :as sql]
                [honeysql.helpers :refer [select from where sset]]))
(defn create-user [user db-spec]
    (jdbc/insert! db-spec :users user))