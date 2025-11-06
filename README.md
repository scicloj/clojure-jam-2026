# clojure-jam

This is the website project for Clojure Jam, a creative coding festival celebrating music, generative art, and creative visualization in Clojure.

It is developed as a data-driven [Quarto Website](https://quarto.org/docs/websites/) using Clojure and Clay. Content pages are generated from Clojure source files in the `pages/` directory, with conference data stored in `info.edn`.

## Development
First, make sure you have [Quarto](https://quarto.org/docs/get-started/) installed before starting if you haven't already.

This project setup references the setup from [Clojure Civitas](https://github.com/ClojureCivitas/clojurecivitas.github.io) 
with its easy setup for Qaurto website using [Clay](https://scicloj.github.io/clay/).

Follow [these instructions](https://github.com/ClojureCivitas/clojurecivitas.github.io?tab=readme-ov-file#preview-your-namespace-as-a-webpage-optional-recommended).

from Clojure Civitas' repo to preview the site locally while developing.

To make changes to pages, edit the Clojure files in the `pages/` directory.
To modify conference data (when we have speakers, sessions, etc.), edit `info.edn`.

## Publishing

The site is automatically published using a GitHub Actions workflow(`.github/workflows/publish.yml`).
Whenever a new commit is pushed to the main branch, the workflow builds the updated site and deploys it to the `gh-pages` branch.
The live site is available at: https://scicloj.github.io/clojure-jam/
# clojure-jam-2026
