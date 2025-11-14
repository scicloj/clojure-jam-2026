^:kindly/hide-code
(ns speakers
  (:require [clojure.edn :as edn]
            [scicloj.kindly.v4.api :as kindly]
            [scicloj.kindly.v4.kind :as kind]))

^:kindly/hide-code
(def conference-info (edn/read-string (slurp "info.edn")))

^:kindly/hide-code
(kind/hiccup
 [:div {:style "display: flex; justify-content: flex-end; margin: 1rem 0; padding: 0.5rem; background: #f8f9fa; border-radius: 6px; border: 1px solid #e0e0e0;"}
  [:div {:style "display: flex; align-items: center; gap: 0.5rem;"}
   [:span {:style "font-size: 0.9rem; color: #666;"} "Supported by: "]
   (for [[company-key company-data] (:supporting-companies conference-info)]
     [:a {:key (name company-key)
          :href "./index.html#supporting-companies"
          :style "display: inline-flex; align-items: center; gap: 0.5rem; margin-left: 0.5rem; text-decoration: none;"}
      (when-let [logo-mark (:logo-mark company-data)]
        [:img {:src logo-mark
               :alt (str (:name company-data) " mark")
               :style "height: 20px; width: auto;"}])
      (when-let [logo (:logo company-data)]
        [:img {:src logo
               :alt (str (:name company-data) " logo")
               :style "height: 20px; width: auto;"}])])]])

;; # Submit Your Proposal

;; ::: {.callout-warning}
;; ## 🚧 DRAFT
;; This site is currently under development. Information may change.
;; :::
;; 
;; Clojure Jam celebrates creative expression through code. We're looking for talks and workshops that explore the artistic, musical, and visual possibilities of programming in Clojure.
;; 
;; Whether you're generating fractals, synthesizing music, visualizing data in new ways, or exploring any other form of creative coding, we want to see what you're building!

;; ## What We're Looking For

;; ### Topics

;; We're especially interested in (but not limited to):

^:kindly/hide-code
(kind/md
 (str "\n- " (apply str (interpose "\n- " (:preferred-topics conference-info)))))

;; ### Format Options
;;
;; - **Talks** (30-45 minutes) - Showcase your creative projects, techniques, or explorations
;; - **Workshops** (60-90 minutes) - Teach hands-on creative coding skills
;; - **Live Coding** (30-45 minutes) - Demonstrate real-time creative coding

;; ## Proposal Guidelines

;; ### Core Requirements

;; **1. Clojure Civitas Post Commitment** ⭐

;; **This is essential:** All speakers commit to writing a [Clojure Civitas](https://clojurecivitas.github.io/) post documenting their work.

;; Your Civitas post is how we build a lasting creative coding knowledge base for the Clojure community. It allows others to:
;;
;; - Reproduce your creative techniques
;; - Build upon your ideas
;; - Learn from your process
;; - Explore the code that creates your art/music/visualizations

;; We recommend Timothy Pratley's 🎥 [tutorial](https://www.youtube.com/watch?v=lceazLPcSZg) to get started with Clojure Civitas.

;; **2. Proposal Content**

;; Your proposal should include:
;;
;; - **Title** - Clear and engaging
;; - **Abstract** (150-300 words) - What will you demonstrate or teach?
;; - **Proof of Concept** - A draft Civitas post showing your work in progress
;; - **Format** - Talk, workshop, or live coding session
;; - **Duration** - How long you need

;; **3. Audience**

;; Aim for general Clojure programmers. Some familiarity with creative coding is fine, but your talk should be accessible to those new to the specific domain (music, art, etc.). We especially welcome talks that introduce creative coding concepts to Clojure developers!

;; ### What Makes a Great Proposal

;; ✨ **Show, Don't Just Tell** - Include visual examples, sound samples, or code snippets in your proposal

;; 🎨 **Creative Process** - Share your creative journey, not just the final result. How did you arrive at this technique? What experiments didn't work?

;; 🛠️ **Practical & Reproducible** - Others should be able to recreate and build upon your work

;; 🌱 **Beginner-Friendly** - Even advanced topics can be made accessible with good explanation

;; 💡 **Novel Approaches** - New uses of existing libraries, creative combinations of tools, or fresh perspectives

;; ## Libraries & Tools

;; We're especially interested in creative uses of:

^:kindly/hide-code
(kind/md
 (str "\n- " (apply str (interpose "\n- " (:key-libraries conference-info)))))

;; But don't feel limited! If you're using other libraries creatively, we want to hear about it.

;; ## Collaboration Welcome
;;
;; - **Team presentations** are encouraged
;; - **Cross-disciplinary collaborations** with artists, musicians, or designers are highly valued
;; - **New to public speaking?** We can help pair you with experienced co-presenters
;; - **Have a project idea but don't want to present?** We can help find someone to present your work

;; ## Timeline

^:kindly/hide-code
(let [timeline (:timeline conference-info)]
  (kind/md
   (str "\n| Event | Date |\n"
        "|-------|------|\n"
        "| Call for Proposals | " (:cfp-open timeline) " |\n"
        "| Submission Deadline | " (:cfp-deadline timeline) " |\n"
        "| Speaker Notification | " (:speaker-notification timeline) " |\n"
        "| Festival Dates | " (:festival-dates timeline) " |")))

;; ## How to Submit

;; We're still setting up the submission process. In the meantime:
;;
;; 1. Join the [Clojurians Zulip](https://scicloj.github.io/docs/community/chat/)
;; 2. Reach out in the #clojure-jam channel (coming soon) or [contact Scicloj directly](https://scicloj.github.io/docs/community/contact/)
;; 3. Share your idea and we'll help you develop it into a proposal

;; We're here to help you shape your ideas and create amazing creative coding content for the community!

;; ## Questions?

;; Have questions about what makes a good proposal? Wondering if your idea fits? Want to brainstorm?

;; [Let us talk](https://scicloj.github.io/docs/community/contact/){class="btn btn-gradient" target="_blank"}
