(ns brihaspati.http.handlers.user_response
    (:require [brihaspati.models.user_response :as models]
    [ring.util.response :refer [response status]]
    [clojure.tools.logging :as log]
    [brihaspati.config :as config]))

(defn create-response-handler [req]
    (let [db-spec (config/db-spec)
         request-body (:body req)
         event-id (get-in req [:params :event-id])]
         (log/info request-body)
         (models/create-response request-body db-spec event-id))
         (response {:status 200}))