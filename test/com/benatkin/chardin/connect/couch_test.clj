(ns com.benatkin.chardin.connect.couch-test
  (use [com.benatkin.chardin.connect.couch] :reload-all)
  (use [clojure.test]))
  
(defn couch-connect-doc [params]
  (merge params
    {"source" "couch"
     "database" "chardin-test"}))

(deftest test-get-by-id
  (is (:name (handle-couch
              (couch-connect-doc {"id" "test-doc"})))
      "chardin"))

