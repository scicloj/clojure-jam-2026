^{:kindly/hide-code true
  :clay {:quarto {:description "Clojure Jam - A Festival of Creative Coding in Clojure - April 2026"
                  :title-block-style "none"
                  :image "https://scicloj.github.io/clojure-jam/images/sci-cloj-logo-transparent.png"
                  :twitter-card {:title "Clojure Jam 2026"
                                 :image "https://scicloj.github.io/clojure-jam/images/sci-cloj-logo-transparent.png"}
                  :open-graph {:title "Clojure Jam 2026"
                               :image "https://scicloj.github.io/clojure-jam/images/sci-cloj-logo-transparent.png"}}}}
(ns index
  "Main index page for Clojure Jam"
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [scicloj.kindly.v4.kind :as kind]))

^:kindly/hide-code
(def conference-data
  (edn/read-string (slurp "info.edn")))

^:kindly/hide-code
(kind/hiccup
 [:div {:style "display: flex; justify-content: flex-end; margin: 1rem 0; padding: 0.5rem; background: #f8f9fa; border-radius: 6px; border: 1px solid #e0e0e0;"}
  [:div {:style "display: flex; align-items: center; gap: 0.5rem;"}
   [:span {:style "font-size: 0.9rem; color: #666;"} "Supported by: "]
   (for [[company-key company-data] (:supporting-companies conference-data)]
     [:a {:key (name company-key)
          :href "#supporting-companies"
          :style "display: inline-flex; align-items: center; gap: 0.5rem; margin-left: 0.5rem; text-decoration: none;"}
      (when-let [logo-mark (:logo-mark company-data)]
        [:img {:src logo-mark
               :alt (str (:name company-data) " mark")
               :style "height: 20px; width: auto;"}])
      (when-let [logo (:logo company-data)]
        [:img {:src logo
               :alt (str (:name company-data) " logo")
               :style "height: 20px; width: auto;"}])])]])

^:kindly/hide-code
(kind/hiccup
 [:div
  [:div {:class "main-page"}

   ;; Conference intro section
   [:div {:class "conf-intro"}

    [:div {:class "conf-intro__title-wrapper"}
     [:h1 {:class "conf-intro__title"} "Clojure Jam 2026"]
     [:div {:class "conf-intro__subtitle"} "A Festival of Creative Coding in Clojure"]]]

   ;; Description
   [:div {:class "conf-intro__description"}
    "Clojure Jam is an online creative coding festival organized by "
    [:a {:href "https://scicloj.github.io/"} "Scicloj"]
    ". Join us in April 2026 for a celebration of "
    [:strong "music"] ", " [:strong "generative art"] ", " [:strong "creative visualization"]
    ", and all forms of creative expression through code."

    [:br] [:br]

    "This festival brings together artists, musicians, data enthusiasts, and creative coders to share projects, "
    "learn new techniques, and explore the boundaries of what's possible with Clojure's creative coding ecosystem."]]])

;; ::: {.callout-warning}
;; ## 🚧 DRAFT
;; This site is currently under development. Information may change.
;; :::

;; ## What is Creative Coding?

;; Creative coding is the practice of writing code to create expressive, artistic works rather than functional applications. It's where programming meets art, music, and visual design.

;; At Clojure Jam, we celebrate music & sound synthesis, generative art, creative data visualization, interactive installations, and explorations of order & chaos. See our [Sessions](./sessions.html) page to learn more about the topics we're exploring.

;; ## When & Where
;;
;; - **📅 Date:** April 2026 (specific dates TBD)
;; - **🌐 Format:** Online via Zoom
;; - **💰 Cost:** Free!
;; - **🎟️ Registration:** Coming soon

;; ## Timeline

^:kindly/hide-code
(let [timeline (:timeline conference-data)]
  (kind/md
   (str "\n- **Call for Proposals:** " (:cfp-open timeline)
        "\n- **Submission Deadline:** " (:cfp-deadline timeline)
        "\n- **Speaker Notification:** " (:speaker-notification timeline)
        "\n- **Festival Dates:** " (:festival-dates timeline))))

;; ## Call for Proposals

;; We're actively seeking creative coding talks and workshops! Whether you're working with music synthesis, generative art, data visualization, or any other form of creative expression in Clojure, we want to hear from you.

;; **Important:** All speakers commit to writing a [Clojure Civitas](https://clojurecivitas.github.io/) post documenting their work!

;; See our [Submit Proposal](./speakers.html) page for full details on topics, formats, and submission guidelines.

^:kindly/hide-code
(kind/hiccup
 [:div {:style "text-align: center; margin: 2rem 0;"}
  [:a {:href "./speakers.html"
       :class "btn btn-gradient"
       :style "display: inline-block; text-decoration: none; font-size: 1.1rem; padding: 0.75rem 1.5rem;"
       :aria-label "Submit your proposal for Clojure Jam"}
   "🎨 Submit Your Proposal"]])

;; ## Get Involved

;; Whether you want to attend, present, or just connect with fellow creative coders, there are many ways to participate. See our [Participation Guide](./participation.html) for details on registration, community chat, and more.

;; ## Code of Conduct

;; We are committed to providing a welcoming and inclusive environment for all participants. Please read our [Code of Conduct](./code_of_conduct.html).

;; ## Supporting Companies {#supporting-companies}

;; We are grateful to the following companies for their support of Clojure Jam:

^:kindly/hide-code
(kind/hiccup
 [:div {:style "margin: 2rem 0; padding: 1.5rem; background: #f8f9fa; border-radius: 8px; border: 1px solid #e0e0e0;"}
  (for [[company-key company-data] (:supporting-companies conference-data)]
    [:div {:key (name company-key) :style "margin-bottom: 1rem; display: flex; align-items: center; gap: 1.5rem;"}
     [:div {:style "display: flex; align-items: center; gap: 0.75rem; flex-shrink: 0;"}
      (when-let [logo-mark (:logo-mark company-data)]
        [:a {:href (:url company-data)
             :target "_blank"}
         [:img {:src logo-mark
                :alt (str (:name company-data) " mark")
                :style "height: 30px; width: auto;"}]])
      (when-let [logo (:logo company-data)]
        [:a {:href (:url company-data)
             :target "_blank"}
         [:img {:src logo
                :alt (str (:name company-data) " logo")
                :style "height: 30px; width: auto;"}]])]
     [:div
      [:h3 {:style "margin: 0 0 0.5rem 0;"}
       [:a {:href (:url company-data)
            :target "_blank"
            :style "color: #4299e1; text-decoration: none;"}
        (:name company-data)]]
      [:p {:style "margin: 0; color: #666;"} (:description company-data)]]])])

;; **Interested in supporting Clojure Jam?** We welcome companies who share our vision of creative exploration and growing the Clojure ecosystem. Please [contact us](https://scicloj.github.io/docs/community/contact/) to discuss how your company can get involved.

;; ## Contact

;; [Any questions? Let us talk](https://scicloj.github.io/docs/community/contact/){class="btn btn-gradient" target="_blank"}
