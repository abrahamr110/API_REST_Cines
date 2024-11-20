import org.springframework.boot.gradle.tasks.bundling.BootWar

plugins {
	java
	war
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.es"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("javax.servlet:javax.servlet-api:4.0.1")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.mysql:mysql-connector-j")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	providedCompile("javax.servlet:javax.servlet-api:4.0.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
tasks.named<War>("bootWar") {
	archiveFileName.set("diecines-0.0.1-SNAPSHOT-plain.war")
}

