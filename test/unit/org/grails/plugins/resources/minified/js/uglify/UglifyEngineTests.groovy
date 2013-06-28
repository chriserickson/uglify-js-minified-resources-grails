package org.grails.plugins.resources.minified.js.uglify

class UglifyEngineTests extends grails.test.GrailsUnitTestCase {
    def uglifyEngine

    void setUp() {
        uglifyEngine = new UglifyEngine()
    }

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
        def output = uglifyEngine.minify(input, "In memory file")
        assert output.contains("testNamespace")
        assert output.contains("testPublicFunction")
        assert output.contains("testPublicFunction2")
        assert !output.contains("Private")
        assert !output.contains("comment")
    }
}

