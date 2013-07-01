class UglifyJsMinifiedResourcesGrailsPlugin {
    def loadAfter = ['resources']
    def version = "0.1"
    def grailsVersion = "2.0 > *"
    def title = "Uglify JS Minified Resources Plugin"
    def author = "Chris Erickson"
    def authorEmail = "cp.erickson@gmail.com"
    def description = 'Works with the resources plugin to minify javascript resource using Uglify2.'
    def license = "APACHE"

    def watchedResources = [ "file:./web-app/js/**/*.js", "file:./web-app/coffee/**/*.coffee", "file:./web-app/cs/**/*.coffee" ]
    def documentation = "https://github.com/chriserickson/uglify-js-minified-resources-grails"
    def issueManagement = [ system: "GitHub", url: "https://github.com/chriserickson/uglify-js-minified-resource-grails/issues" ]
    def scm = [url: 'https://github.com/chriserickson/uglify-js-minified-resource-grails']
}
