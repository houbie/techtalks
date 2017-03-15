package be.ixor.techtalks.devops

import spock.lang.Specification

class VersionInfoTest extends Specification {
    def "main"() {
        expect:
        VersionInfo.getVersion() == 'could not read main manifest'
    }
}
