(defproject brihaspati "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                  [ring "1.7.1"]
                  [org.clojure/tools.logging "0.4.1"]
                  [ragtime "0.8.0"]
                  [aero "1.1.3"]
                  [compojure "1.6.1"]
                  [org.postgresql/postgresql "42.1.4"]
                  [org.clojure/java.jdbc "0.7.9"]
                  [ring/ring-defaults "0.3.2"]
                  [ring/ring-json "0.4.0"]]
      
                  :aliases {"migrate" ["run" "-m" "brihaspati.db.migrations/migrate"]
                  "migrate-test" ["run" "-m" "brihaspati.db.migrations/migrate-test"]
                  "rollback" ["run" "-m" "brihaspati.db.migrations/rollback"]
                  "rollback-all-test" ["run" "-m" "brihaspati.db.migrations/rollback-all-test"]}
  :main ^:skip-aot brihaspati.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
