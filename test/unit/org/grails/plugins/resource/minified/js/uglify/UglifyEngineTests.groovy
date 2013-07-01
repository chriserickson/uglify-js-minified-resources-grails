package org.grails.plugins.resource.minified.js.uglify

import grails.test.GrailsUnitTestCase

import org.grails.plugin.resource.minified.js.uglify.UglifyEngine

class UglifyEngineTests extends GrailsUnitTestCase {
    def uglifyEngine = new UglifyEngine()

    void testMinify() {
        def input = """
        var testNamespace = function() {
            // some comment
            var somePrivateVariable = 5;

            function somePrivateFunction() {}

            this.testPublicFunction = function() { return 1 }
            this.testPublicFunction2 = function() { return somePrivateVariable }
        }
"""
        def output = uglifyEngine.minify(input, [filename: "In memory file", noMunge: false])
        assert output.contains("testNamespace")
        assert output.contains("testPublicFunction")
        assert output.contains("testPublicFunction2")
        assert !output.contains("Private")
        assert !output.contains("comment")

        output = uglifyEngine.minify(input, [filename: "In memory file", noMunge: true])
        assert output.contains("testNamespace")
        assert output.contains("testPublicFunction")
        assert output.contains("testPublicFunction2")
        assert output.contains("Private")
        assert !output.contains("comment")
    }
}

