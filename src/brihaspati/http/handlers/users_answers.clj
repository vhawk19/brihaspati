(ns brihaspati.http.handlers.users-answers
    (:require   [brihaspati.models.users-answers :as models]
                [ring.util.response :refer [response status]]
                [clojure.tools.logging :as log]
                [brihaspati.config :as config]))

(defn create-users-answers-handler [req]
    (let [db-spec (config/db-spec)
          request-body (:body req)]
        (response (models/create-user-answer request-body db-spec))))

(defn get-users-answers-event-handler [req]
    (let [db-spec (config/db-spec)
    event-id (Integer/parseInt (get-in req [:params :event-id]))]
      (response (models/get-user-answer-event event-id db-spec))))