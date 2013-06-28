package org.grails.plugins.resources.minified.js.uglify

import org.codehaus.groovy.grails.plugins.support.aware.GrailsApplicationAware
import org.grails.plugins.resources.minified.js.uglify.UglifyEngine
import org.mozilla.javascript.EvaluatorException
import org.codehaus.groovy.grails.commons.GrailsApplication

class UglifyJsMinifyResourceMapper implements GrailsApplicationAware {
    def phase = MapperPhase.COMPRESSION
    def operation = "uglify"
    static defaultIncludes = ['**/*.js']

    GrailsApplication grailsApplication

    def map(resource, config) {
        if (!config.enabled)
            return

        File original = resource.processedFile
        File target

        if (resource.sourceUrl && original.name.toLowerCase().endsWith(".js")) {
            File input
            try {
                input = grailsApplication.parentContext.getResource(resource.sourceUrl).file
            } catch (FileNotFoundException e) {
                input = new File(original.absolutePath)
            }
            target = new File(original.absolutePath.replaceAll(/(?i)\.js$/, ".min.js"))

            if (log.debugEnabled)
                log.debug "Uglifying javascript file ${original} to ${target}"

            try {
                def output = new UglifyEngine().minify(input.text, original.name)
                target.write(output)

                resource.processedFile = target
                resource.updateActualUrlFromProcessedFile()
                resource.sourceUrlExtension = "js"
                resource.actualUrl = resource.originalUrl.replaceAll(/(?i)\.js$/, ".min.js")
            } catch (Exception e) {
                log.error """
                    Problems uglifying javascript ${resource.originalUrl}
                    $e
                    """
                Throwable cause = e
                while (cause.cause) {
                    cause = cause.cause
                    if (cause instanceof EvaluatorException) {
                        log.error("Uglify error: $cause.message")
                    }
                }
                e.printStackTrace()
            }
        }

    }
}