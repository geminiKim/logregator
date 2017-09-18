# Logregator
Logregator is Log Aggregator. 

It is installed on several servers and collects logs to central Logregator.

# Run Tests
```
./gradlew test
```

# Build & Run

```
$ cd {Logregator source directory}
$ ./gradlew buildExcutableJar
$ cd bin
$ java -jar logregator-1.0.0.jar 

// You want custom config, should be configure '/config/*.json'
// run 'java -jar logregator-1.0.0.jar config/{confing-file-name}.json
```
