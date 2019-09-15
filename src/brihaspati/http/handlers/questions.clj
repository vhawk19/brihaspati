(ns brihaspati.http.handlers.questions
    (:require   [brihaspati.models.questions :as models]
                [ring.util.response :refer [response status]]
                [brihaspati.config :as config]))

(defn create-question-handler [req]
    (let [db-spec (config/db-spec)
          request-body (:body req)]
        (response (models/create-question request-body db-spec))))

(defn get-questions-event [req ]
  (let [db-spec (config/db-spec)
        event-id (Integer/parseInt (get-in req [:params :event-id]))]
  (response (models/get-questions-event event-id (config/db-spec)))))