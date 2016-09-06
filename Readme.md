Dead letter queue configuration with RabbitMQ

Sample project used in [http://zoltanaltfatter.com/2016/09/06/dead-letter-queue-configuration-rabbitmq/](http://zoltanaltfatter.com/2016/09/06/dead-letter-queue-configuration-rabbitmq/)

1. Build the project

```
$ git clone https://github.com/altfatterz/rabbit-dead-letter-queue.git
$ cd rabbit-dead-letter-queue
$ mvn clean install
```

2. Start up RabbitMQ

```
$ rabbitmq-server
```

3. Start up the consumer

```
$ java -jar consumer/target/consumer-0.0.1-SNAPSHOT.jar
```

4. Start up the producer

```
$ java -jar producer/target/producer-0.0.1-SNAPSHOT.jar
```

5. Inspect message in the dead letter queue with management console

```
$ http://localhost:15672
```