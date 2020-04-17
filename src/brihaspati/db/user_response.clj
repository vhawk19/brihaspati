(ns brihaspati.db.user_response
    (:require [clojure.java.jdbc :as jdbc]
              [honeysql.core :as sql]
              [honeysql.helpers :refer [select from where]]))

(defn create-user-response [user-response db-spec]
    (jdbc/insert-multi! db-spec :response
                                user-response))