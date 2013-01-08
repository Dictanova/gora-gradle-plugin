package org.apache.gora.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class GoraPlugin implements Plugin<Project> {

    @Override
    void apply( final Project project ) {

        project.task( type: GoraCompileTask, 'compileGora' )

        project.afterEvaluate {
            project.tasks.compileGora.execute()
        }
    }
}
