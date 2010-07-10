(ns com.benatkin.chardin.connect.couch
  (use [com.ashafa.clutch]))

(defn handle-couch [options]
  (with-db (options "database") (get-document (options "id"))))

