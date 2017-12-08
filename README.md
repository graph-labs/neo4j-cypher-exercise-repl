# Neo4j Cypher Workshop framework

## Dataset

You should make sure to have a non-empty database:

 * for instance, get the raw "Cineasts" dataset [here](http://example-data.neo4j.org/3.0-datasets/cineasts.tgz)
 * configure your DB to point to it

The exercises are automatically imported from the [classpath](./workshop/src/main/resources/exercises/dump.cypher) in
an idempotent way (thus preserving the user progression between each re-run).

## Generating the exercises

Please read the generator [README](./generator/README.md).

For convenience purposes, you should rely on and edit as needed the generator input file versioned [here](./workshop/raw_exercises/exercises.json).

## Crazy one-liner

Replace `£PASSWORD£` in the command below by your Neo4j password.

This will:

 1. generate the dump from the versioned exercise descriptors
 1. package the workshop REPL
 1. start it from a temporary directory

```
$> mvn clean package -DskipTests && mkdir target && echo '£PASSWORD£' > target/password.txt && mvn -f generator exec:java -Dexec.mainClass="fr.graphlabs.neo4j.repl.generator.Main" -Dexec.args="-o workshop/src/main/resources/exercises/dump.cypher -f workshop/raw_exercises/exercises.json -u neo4j -p " < target/password.txt && rm target/password.txt && mvn -f workshop clean package -DskipTests && repl_dir=$(mktemp -d); unzip workshop/target/devoxx-fr-2017-neo4j-lab.zip -d ${repl_dir} && cd ${repl_dir} &&  ./devoxx-fr-2017-neo4j-lab/bin/hands-on-neo4j -u neo4j -p
```
