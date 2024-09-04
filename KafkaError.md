myapp-1      | 2024-09-04T17:17:26.276Z  INFO 1 --- [myapp] [ntainer#0-0-C-1] o.s.k.l.KafkaMessageListenerContainer    : notification-processing: partitions assigned: [notifications-0]
myapp-1      | 2024-09-04T17:17:26.276Z  INFO 1 --- [myapp] [ntainer#2-0-C-1] o.s.k.l.KafkaMessageListenerContainer    : payment-processing: partitions assigned: [payments-0]
myapp-1      | 2024-09-04T17:17:26.276Z  INFO 1 --- [myapp] [ntainer#3-0-C-1] o.s.k.l.KafkaMessageListenerContainer    : delivery-processing: partitions assigned: [delivery-orders-0]
myapp-1      | 2024-09-04T17:17:26.276Z  INFO 1 --- [myapp] [ntainer#1-0-C-1] o.s.k.l.KafkaMessageListenerContainer    : order-validation: partitions assigned: [orders-0]
myapp-1      | 2024-09-04T17:17:33.267Z  INFO 1 --- [myapp] [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
myapp-1      | 2024-09-04T17:17:33.267Z  INFO 1 --- [myapp] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
myapp-1      | 2024-09-04T17:17:33.269Z  INFO 1 --- [myapp] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms
myapp-1      | 2024-09-04T17:17:33.354Z  INFO 1 --- [myapp] [nio-8080-exec-1] o.a.k.clients.producer.ProducerConfig    : ProducerConfig values:
myapp-1      | 	acks = -1
myapp-1      | 	auto.include.jmx.reporter = true
myapp-1      | 	batch.size = 16384
myapp-1      | 	bootstrap.servers = [kafka:9092]
myapp-1      | 	buffer.memory = 33554432
myapp-1      | 	client.dns.lookup = use_all_dns_ips
myapp-1      | 	client.id = producer-order-transaction-id0
myapp-1      | 	compression.type = none
myapp-1      | 	connections.max.idle.ms = 540000
myapp-1      | 	delivery.timeout.ms = 120000
myapp-1      | 	enable.idempotence = true
myapp-1      | 	interceptor.classes = []
myapp-1      | 	key.serializer = class org.apache.kafka.common.serialization.StringSerializer
myapp-1      | 	linger.ms = 0
myapp-1      | 	max.block.ms = 60000
myapp-1      | 	max.in.flight.requests.per.connection = 5
myapp-1      | 	max.request.size = 1048576
myapp-1      | 	metadata.max.age.ms = 300000
myapp-1      | 	metadata.max.idle.ms = 300000
myapp-1      | 	metric.reporters = []
myapp-1      | 	metrics.num.samples = 2
myapp-1      | 	metrics.recording.level = INFO
myapp-1      | 	metrics.sample.window.ms = 30000
myapp-1      | 	partitioner.adaptive.partitioning.enable = true
myapp-1      | 	partitioner.availability.timeout.ms = 0
myapp-1      | 	partitioner.class = null
myapp-1      | 	partitioner.ignore.keys = false
myapp-1      | 	receive.buffer.bytes = 32768
myapp-1      | 	reconnect.backoff.max.ms = 1000
myapp-1      | 	reconnect.backoff.ms = 50
myapp-1      | 	request.timeout.ms = 30000
myapp-1      | 	retries = 2147483647
myapp-1      | 	retry.backoff.ms = 100
myapp-1      | 	sasl.client.callback.handler.class = null
myapp-1      | 	sasl.jaas.config = null
myapp-1      | 	sasl.kerberos.kinit.cmd = /usr/bin/kinit
myapp-1      | 	sasl.kerberos.min.time.before.relogin = 60000
myapp-1      | 	sasl.kerberos.service.name = null
myapp-1      | 	sasl.kerberos.ticket.renew.jitter = 0.05
myapp-1      | 	sasl.kerberos.ticket.renew.window.factor = 0.8
myapp-1      | 	sasl.login.callback.handler.class = null
myapp-1      | 	sasl.login.class = null
myapp-1      | 	sasl.login.connect.timeout.ms = null
myapp-1      | 	sasl.login.read.timeout.ms = null
myapp-1      | 	sasl.login.refresh.buffer.seconds = 300
myapp-1      | 	sasl.login.refresh.min.period.seconds = 60
myapp-1      | 	sasl.login.refresh.window.factor = 0.8
myapp-1      | 	sasl.login.refresh.window.jitter = 0.05
myapp-1      | 	sasl.login.retry.backoff.max.ms = 10000
myapp-1      | 	sasl.login.retry.backoff.ms = 100
myapp-1      | 	sasl.mechanism = GSSAPI
myapp-1      | 	sasl.oauthbearer.clock.skew.seconds = 30
myapp-1      | 	sasl.oauthbearer.expected.audience = null
myapp-1      | 	sasl.oauthbearer.expected.issuer = null
myapp-1      | 	sasl.oauthbearer.jwks.endpoint.refresh.ms = 3600000
myapp-1      | 	sasl.oauthbearer.jwks.endpoint.retry.backoff.max.ms = 10000
myapp-1      | 	sasl.oauthbearer.jwks.endpoint.retry.backoff.ms = 100
myapp-1      | 	sasl.oauthbearer.jwks.endpoint.url = null
myapp-1      | 	sasl.oauthbearer.scope.claim.name = scope
myapp-1      | 	sasl.oauthbearer.sub.claim.name = sub
myapp-1      | 	sasl.oauthbearer.token.endpoint.url = null
myapp-1      | 	security.protocol = PLAINTEXT
myapp-1      | 	security.providers = null
myapp-1      | 	send.buffer.bytes = 131072
myapp-1      | 	socket.connection.setup.timeout.max.ms = 30000
myapp-1      | 	socket.connection.setup.timeout.ms = 10000
myapp-1      | 	ssl.cipher.suites = null
myapp-1      | 	ssl.enabled.protocols = [TLSv1.2, TLSv1.3]
myapp-1      | 	ssl.endpoint.identification.algorithm = https
myapp-1      | 	ssl.engine.factory.class = null
myapp-1      | 	ssl.key.password = null
myapp-1      | 	ssl.keymanager.algorithm = SunX509
myapp-1      | 	ssl.keystore.certificate.chain = null
myapp-1      | 	ssl.keystore.key = null
myapp-1      | 	ssl.keystore.location = null
myapp-1      | 	ssl.keystore.password = null
myapp-1      | 	ssl.keystore.type = JKS
myapp-1      | 	ssl.protocol = TLSv1.3
myapp-1      | 	ssl.provider = null
myapp-1      | 	ssl.secure.random.implementation = null
kafka-1      | [2024-09-04 17:17:33,389] INFO [Admin Manager on Broker 1]: Error processing create topic request CreatableTopic(name='__transaction_state', numPartitions=50, replicationFactor=3, assignments=[], configs=[CreateableTopicConfig(name='compression.type', value='uncompressed'), CreateableTopicConfig(name='cleanup.policy', value='compact'), CreateableTopicConfig(name='min.insync.replicas', value='2'), CreateableTopicConfig(name='segment.bytes', value='104857600'), CreateableTopicConfig(name='unclean.leader.election.enable', value='false')]) (kafka.server.ZkAdminManager)
myapp-1      | 	ssl.trustmanager.algorithm = PKIX
kafka-1      | org.apache.kafka.common.errors.InvalidReplicationFactorException: Replication factor: 3 larger than available brokers: 1.
myapp-1      | 	ssl.truststore.certificates = null
myapp-1      | 	ssl.truststore.location = null
myapp-1      | 	ssl.truststore.password = null
myapp-1      | 	ssl.truststore.type = JKS
myapp-1      | 	transaction.timeout.ms = 60000
myapp-1      | 	transactional.id = order-transaction-id0
myapp-1      | 	value.serializer = class org.springframework.kafka.support.serializer.JsonSerializer
myapp-1      |
myapp-1      | 2024-09-04T17:17:33.368Z  INFO 1 --- [myapp] [nio-8080-exec-1] o.a.k.clients.producer.KafkaProducer     : [Producer clientId=producer-order-transaction-id0, transactionalId=order-transaction-id0] Instantiated a transactional producer.
myapp-1      | 2024-09-04T17:17:33.381Z  INFO 1 --- [myapp] [nio-8080-exec-1] o.a.kafka.common.utils.AppInfoParser     : Kafka version: 3.4.0
myapp-1      | 2024-09-04T17:17:33.381Z  INFO 1 --- [myapp] [nio-8080-exec-1] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: 2e1947d240607d53
myapp-1      | 2024-09-04T17:17:33.381Z  INFO 1 --- [myapp] [nio-8080-exec-1] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1725470253381
myapp-1      | 2024-09-04T17:17:33.383Z  INFO 1 --- [myapp] [nio-8080-exec-1] o.a.k.c.p.internals.TransactionManager   : [Producer clientId=producer-order-transaction-id0, transactionalId=order-transaction-id0] Invoking InitProducerId for the first time in order to acquire a producer ID
myapp-1      | 2024-09-04T17:17:33.388Z  INFO 1 --- [myapp] [transaction-id0] org.apache.kafka.clients.Metadata        : [Producer clientId=producer-order-transaction-id0, transactionalId=order-transaction-id0] Cluster ID: PHyQKzzpTaaKO8vBZmtK_Q
kafka-1      | [2024-09-04 17:17:33,496] INFO [Admin Manager on Broker 1]: Error processing create topic request CreatableTopic(name='__transaction_state', numPartitions=50, replicationFactor=3, assignments=[], configs=[CreateableTopicConfig(name='compression.type', value='uncompressed'), CreateableTopicConfig(name='cleanup.policy', value='compact'), CreateableTopicConfig(name='min.insync.replicas', value='2'), CreateableTopicConfig(name='segment.bytes', value='104857600'), CreateableTopicConfig(name='unclean.leader.election.enable', value='false')]) (kafka.server.ZkAdminManager)
kafka-1      | org.apache.kafka.common.errors.InvalidReplicationFactorException: Replication factor: 3 larger than available brokers: 1.