# Gradle
## Common Related Configurations

| Name                 | Used For                                   | Scope         |
| -------------------- | ------------------------------------------ | ------------- |
| `implementation`     | Main code dependencies (internal use)      | Compile + run |
| `api`                | Main code dependencies (exposed to users)  | Compile + run |
| `testImplementation` | Test-only compile and runtime dependencies | Test only     |
| `testRuntimeOnly`    | Test-only runtime dependencies             | Test only     |


###
``` java
// Gradle dependency implementation
import com.google.common.collect.ImmutableList;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		System.out.println(listOf("a", "b"));

	}
	

	public static ImmutableList<String> listOf(String... items) {
	     return ImmutableList.copyOf(items);
	 }

}
```

## Single project
```
my-gradle-project/        <-- 🟢 Root project (also the only project)
├── build.gradle.kts      <-- Gradle build script (Kotlin DSL)
├── settings.gradle.kts   <-- Tells Gradle the project name
├── gradle/               <-- Gradle wrapper scripts
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew               <-- Unix Gradle wrapper
├── gradlew.bat           <-- Windows Gradle wrapper
├── src/
│   ├── main/
│   │   └── java/          <-- Your application code
│   │       └── com/example/HelloWorld.java
│   └── test/
│       └── java/          <-- Your unit tests
│           └── com/example/HelloWorldTest.java
├── .project              <-- Eclipse project metadata
├── .classpath            <-- Eclipse classpath metadata
└── .settings/            <-- Eclipse settings folder
```
## multiple projects  
```
my-multi-project/
├── build.gradle.kts        <-- Empty or common config
├── settings.gradle.kts     <-- Includes subprojects
├── lib/                    <-- Subproject 1
│   ├── build.gradle.kts
│   └── src/main/java/...
├── app/                    <-- Subproject 2
│   ├── build.gradle.kts
│   └── src/main/java/...
└── gradle/ and gradlew/... <-- Wrapper files
```
```
rootProject.name = "my-multi-project"
include("lib", "app")
```
