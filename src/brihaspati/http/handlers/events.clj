(ns brihaspati.http.handlers.events
    (:require   [brihaspati.models.events :as models]
                [ring.util.response :refer [response status]]
                [clojure.tools.logging :as log]
                [brihaspati.config :as config]))

(defn create-event-handler [req]
    (let [db-spec (config/db-spec)
          request-body (:body req)]
        (response (models/create-event request-body db-spec))))