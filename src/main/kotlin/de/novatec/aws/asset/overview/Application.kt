package de.novatec.aws.asset.overview

import de.novatec.aws.asset.overview.Project.Artifact
import de.novatec.aws.asset.overview.Project.Service.*
import java.util.*

class Application {

    companion object {
        val LIVING_DOC = Project(
                id = "livingdoc",
                name = "LivingDoc",
                organization = "LivingDoc",
                repository = "livingdoc",
                documentation = null,
                branches = listOf("master"),
                services = setOf(TRAVIS_CI, BETTER_CODE_HUB),
                artifacts = listOf()

        )
        val PACT_LIBRARIES = Project(
                id = "pactlibraries",
                name = "Pact Libraries",
                organization = "nt-ca-aqe",
                repository = "pact",
                documentation = null,
                branches = listOf("master"),
                services = setOf(TRAVIS_CI),
                artifacts = listOf(
                        Artifact("info.novatec.testit", "pact-provider"),
                        Artifact("info.novatec.testit", "pact-provider-junit5")
                )
        )
        val RESULT_REPOSITORY = Project(
                id = "resultrepository",
                name = "ResultRepository",
                organization = "testIT-ResultRepository",
                repository = "resultrepository-core",
                documentation = null,
                branches = listOf("master"),
                services = setOf(TRAVIS_CI, BETTER_CODE_HUB),
                artifacts = listOf()
        )
        val TEST_UTILS = Project(
                id = "testutils",
                name = "TestUtils",
                organization = "nt-ca-aqe",
                repository = "testit-testutils",
                documentation = null,
                branches = listOf("master"),
                services = setOf(TRAVIS_CI, CODECOV, BETTER_CODE_HUB),
                artifacts = listOf(
                        Artifact("info.novatec.testit", "testutils-logrecorder"),
                        Artifact("info.novatec.testit", "testutils-logrecorder-logback"),
                        Artifact("info.novatec.testit", "testutils-logsuppressor-logback"),
                        Artifact("info.novatec.testit", "testutils-mockito")
                )
        )
        val WEB_TESTER = Project(
                id = "webtester",
                name = "WebTester",
                organization = "testIT-WebTester",
                repository = "webtester2-core",
                documentation = "https://oss.sonatype.org/service/local/artifact/maven/redirect?r=releases&g=info.novatec.testit&a=webtester-documentation&v=LATEST&e=html",
                branches = listOf(
                        "master",
                        "releases/2.5.x",
                        "releases/2.4.x",
                        "releases/2.3.x",
                        "releases/2.2.x",
                        "releases/2.1.x",
                        "releases/2.0.x"
                ),
                services = setOf(TRAVIS_CI, CODECOV, BETTER_CODE_HUB),
                artifacts = listOf(
                        Artifact("info.novatec.testit", "webtester-core"),
                        Artifact("info.novatec.testit", "webtester-kotlin"),
                        Artifact("info.novatec.testit", "webtester-support-assertj3"),
                        Artifact("info.novatec.testit", "webtester-support-hamcrest"),
                        Artifact("info.novatec.testit", "webtester-support-junit4"),
                        Artifact("info.novatec.testit", "webtester-support-junit5"),
                        Artifact("info.novatec.testit", "webtester-support-spring4")
                )

        )
    }

    private val projects = listOf(LIVING_DOC, PACT_LIBRARIES, RESULT_REPOSITORY, TEST_UTILS, WEB_TESTER)

    fun handler(id: String?): String {
        // TODO: select project via parameter instead of randomly
        val project = getProject(id)
        return ProjectRenderer().html(project)
    }

    private fun getProject(id: String?): Project {
        if (id == null) {
            return projects[Random().nextInt(projects.size)]
        }
        return projects.single { it.id.equals(id, true) }
    }

}
