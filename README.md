# Simple Enrichment

## Description
In this assessment we will implement a general purpose application to enrich an input stream of records with an external data source. We will use three design patterns: Singleton, Factory, and Strategy

## TypeSafe Configuration Library
A basic requirement of implementing a general purpose application is to use configuration to pass different properties. TypeSafe config library has proven itself a powerful player in this area. It also uses a special document type called HOCON.
For more information about TypeSafe config library and HOCON, see [here](https://github.com/lightbend/config)

The assignment structure already is using the library and you don’t need to implement anything.

## Open the Assessment
Download the assessment, using Eclipse import the assessment as a maven project.

## Assessment Requirements

1. Make **Configuration** class singleton. The Configuration class will read your configuration file that is in this case by default **reference.conf** and instantiates the variables.
2. Implement **FileReaderParse** interface for two different file types: JSON and CSV. Check out **subscriber.json** and **subscriber.csv** for the format of each line. Each line is an input to the parseSubscriber method of **FileReaderParser** and converts it to an instance of **Subscriber**.
3. A Strategy pattern is implemented for **InputSource** class that you can inject any implementation of **FileReaderParser**. Complete the assessment by applying Factory pattern to instantiate a **FileReaderParser** based on value of "type" given in the Configuration class.
