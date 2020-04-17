(ns brihaspati.http.handlers.quiz
    (:require [brihaspati.models.quiz :as models]
              [ring.util.response :refer [response status]]
              [brihaspati.config :as config]
              [clojure.tools.logging :as log]))

(defn get-quiz-handler [req]
    (let [db-spec (config/db-spec)
         event-id (get-in req [:params :event-id])]
         (log/info req)
         (response (models/get-quiz-event db-spec event-id))))