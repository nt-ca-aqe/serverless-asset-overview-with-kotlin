package de.novatec.aws.asset.overview

import de.novatec.aws.asset.overview.Project.Artifact
import de.novatec.aws.asset.overview.Project.Service.*

class ProjectRenderer {

    fun html(project: Project): String {
        val repositoryBadge = repositoryBadge(project)
        val documentationBadge = documentationBadge(project)
        val versionBadge = versionBadge(project)

        val continuousIntegrationSection = continuousIntegrationSection(project)
        val artifactsSection = artifactsSection(project)

        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Overview of ${project.name}</title>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            </head>
            <body>

            <h1>${project.name}</h1>

            <hr/>
            $repositoryBadge
            $documentationBadge
            $versionBadge
            <hr/>

            $continuousIntegrationSection
            $artifactsSection

            </body>
            </html>
            """
    }

    private fun repositoryBadge(project: Project) = """
        <!-- GitHub Repository Link -->
        <a href="https://github.com/${project.organization}/${project.repository}" target="_blank">
            <img src="https://img.shields.io/badge/repository-GitHub-blue.svg">
        </a>
        """

    private fun documentationBadge(project: Project): String {
        if (project.documentation == null)
            return ""

        return """
            <!-- Documentation Link -->
            <a href="${project.documentation}" target="_blank">
                <img src="https://img.shields.io/badge/documentation-Online-green.svg">
            </a>
            """
    }

    private fun versionBadge(project: Project) = """
        <!-- GitHub Release Badge -->
        <a href="https://github.com/${project.organization}/${project.repository}/releases" target="_blank">
            <img src="https://badge.fury.io/gh/${project.organization}%2F${project.repository}.svg">
        </a>
        """

    private fun continuousIntegrationSection(project: Project): String {
        val branches = project.branches
        val services = project.services

        if (branches.isEmpty() || services.isEmpty())
            return ""

        val headerFields = mutableListOf("Branch").apply {
            if (services.contains(TRAVIS_CI)) add("Build")
            if (services.contains(CODECOV)) add("Coverage")
            if (services.contains(BETTER_CODE_HUB)) add("Better Code")
        }
        val headerRow = headerFields.joinToString(prefix = "<tr><th>", separator = "</th><th>", postfix = "</th></tr>")

        val rows = branches.map { branch ->
            val rowFields = mutableListOf(branch).apply {
                if (services.contains(TRAVIS_CI)) add(travisBadge(project, branch))
                if (services.contains(CODECOV)) add(codecovBadge(project, branch))
                if (services.contains(BETTER_CODE_HUB)) add(bettercodeBadge(project, branch))
            }
            rowFields.joinToString(prefix = "<tr><td>", separator = "</td><td>", postfix = "</td></tr>")
        }
        val bodyRows = rows.joinToString(separator = "\n")

        return """
            <h2>Continuous Integration</h2>
            <p>The following table shows all of the project's maintained branches / versions with build status and quality metrics.</p>
            <table>
                $headerRow
                $bodyRows
            </table>
            """
    }

    private fun travisBadge(project: Project, branch: String) = """
        <!-- Travis CI Build Badge -->
        <a href="https://travis-ci.org/${project.organization}/${project.repository}/branches" target="_blank">
            <img src="https://travis-ci.org/${project.organization}/${project.repository}.svg?branch=$branch">
        </a>
        """

    private fun codecovBadge(project: Project, branch: String) = """
        <!-- Codecov Badge -->
        <a href="https://codecov.io/gh/${project.organization}/${project.repository}/branch/$branch" target="_blank">
            <img src="https://codecov.io/gh/${project.organization}/${project.repository}/branch/$branch/graph/badge.svg">
        </a>
        """

    private fun bettercodeBadge(project: Project, branch: String) = """
        <!-- Better Code Hub Badge -->
        <a href="https://bettercodehub.com/results/${project.organization}/${project.repository}/" target="_blank">
            <img src="https://bettercodehub.com/edge/badge/${project.organization}/${project.repository}?branch=$branch">
        </a>
        """

    private fun artifactsSection(project: Project): String {
        val artifacts = project.artifacts
        if (artifacts.isEmpty())
            return ""

        val headerFields = mutableListOf("Artifact", "Maven Central", "JavaDoc", "Dependencies")
        val headerRow = headerFields.joinToString(prefix = "<tr><th>", separator = "</th><th>", postfix = "</th></tr>")

        val rows = artifacts.map { artifact ->
            val rowFields = mutableListOf(
                    artifact.artifactId,
                    mavenCentralBadge(artifact),
                    javaDocBadge(artifact),
                    dependenciesBadge(artifact)
            )
            rowFields.joinToString(prefix = "<tr><td>", separator = "</td><td>", postfix = "</td></tr>")
        }
        val bodyRows = rows.joinToString(separator = "\n")

        return """
            <h2>Artifacts</h2>
            <p>The following table shows all of the project's available modules.</p>
            <table>
                $headerRow
                $bodyRows
            </table>
            """
    }

    private fun mavenCentralBadge(artifact: Artifact) = """
        <!-- Maven Central Version Badge -->
        <a href="https://maven-badges.herokuapp.com/maven-central/${artifact.groupId}/${artifact.artifactId}" target="_blank">
            <img src="https://maven-badges.herokuapp.com/maven-central/${artifact.groupId}/${artifact.artifactId}/badge.svg">
        </a>
        """

    private fun javaDocBadge(artifact: Artifact) = """
        <!-- JavaDoc Version Badge -->
        <a href="https://www.javadoc.io/doc/${artifact.groupId}/${artifact.artifactId}" target="_blank">
            <img src="https://www.javadoc.io/badge/${artifact.groupId}/${artifact.artifactId}.svg">
        </a>
        """

    private fun dependenciesBadge(artifact: Artifact) = """
        <!-- Dependency Analyse Badge -->
        <a href="https://www.versioneye.com/java/${artifact.groupId}:${artifact.artifactId}/" target="_blank">
            <img src="https://www.versioneye.com/java/${artifact.groupId}:${artifact.artifactId}/badge?style=flat">
        </a>
        """

}