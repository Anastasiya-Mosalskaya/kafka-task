# kafka-task
The project has 2 avro schema versions. 
The version is specified in pom.xml as "avro.schema" property.
To run the project with another version, the following steps should be applied:
  - Update "avro.schema" property in pom.xml
  - Run mvn clean package command