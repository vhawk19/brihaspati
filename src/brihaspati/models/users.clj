(ns brihaspati.models.users
    (:require [brihaspati.db.users :as users]))

(defn create-user [user-details db-spec]
    (users/create-user user-details db-spec))