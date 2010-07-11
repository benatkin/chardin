(ns com.benatkin.chardin.app2
  (:gen-class)
  (:use ring.adapter.jetty))

(def *patterns*
  '[(#"^$"     {:page "home"})
    (#"^(.*)$" {:page 1})])

(defn parse-path [path]
  (defn pattern-groups [pattern]
    (re-matches (first pattern) path))
  (defn pattern-data [pattern]
    (let [groups (pattern-groups pattern)
          data (second pattern)]
      (defn get-group [value] (if (number? value) (groups value) value))
      (if groups
          (zipmap (keys data)
                  (map get-group (vals data))))))
  (let [matching-pattern (first (filter pattern-groups *patterns*))]
    (pattern-data matching-pattern)))

(defn find-resources [params] nil)

(defn render [data] nil)

(defn web-app [req]
  {:status  404
   :headers {"Content-Type" "text/html"}
   :body    "<p>Resource not found.</p>"})

(defn start-app []
  (run-jetty web-app {:port 8080}))

(defn -main [& args]
  (start-app))
