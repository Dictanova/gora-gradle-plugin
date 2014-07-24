gora-gradle-plugin
==================

Gradle Plugin for processing Avro files for Gora

## Overview
Generate Gora (http://gora.apache.org) java types from an Avro descriptor (.avsc files).
This plugin will delegate to GoraCompiler all schema read and file generation.

## Configuration
Configure the plugin in your project as follows:
```groovy
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'org.apache.maven:maven-artifact:2.2.1'
        classpath 'com.dictanova.gora.gradle:gora-gradle-plugin:0.5'
        classpath 'org.apache.gora:gora:0.4'
    }
}

// ...

apply plugin: 'com.dictanova.gora'

compileGora.source = 'src/main/resources/'
compileGora.destinationDir = file("src/main/java")

dependencies {
    compileGora
    compile "org.apache.gora:gora-core:0.4"
}
```

## Usage
Avro schema descriptors (.avsc) have to in the following directory :
```
src/main/resources/
```

You can generate Gora java types using compileGora directly or using build task:
```
$ gradle compileGora
$ gradle build
```

## Build
If you want to build this plugin from a Git checkout, please use Gradle Wrapper :
```
./gradlew clean build install
```

You can check latest Continuous Integration status on CloudBees :
https://drazzib.ci.cloudbees.com/job/gora-gradle-plugin/
