# Semantic Versioning Changelog

# [2.4.0](https://github.com/JayDamon/setzer-account-service/compare/v2.3.0...v2.4.0) (2021-11-22)


### Features

* **ci:** Update ci with new build script ([d7b37ad](https://github.com/JayDamon/setzer-account-service/commit/d7b37adf7351653659a1633dff3d1f215b40f700))

# [2.3.0](https://github.com/JayDamon/setzer-account-service/compare/v2.2.3...v2.3.0) (2021-11-13)


### Features

* **jdk:** Java 17 upgrade ([a12bc84](https://github.com/JayDamon/setzer-account-service/commit/a12bc84191f38b56eb23dbafa55ab83539f12dbe))

## [2.2.3](https://github.com/JayDamon/setzer-account-service/compare/v2.2.2...v2.2.3) (2021-08-30)


### Bug Fixes

* **account:** Change current balance on starting balance change ([7519a96](https://github.com/JayDamon/setzer-account-service/commit/7519a9632775b3cd2627c9f1395c9fb649d325b3))
* **account:** Update current balance when new account is created ([5d2a0c7](https://github.com/JayDamon/setzer-account-service/commit/5d2a0c7b2c7cc4adc105342bbc7ab39288671121))

## [2.2.2](https://github.com/JayDamon/setzer-account-service/compare/v2.2.1...v2.2.2) (2021-08-27)


### Bug Fixes

* **db:** Fix order of db upgrade statements ([1717dcd](https://github.com/JayDamon/setzer-account-service/commit/1717dcd45ef5fc36f01aeac103204806ec8e2367))

## [2.2.1](https://github.com/JayDamon/setzer-account-service/compare/v2.2.0...v2.2.1) (2021-08-27)


### Bug Fixes

* **account:** Fix issue when current balance is not set in account table ([f2f167b](https://github.com/JayDamon/setzer-account-service/commit/f2f167b37d7d0fe077d4e8d5ec04972ebdbfca18))

# [2.2.0](https://github.com/JayDamon/setzer-account-service/compare/v2.1.2...v2.2.0) (2021-08-26)


### Features

* **rabbit:** Add rabbit mq messaging queue for async communication ([98ac2e3](https://github.com/JayDamon/setzer-account-service/commit/98ac2e34a5056c9dbed37a6f1a565e4ac0a5485f))

## [2.1.2](https://github.com/JayDamon/setzer-account-service/compare/v2.1.1...v2.1.2) (2021-08-13)


### Bug Fixes

* **kubernetes:** Use fabric8 client to avoid log error" ([429b780](https://github.com/JayDamon/setzer-account-service/commit/429b780a87366234bca5fbc200af4a58bc88e641))

## [2.1.1](https://github.com/JayDamon/setzer-account-service/compare/v2.1.0...v2.1.1) (2021-08-13)


### Bug Fixes

* **account:** Validate Account dto on create ([ebae856](https://github.com/JayDamon/setzer-account-service/commit/ebae8564d922fe09f78658da962560a41d1ed59b))

# [2.1.0](https://github.com/JayDamon/setzer-account-service/compare/v2.0.0...v2.1.0) (2021-08-08)


### Features

* **security:** Add discriminator based multi tenancy ([73eff6e](https://github.com/JayDamon/setzer-account-service/commit/73eff6ef3abc536d8de1b3cc38c3322fc175b2c2))

# [2.0.0](https://github.com/JayDamon/setzer-account-service/compare/v1.3.0...v2.0.0) (2021-08-06)


### Bug Fixes

* **ci:** Change docker file to point to maven output directory ([6705aef](https://github.com/JayDamon/setzer-account-service/commit/6705aef1f8a7718ea299d2c0c64ef2cd276c585a))
* **ci:** Fix main branch only exclusion ([c373031](https://github.com/JayDamon/setzer-account-service/commit/c3730313896c2d7196873fe6a4947b90085c3fd7))


### Features

* **build:** Convert to maven ([5bdf5b6](https://github.com/JayDamon/setzer-account-service/commit/5bdf5b6cebc50c0f0a86d307ebe2eae17b8afac5))
* **ci:** limit to only main branch for circle CI ([07c7455](https://github.com/JayDamon/setzer-account-service/commit/07c7455833d44573b8a684707733ff2054ece0a2))


### BREAKING CHANGES

* **build:** now usint maven instead of gradle to keep consistency for all apps

# [1.3.0](https://github.com/JayDamon/setzer-account-service/compare/v1.2.2...v1.3.0) (2021-08-05)


### Features

* **security:** Integrate local with oauth2/keycloak ([05bf478](https://github.com/JayDamon/setzer-account-service/commit/05bf4783177d01ed46c1fc46e600364cdee89534))

## [1.2.2](https://github.com/JayDamon/setzer-account-service/compare/v1.2.1...v1.2.2) (2021-07-27)


### Bug Fixes

* Update h2 database ([0572ace](https://github.com/JayDamon/setzer-account-service/commit/0572ace2aab74683212c48b74e368f952b8c23b7))

## [1.2.1](https://github.com/JayDamon/setzer-account-service/compare/v1.2.0...v1.2.1) (2021-07-27)


### Bug Fixes

* update imports ([bbc7010](https://github.com/JayDamon/setzer-account-service/commit/bbc7010312b02bdc973f9ccf7fb4c5769d9468c6))

# [1.2.0](https://github.com/JayDamon/setzer-account-service/compare/v1.1.2...v1.2.0) (2021-07-27)


### Features

* **client:** Add local docker config ([a308e3d](https://github.com/JayDamon/setzer-account-service/commit/a308e3d56cfdde5f5bb960d83d97022a5c5b549f))

## [1.1.2](https://github.com/JayDamon/setzer-account-service/compare/v1.1.1...v1.1.2) (2021-07-25)


### Bug Fixes

* **flyway:** Properly setup flyway ([796675f](https://github.com/JayDamon/setzer-account-service/commit/796675fc2e258dc707f6c2b81d3aff718022f8e4))

## [1.1.1](https://github.com/JayDamon/setzer-account-service/compare/v1.1.0...v1.1.1) (2021-07-25)


### Bug Fixes

* **discovery:** Use generic discovery client ([e609fe8](https://github.com/JayDamon/setzer-account-service/commit/e609fe88a639c841c5ce2085dd56518f81ef1067))

# [1.1.0](https://github.com/JayDamon/setzer-account-service/compare/v1.0.1...v1.1.0) (2021-07-25)


### Bug Fixes

* **tests:** Use updated api paths ([4acd9ce](https://github.com/JayDamon/setzer-account-service/commit/4acd9cef028e9d62f62e8f5000d9b6eaecd8d19f))


### Features

* **api:** Update api to work with k8s gateway ([0120d9d](https://github.com/JayDamon/setzer-account-service/commit/0120d9d6d7dcff0c0e8418ec25f95e94769ff8bd))
* **db:** Add flyway ([9f71128](https://github.com/JayDamon/setzer-account-service/commit/9f711280c5d2e3243a1a3a1d0aba24b254717272))

## [1.0.1](https://github.com/JayDamon/setzer-account-service/compare/v1.0.0...v1.0.1) (2021-07-21)


### Bug Fixes

* **gradle:** take ownership of gradlew and remove commented code ([5e1ade2](https://github.com/JayDamon/setzer-account-service/commit/5e1ade20604e729373ef9c44d509e1705440966c))

# 1.0.0 (2021-07-21)


### Bug Fixes

* **gradle:** remove commented code ([8e8e11f](https://github.com/JayDamon/setzer-account-service/commit/8e8e11fc16aa8f932dfed4a9d29dda52ca469ad4))
* **gradle:** remove plain jar from buid output ([2edfb29](https://github.com/JayDamon/setzer-account-service/commit/2edfb29887ea578186b28a83b0bc06011dab7573))


### Features

* **config:** Add circleci, semantic-release, kubernetes ([f9effa5](https://github.com/JayDamon/setzer-account-service/commit/f9effa52ac3c3d9aaa27aa953ef8bc9c963849fb))
