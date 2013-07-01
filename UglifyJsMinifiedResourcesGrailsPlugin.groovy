class UglifyJsMinifiedResourcesGrailsPlugin {
    def loadAfter = ['resources']
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resource that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def title = "Uglify JS Minified Resources Plugin" // Headline display name of the plugin
    def author = "Chris Erickson"
    def authorEmail = "cp.erickson@gmail.com"
    def description = '''\
Plugin that works with the resources plugin to minify javascript resource using Uglify2.
'''

    def watchedResources = [ "file:./web-app/js/**/*.js", "file:./web-app/coffee/**/*.coffee", "file:./web-app/cs/**/*.coffee" ]
    def documentation = "https://github.com/chriserickson/uglify-js-minified-resources-grails"
    def issueManagement = [ system: "GitHub", url: "https://github.com/chriserickson/uglify-js-minified-resource-grails/issues" ]

    def onChange = { event ->
    }

    def onConfigChange = { event ->
    }

    def doWithApplicationContext = {
    }

    def doWithSpring = { ->
        // these are in the coffeescript plugin, not sure what they do.
//        ResourceTagLib.SUPPORTED_TYPES['coffee'] = [type:'text/javascript', writer:'js']
//        ResourceProcessor.DEFAULT_MODULE_SETTINGS['coffee'] = [
//                disposition: 'defer'
//        ]
    }
}
