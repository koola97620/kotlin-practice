plugins {
    kotlin("jvm") version "1.5.10"
    groovy
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.codehaus.groovy:groovy-all:3.0.5")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.assertj:assertj-core:3.13.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<Test> {
    useJUnitPlatform()
}
