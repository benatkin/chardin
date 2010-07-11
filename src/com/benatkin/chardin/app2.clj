(ns com.benatkin.chardin.app2
  (:gen-class)
  (:use ring.adapter.jetty))

(defn web-app [req]
  {:status  404
   :headers {"Content-Type" "text/html"}
   :body    "<p>Resource not found.</p>"})

(def *routes*
  '[(#"^$"     {:page "home"})
    (#"^(.*)$" {:page 1})])

(defn route [path]
  (defn route-groups [a-route]
    (re-matches (first a-route) path))
  (defn route-data [a-route]
    (let [groups (route-groups a-route)
          data (second a-route)]
      (defn get-group [value] (if (number? value) (groups value) value))
      (if groups
          (zipmap (keys data)
                  (map get-group (vals data))))))
  (let [matching-route (first (filter route-groups *routes*))]
    (route-data matching-route)))

(defn start-app []
  (run-jetty web-app {:port 8080}))

(defn -main [& args]
  (start-app))
