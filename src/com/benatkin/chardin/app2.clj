(ns com.benatkin.chardin.app2
  (:gen-class)
  (:use ring.adapter.jetty))

(defn web-app [req]
  {:status  404
   :headers {"Content-Type" "text/html"}
   :body    "<p>Resource not found.</p>"})

(defn start-app []
  (run-jetty web-app {:port 8080}))

(defn -main [& args]
  (start-app))
