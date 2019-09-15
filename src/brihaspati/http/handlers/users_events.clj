(ns brihaspati.http.handlers.users-events
    (:require   [brihaspati.models.users-events :as models]
                [ring.util.response :refer [response status]]
                [clojure.tools.logging :as log]
                [brihaspati.config :as config]))

(defn create-user-event-handler [req]
    (let [db-spec (config/db-spec)
          request-body (:body req)]
        (models/create-user-event request-body db-spec)))