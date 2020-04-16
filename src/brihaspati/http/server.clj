(ns brihaspati.http.server
    (:require   [ring.adapter.jetty :as jetty]
                [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
                [ring.middleware.params :refer [wrap-params]]
                [ring.middleware.defaults :refer [wrap-defaults site-defaults api-defaults]]
                [ring.util.response :as response]
                [compojure.core :refer [defroutes GET POST PUT DELETE ANY]]
                [clojure.tools.logging :as log]
                [brihaspati.http.handlers.questions :as questions]
                [brihaspati.http.handlers.answers :as answers]))


(defn wrap [handler]
        (-> handler
            (wrap-json-body {:keywords? true})
            (wrap-json-response)))

(defroutes app-routes
        (POST "/api/question" [] (wrap questions/create-question-handler))
        (POST "/api/answer" [] (wrap answers/create-answer-handler))
        (GET  "/api/question/:event-id" [] (wrap questions/get-questions-event-handler))
        (GET  "/api/answer/:event-id" [] (wrap answers/get-answers-event-handler)))

(defn int-parse [port]
    (try 
        (Integer/parseInt port)
        (catch Exception e (log/info e) 8080)))

(defonce server (atom nil))

(defn start [port]
    (reset! server (jetty/run-jetty (-> app-routes
                                        (wrap-defaults (-> api-defaults ))
                                        (ring.middleware.params/wrap-params)) {:port (int-parse port)})))

(defn stop []
    (.stop @server)
    (reset! server nil))