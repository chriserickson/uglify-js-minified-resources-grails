This is a GRAILS plugin which provides minification of javascript resources using [Uglify2](https://github.com/mishoo/UglifyJS2).
It is dependent on the standard [GRAILS Resources Plugin](http://grails.org/plugin/resources)

## Background
Due to the fact that the [YUI Minified Resources Plugin](http://grails.org/plugin/yui-minify-resources) has
been deprecated, I thought it would be useful to create a new javascript minification plugin based on the Uglify2
project.

I made generous use of the [coffeescript resources plugin](https://github.com/edvinasbartkus/grails-coffeescript-resources)
for examples on how to use the Rhino library.

## Usage
This plugin should automagically minify your javascript files if it is enabled.

To disable variable munging, set the following in Config.groovy:
grails.resources.mappers.uglifyjs.noMunge = true

To get info on compression, turn on info logging in Config.groovy:
log4j = {
    // info 'org.grails.plugin.resource' //all resources info logging
    // info 'org.grails.plugin.resource.minified.js.uglify' // just the uglify info
}