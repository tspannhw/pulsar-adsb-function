# pulsar-adsb-function
Apache Pulsar Function to parse ADS-B Aircraft JSON


### Raw Topic

* persistent://public/default/adsbraw

### Output Topics

* persistent://public/default/adsbdead
* persistent://public/default/adsblog
* persistent://public/default/aircraft


### Function Deployment

````
bin/pulsar-admin functions status --name ADSB


bin/pulsar-admin functions stop --name ADSB --namespace default --tenant public
bin/pulsar-admin functions delete --name ADSB --namespace default --tenant public

bin/pulsar-admin functions create --auto-ack true --jar /opt/demo/java/pulsar-adsb-function/target/adsb-1.0.jar --classname "dev.pulsarfunction.adsb.ADSBFunction" --dead-letter-topic "persistent://public/default/adsbdead" --inputs "persistent://public/default/adsbraw" --log-topic "persistent://public/default/adsblog" --name ADSB --namespace default --tenant public --max-message-retries 5



````



### Data parsed by Pulsar Function and sent to persistent://public/default/aircraft

````
bin/pulsar-client consume "persistent://public/default/aircraft" -s "aircraftconsumer" -n 0

----- got message -----
key:[178cbf7b-f52d-4a7f-b072-dfef8b53fa8a], properties:[language=Java], content:{"flight":"N816SR","category":"A1","emergency":"none","squawk":1540,"hex":"ab2146","gs":170.8,"track":199.5,"lat":40.163409,"lon":-74.753411,"nic":9,"rc":75,"version":2,"sil":3,"gva":2,"sda":2,"mlat":[],"tisb":[],"messages":2291,"seen":0.8,"rssi":-18.5}
----- got message -----
key:[0677e81a-57f1-41a5-96c3-f57277498c79], properties:[language=Java], content:{"flight":"N333BD","category":"A1","emergency":"none","squawk":1352,"hex":"a3a111","gs":377.8,"track":226.9,"lat":40.160706,"lon":-75.335388,"nic":9,"rc":75,"version":2,"sil":3,"gva":2,"sda":2,"mlat":[],"tisb":[],"messages":4830,"seen":0.6,"rssi":-21.1}
----- got message -----
key:[c480cd8e-a803-47fe-81b4-aafdec0f6b68], properties:[language=Java], content:{"flight":"N86HZ","category":"A7","emergency":"none","squawk":1200,"hex":"abcd45","gs":52.2,"track":106.7,"lat":40.219757,"lon":-74.580566,"nic":9,"rc":75,"version":2,"sil":3,"gva":2,"sda":2,"mlat":[],"tisb":[],"messages":2259,"seen":1.1,"rssi":-19.9}

````

### Flink SQL

````
CREATE CATALOG pulsar WITH (
   'type' = 'pulsar-catalog',
   'catalog-service-url' = 'pulsar://localhost:6650',
   'catalog-admin-url' = 'http://localhost:8080'
);

USE CATALOG pulsar;

SHOW CURRENT DATABASE;
SHOW DATABASES;

set table.dynamic-table-options.enabled = true;

use `public/default`;

show tables;


describe aircraft;


Flink SQL> describe aircraft;
+------------------+--------+------+-----+--------+-----------+
|             name |   type | null | key | extras | watermark |
+------------------+--------+------+-----+--------+-----------+
|         alt_baro |    INT | TRUE |     |        |           |
|         alt_geom |    INT | TRUE |     |        |           |
|        baro_rate |    INT | TRUE |     |        |           |
|         category | STRING | TRUE |     |        |           |
|        emergency | STRING | TRUE |     |        |           |
|           flight | STRING | TRUE |     |        |           |
|               gs | DOUBLE | TRUE |     |        |           |
|              gva |    INT | TRUE |     |        |           |
|              hex | STRING | TRUE |     |        |           |
|              lat | DOUBLE | TRUE |     |        |           |
|              lon | DOUBLE | TRUE |     |        |           |
|             mach | DOUBLE | TRUE |     |        |           |
|         messages |    INT | TRUE |     |        |           |
|            nac_p |    INT | TRUE |     |        |           |
|            nac_v |    INT | TRUE |     |        |           |
| nav_altitude_mcp |    INT | TRUE |     |        |           |
|      nav_heading | DOUBLE | TRUE |     |        |           |
|          nav_qnh | DOUBLE | TRUE |     |        |           |
|              nic |    INT | TRUE |     |        |           |
|         nic_baro |    INT | TRUE |     |        |           |
|               rc |    INT | TRUE |     |        |           |
|             rssi | DOUBLE | TRUE |     |        |           |
|              sda |    INT | TRUE |     |        |           |
|             seen | DOUBLE | TRUE |     |        |           |
|        seen_post | DOUBLE | TRUE |     |        |           |
|              sil |    INT | TRUE |     |        |           |
|         sil_type | STRING | TRUE |     |        |           |
|            speed | DOUBLE | TRUE |     |        |           |
|           squawk |    INT | TRUE |     |        |           |
|            track | DOUBLE | TRUE |     |        |           |
|          version |    INT | TRUE |     |        |           |
+------------------+--------+------+-----+--------+-----------+
31 rows in set


> show create table aircraft;
CREATE TABLE `pulsar`.`public/default`.`aircraft` (
  `alt_baro` INT,
  `alt_geom` INT,
  `baro_rate` INT,
  `category` VARCHAR(2147483647),
  `emergency` VARCHAR(2147483647),
  `flight` VARCHAR(2147483647),
  `gs` DOUBLE,
  `gva` INT,
  `hex` VARCHAR(2147483647),
  `lat` DOUBLE,
  `lon` DOUBLE,
  `mach` DOUBLE,
  `messages` INT,
  `nac_p` INT,
  `nac_v` INT,
  `nav_altitude_mcp` INT,
  `nav_heading` DOUBLE,
  `nav_qnh` DOUBLE,
  `nic` INT,
  `nic_baro` INT,
  `rc` INT,
  `rssi` DOUBLE,
  `sda` INT,
  `seen` DOUBLE,
  `seen_post` DOUBLE,
  `sil` INT,
  `sil_type` VARCHAR(2147483647),
  `speed` DOUBLE,
  `squawk` INT,
  `track` DOUBLE,
  `version` INT
) WITH (
  'connector' = 'pulsar',
  'topics' = 'persistent://public/default/aircraft',
  'format' = 'json',
  'admin-url' = 'http://localhost:8080',
  'service-url' = 'pulsar://localhost:6650'
)

````