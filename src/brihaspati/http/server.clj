(ns brihaspati.http.server
    (:require   [ring.adapter.jetty :as jetty]
                [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
                [ring.middleware.params :refer [wrap-params]]
                [ring.middleware.defaults :refer [wrap-defaults site-defaults api-defaults]]
                [compojure.core :refer [defroutes GET POST PUT DELETE ANY]]
                [clojure.tools.logging :as log]
                [brihaspati.http.handlers.user_response :as user_response]
                [brihaspati.http.handlers.questions :as questions]
                [brihaspati.http.handlers.answers :as answers]
                [brihaspati.http.handlers.quiz :as quiz]))


(defn wrap [handler]
        (-> handler
            (wrap-json-body {:keywords? true})
            (wrap-json-response)))

(defroutes app-routes
        (POST "/api/questions" [] (wrap questions/create-question-handler))
        (POST "/api/answers" [] (wrap answers/create-answer-handler))
        (POST "/api/response/:event-id" [] (wrap user_response/create-response-handler))
        (GET  "/api/quiz/:event-id" [] (wrap quiz/get-quiz-handler))
        (GET  "/api/questions/:event-id" [] (wrap questions/get-questions-event-handler))
        (GET  "/api/answers/:event-id" [] (wrap answers/get-answers-event-handler)))


(defn int-parse [port]
    (try 
        (Integer/parseInt port)
        (catch Exception e (log/info e) 8080)))

(defonce server (atom nil))

(defn start [port]
    (reset! server (jetty/run-jetty (-> app-routes
                                        (wrap-defaults (-> api-defaults ))
                                        (wrap-params)) {:port (int-parse port)})))

(defn stop []
    (.stop @server)
    (reset! server nil))