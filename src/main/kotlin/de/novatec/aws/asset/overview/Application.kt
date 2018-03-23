package de.novatec.aws.asset.overview


class Application{

    fun handler(): String {

       val html =  "<html>"+
                "<head>"+
                "    <title>Overview of Pact Libraries</title>"+
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />"+
                "    <link href=\"../static/css/style.css\" rel=\"stylesheet\" media=\"screen\" />"+
                "</head>"+
                "<body>"+
                ""+
                "<h1>Pact Libraries</h1>"+
                ""+
                "<hr />"+
                ""+
                "<!-- GitHub Repository Link -->"+
                "<a target=\"_blank\" href=\"https://github.com/nt-ca-aqe/pact\">"+
                "    <img src=\"https://img.shields.io/badge/repository-GitHub-blue.svg\" />"+
                "</a>"+
                "<!-- Documentation Link -->"+
                ""+
                "<!-- GitHub Release Badge -->"+
                "<a target=\"_blank\" href=\"https://github.com/nt-ca-aqe/pact/releases\">"+
                "    <img src=\"https://badge.fury.io/gh/nt-ca-aqe%2Fpact.svg\" />"+
                "</a>"+
                ""+
                "<hr />"+
                ""+
                "<div>"+
                "    <h2>Continuous Integration</h2>"+
                "    <p>The following table shows all of the project's maintained branches / versions with build status and quality metrics.</p>"+
                "    <table>"+
                "        <tr>"+
                "            <th>Branch</th>"+
                "            <th>Build</th>"+
                "            "+
                "            "+
                "        </tr>"+
                "        <tr>"+
                "            <td>master</td>"+
                "            <td>"+
                "                <!-- Travis CI Build Badge -->"+
                "                <a target=\"_blank\" href=\"https://travis-ci.org/nt-ca-aqe/pact/branches\">"+
                "                    <img src=\"https://travis-ci.org/nt-ca-aqe/pact.svg?branch=master\" />"+
                "                </a>"+
                "            </td>"+
                "            "+
                "            "+
                "        </tr>"+
                "    </table>"+
                "</div>"+
                ""+
                "<div>"+
                "    <h2>Artifacts</h2>"+
                "    <p>The following table shows all of the project's available modules.</p>"+
                "    <table>"+
                "        <tr>"+
                "            <th>Artifact</th>"+
                "            <th>Maven Central</th>"+
                "            <th>JavaDoc</th>"+
                "            <th>Dependencies</th>"+
                "        </tr>"+
                "        <tr>"+
                "            <td>pact-provider</td>"+
                "            <td>"+
                "                <!-- Maven Central Version Badge -->"+
                "                <a target=\"_blank\" href=\"https://maven-badges.herokuapp.com/maven-central/info.novatec.testit/pact-provider\">"+
                "                    <img src=\"https://maven-badges.herokuapp.com/maven-central/info.novatec.testit/pact-provider/badge.svg\" />"+
                "                </a>"+
                "            </td>"+
                "            <td>"+
                "                <!-- JavaDoc Version Badge -->"+
                "                <a target=\"_blank\" href=\"https://www.javadoc.io/doc/info.novatec.testit/pact-provider\">"+
                "                    <img src=\"https://www.javadoc.io/badge/info.novatec.testit/pact-provider.svg\" />"+
                "                </a>"+
                "            </td>"+
                "            <td>"+
                "                <!-- Dependency Analyse Badge -->"+
                "                <a target=\"_blank\" href=\"https://www.versioneye.com/java/info.novatec.testit:pact-provider/\">"+
                "                    <img src=\"https://www.versioneye.com/java/info.novatec.testit:pact-provider/badge?style=flat\" />"+
                "                </a>"+
                "            </td>"+
                "        </tr>"+
                "        <tr>"+
                "            <td>pact-provider-junit5</td>"+
                "            <td>"+
                "                <!-- Maven Central Version Badge -->"+
                "                <a target=\"_blank\" href=\"https://maven-badges.herokuapp.com/maven-central/info.novatec.testit/pact-provider-junit5\">"+
                "                    <img src=\"https://maven-badges.herokuapp.com/maven-central/info.novatec.testit/pact-provider-junit5/badge.svg\" />"+
                "                </a>"+
                "            </td>"+
                "            <td>"+
                "                <!-- JavaDoc Version Badge -->"+
                "                <a target=\"_blank\" href=\"https://www.javadoc.io/doc/info.novatec.testit/pact-provider-junit5\">"+
                "                    <img src=\"https://www.javadoc.io/badge/info.novatec.testit/pact-provider-junit5.svg\" />"+
                "                </a>"+
                "            </td>"+
                "            <td>"+
                "                <!-- Dependency Analyse Badge -->"+
                "                <a target=\"_blank\" href=\"https://www.versioneye.com/java/info.novatec.testit:pact-provider-junit5/\">"+
                "                    <img src=\"https://www.versioneye.com/java/info.novatec.testit:pact-provider-junit5/badge?style=flat\" />"+
                "                </a>"+
                "            </td>"+
                "        </tr>"+
                "    </table>"+
                "</div>"+
                ""+
                "</body>"+
                "</html>";

        return html

    }
}
