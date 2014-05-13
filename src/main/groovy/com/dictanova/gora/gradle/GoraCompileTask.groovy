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

import org.apache.gora.compiler.GoraCompiler
import org.apache.maven.artifact.DependencyResolutionRequiredException
import org.gradle.api.tasks.SourceTask
import org.gradle.api.tasks.TaskAction

class GoraCompileTask extends SourceTask {

    static final String IDL_EXTENSION = ".avdl"
    static final String PROTOCOL_EXTENSION = ".avpr"
    static final String SCHEMA_EXTENSION = ".avsc"

    String stringType = "CharSequence"
    String templateDirectory = "/org/apache/avro/compiler/specific/templates/java/classic/"
    File destinationDir

    GoraCompileTask() {
        super()
        include "**/*$PROTOCOL_EXTENSION", "**/*$SCHEMA_EXTENSION", "**/*$IDL_EXTENSION"
    }

    @TaskAction
    void compile() {

        if (source.empty) {
            throw new Exception("source is empty")
        }

        source.each { File file ->

            logger.info("Processing ${file.name}" + file.name)
            try {
                if (file.name.endsWith(SCHEMA_EXTENSION)) {
                    GoraCompiler.compileSchema(file, destinationDir)
                } else {
                    throw new Exception("Do not know file type of ${file.name}")
                }
            } catch (DependencyResolutionRequiredException e) {
                throw new IOException(e)
            }
        }
    }
}
