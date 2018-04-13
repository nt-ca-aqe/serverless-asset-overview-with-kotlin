package de.novatec.aws.asset.overview

data class Project(
        var id: String,
        var name: String,
        var organization: String,
        var repository: String,
        var documentation: String?,
        var branches: List<String>,
        var services: Set<Service>,
        var artifacts: List<Artifact>
) {

    enum class Service { TRAVIS_CI, CODECOV, BETTER_CODE_HUB }
    data class Artifact(var groupId: String, var artifactId: String)

}