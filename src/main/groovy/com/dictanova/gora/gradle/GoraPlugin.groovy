/*
* Copyright 2014 Damien Raude-Morvan
* Copyright 2013 Fabien Poulard
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.dictanova.gora.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class GoraPlugin implements Plugin<Project> {

    @Override
    void apply(final Project project) {

        project.task(type: GoraCompileTask, 'compileGora')

        project.afterEvaluate {
            project.tasks.compileGora.execute()
        }
    }
}
