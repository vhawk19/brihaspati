(ns brihaspati.http.handlers.answers
    (:require   [brihaspati.models.answers :as models]
                [ring.util.response :refer [response status]]
                [clojure.tools.logging :as log]
                [brihaspati.config :as config]))

(defn create-answer-handler [req]
    (let [db-spec (config/db-spec)
          request-body (:body req)]
        (response (models/create-answer request-body db-spec))))

(defn get-answers-event-handler [req]
    (let [db-spec (config/db-spec)
          event-id (Integer/parseInt (get-in req [:params :event-id]))]
          (response (models/get-answers-event event-id db-spec))))