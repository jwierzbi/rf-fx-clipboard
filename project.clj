(defproject net.clojars.jwierzbi/rf-fx-clipboard "0.1.0-SNAPSHOT"
  :description "re-frame effect for copying text to the system clipboard."
  :url "https://github.com/jwierzbi/rf-rx-clipboard"
  :license {:name "BSD-2-Clause"
            :url "https://github.com/jwierzbi/rf-rx-clipboard/blob/main/LICENSE"}
  :dependencies [[org.clojure/clojure "1.11.1" :scope "provided"]
                 [org.clojure/clojurescript "1.11.54" :scope "provided"]
                 [re-frame "1.3.0" :scope "provided"]]
  :repl-options {:init-ns rf-fx-clipboard.core}

  :deploy-repositories [["clojars" {:url "https://repo.clojars.org"
                                    :sign-release false
                                    :username :env/CLOJARS_USERNAME
                                    :password :env/CLOJARS_PASSWORD}]]

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version"
                   "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["deploy" "clojars"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]])
