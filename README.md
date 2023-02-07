# rf-fx-clipboard

A [re-frame](https://github.com/day8/re-frame) effect for copying text into the
clipboard.

This effect uses async
[clipboard API](https://developer.mozilla.org/en-US/docs/Web/API/Clipboard_API).

## Usage

**Step 1.**

Add the following project dependency:

[![Clojars](https://img.shields.io/clojars/v/net.clojars.jwierzbi/rf-fx-clipboard.svg)](https://clojars.org/net.clojars.jwierzbi/rf-fx-clipboard)

**Step 2.**

In the namespace add the "require":

```clj
(ns app.core
  (:require
    ...
    [rf-fx-clipboard] ;; add this
    ...))
```

**Step 3.**

To copy text to clipboard return the `:write-to-clipboard-fx` effect in the
effects map:

```clj
(re-frame/reg-event-fx
 ::event
 (fn [{:keys [db]} _]
   {...
    :write-to-clipboard-fx {:text "test text"             ;; text to copy
                            :on-success [::copy-success]  ;; success handler
                            :on-failure [::copy-failure]} ;; failure handler
    ...}))
```

Then define the `:on-success` and `:on-failure` handlers:

```clj
(re-frame/reg-event-db
 ::copy-success
 (fn [db [event]]
   (println "copy success")))

(re-frame/reg-event-db
 ::copy-failure
 (fn [db [event error]]
   (println "copy failure" error)))
```

## License

rf-fx-clipboard is [2-Clause BSD License](LICENSE).
