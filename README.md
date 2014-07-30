gora-gradle-plugin
==================

[Gradle](http://www.gradle.org/) plugin for processing [Avro](http://avro.apache.org/) files for [Gora](http://gora.apache.org)

[![Build Status](https://travis-ci.org/Dictanova/gora-gradle-plugin.svg)](https://travis-ci.org/Dictanova/gora-gradle-plugin)
[![Build Status](https://drone.io/github.com/Dictanova/gora-gradle-plugin/status.png)](https://drone.io/github.com/Dictanova/gora-gradle-plugin/latest)

## Overview
Generate [Apache Gora](http://gora.apache.org) java types from an [Apache Avro](http://avro.apache.org/) descriptor (.avsc files).
This plugin will delegate to GoraCompiler all schema read and file generation.

## Configuration
Configure the plugin in your project as follows:
```groovy
buildscript {
  repositories {
    jcenter()
  }
  dependencies {
    classpath "com.dictanova.gora.gradle:gora-gradle-plugin:0.6"
  }
}

apply plugin: "com.dictanova.gora"

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

