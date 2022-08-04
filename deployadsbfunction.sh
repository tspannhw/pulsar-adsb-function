bin/pulsar-admin functions stop --name ADSB --namespace default --tenant public
bin/pulsar-admin functions delete --name ADSB --namespace default --tenant public
bin/pulsar-admin functions create --auto-ack true --jar /opt/demo/java/pulsar-adsb-function/target/adsb-1.0.jar --classname "dev.pulsarfunction.adsb.ADSBFunction" --dead-letter-topic "persistent://public/default/adsbdead" --inputs "persistent://public/default/adsbraw" --log-topic "persistent://public/default/adsblog" --name ADSB --namespace default --tenant public --max-message-retries 5
