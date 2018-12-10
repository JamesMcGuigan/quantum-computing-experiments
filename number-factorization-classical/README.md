# Number Factorization Classical

As an early investigation into Shor's algorithm, lets try to solve the number factorization problem classically in Scala.

## Compile and Run

#### sbt run project
```bash
sbt clean
sbt compile
sbt run
``` 

#### sbt run single class
```bash
sbt "show discoveredMainClasses"
sbt "runMain com.jamesmcguigan.factorization.Main"
```

#### scala + scalac 
```bash
sbt clean
mkdir -p target/scala-2.12/classes/
find ./src/ -name '*.scala' | xargs scalac -d target/scala-2.12/classes/
scalac -d target/scala-2.12/classes/  src/main/scala/com/jamesmcguigan/factorization/Main.scala
scala -cp target/scala-2.12/classes/  "com.jamesmcguigan.factorization.Main"
```

